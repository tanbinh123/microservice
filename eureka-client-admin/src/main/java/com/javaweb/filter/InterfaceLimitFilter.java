package com.javaweb.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ServletRequestPathUtils;

import com.javaweb.base.BaseInject;
import com.javaweb.base.BaseSystemMemory;
import com.javaweb.constant.ApiConstant;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.util.core.HttpUtil;
import com.javaweb.util.core.StringUtil;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.po.Interfaces;

/** 
//这种写法在某些版本或情况下是无效的，有时可能由于配置不当甚至报错，所以改用了@Bean形式
@Order(1)//数字越小优先级越高
@WebFilter(filterName="interfaceLimitFilter",urlPatterns={SystemConstant.URL_ALL_PATTERN})
@Component
*/
//接口限流过滤器
public class InterfaceLimitFilter implements Filter {
	
	//private final Logger urlLog = LoggerFactory.getLogger("urlLog");//自定义输出日志
	private final Logger LOG = LoggerFactory.getLogger(InterfaceLimitFilter.class);//本类日志
	
	/**
	 * httpServletRequest.getRequestURI()            -------------------- /javaweb/app/html/home.html
	 * httpServletRequest.getRequestURL().toString() -------------------- http://localhost:8080/javaweb/app/html/home.html 
	 * httpServletRequest.getServletPath()           -------------------- /app/html/home.html
	 * request.getRequestDispatcher("/test").forward(request,response);//服务端跳转
	 * response.sendRedirect(basePath+"/test");//页面端跳转
	 * System.getProperty("catalina.home")+File.separator+"webapps\\项目名称\\WEB-INF\\classes"
	 * request.getSession().getServletContext().getRealPath("/")//位于WebRoot下
	 * request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	 */
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException,ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		//HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		if(httpServletRequest.getMethod().toUpperCase().equals("OPTIONS")){//OPTIONS请求放行
			chain.doFilter(request,response);
			return;
		}
		ServletRequestPathUtils.parseAndCache(httpServletRequest);//新版本需要加上这段代码
		Interfaces interfaces = BaseSystemMemory.getMatchRequestMapping(httpServletRequest);//虽然需要遍历匹配但这是最准确的路径匹配方式
		if(interfaces!=null){
			request.setAttribute(SystemConstant.REQUEST_URL_CHAIN_ATTRIBUTE_NAME,interfaces);//便于链路取值
			String url = interfaces.getUrl();//httpServletRequest.getServletPath();//依照请求URL来限流这里并不推荐，尤其碰到一些通配URL，如/a/{x}/b/{y}或/a?id=1、/a?id=2、/a?id=2
			String limitKey = getLimitKey(url,httpServletRequest);
			BaseInject.getRedisTemplate().opsForHash().increment(SystemConstant.REDIS_INTERFACE_COUNT_KEY,url,1);//接口调用次数加1（接口调用次数统计，若不需要使用注释掉即可）
			TimeUnit timeUnit = needLimit(interfaces);
			if(timeUnit!=null){
				try{
					boolean isSuccess = interfaceCurrentLimiting(limitKey,timeUnit,Integer.parseInt(interfaces.getTimes()),Integer.parseInt(interfaces.getCounts()));
					if(isSuccess){
						chain.doFilter(request,response);
					}else{
						httpServletRequest.getRequestDispatcher(ApiConstant.REQUEST_LIMIT).forward(request,response);
					}
				}catch(Exception e){
					chain.doFilter(request,response);
				}
			}else{
				chain.doFilter(request,response);
			}
		}else{
			/**
			if(httpServletRequest.getServletPath().startsWith("/actuator")){//监控暂时请求放行
				chain.doFilter(request,response);
				return;
			}
			*/
			httpServletRequest.getRequestDispatcher(ApiConstant.NOT_FOUND).forward(request,response);
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
    public void destroy() {

    }
    
    private String getLimitKey(String url,HttpServletRequest httpServletRequest){
    	String key = CommonConstant.EMPTY_VALUE;
		TokenData tokenData = BaseInject.getTokenData(BaseInject.getToken(httpServletRequest));
		if((tokenData==null)||(tokenData.getUser()==null)||(CommonConstant.EMPTY_VALUE.equals(StringUtil.handleNullString(tokenData.getUser().getUserId())))){
			key = HttpUtil.getIpAddress(httpServletRequest) + CommonConstant.POUND + url;//禁IP
		}else{
			key = tokenData.getUser().getUserId() + CommonConstant.POUND + url;//禁用户
		}
		LOG.info("接口限流key值为："+key);
		return key;
    }
    
    private TimeUnit needLimit(Interfaces interfaces){
    	String time = interfaces.getTimes();//时间
		String unit = interfaces.getUnit();//单位
		String counts = interfaces.getCounts();//次数
    	TimeUnit timeUnit = null;
    	try{
    		//System.out.println(time+","+unit+","+counts);
        	long nullCount = Stream.of(time,unit,counts).filter(e->e==CommonConstant.NULL_VALUE||e.trim().equals(CommonConstant.EMPTY_VALUE)).count();
        	//System.out.println(nullCount);
        	if(0==nullCount){
        		if(Integer.parseInt(counts)<=Integer.MAX_VALUE){
        			if(unit.matches("[时分秒]")){//目前只支持秒分时
            			if("时".equals(unit)&&(Integer.parseInt(time)>0&&Integer.parseInt(time)<=24)){
            				timeUnit = TimeUnit.HOURS;
            			}else if("分".equals(unit)&&(Integer.parseInt(time)>0&&Integer.parseInt(time)<=60)){
            				timeUnit = TimeUnit.MINUTES;
            			}else if("秒".equals(unit)&&(Integer.parseInt(time)>0&&Integer.parseInt(time)<=60)){
            				timeUnit = TimeUnit.SECONDS;
            			}
            		}
        		}
        	}
    	}catch(Exception e){
    		//do nothing
    	}
    	return timeUnit;
    }
    
    private boolean interfaceCurrentLimiting(String key,TimeUnit timeUnit,Integer times,Integer counts) {//接口限流
    	if(BaseInject.getRedisTemplate().hasKey(key)){//记录过
    		int count = (int)BaseInject.getRedisTemplate().opsForValue().get(key);
    		if(count>=counts){
    			BaseInject.getRedisTemplate().opsForValue().set(key,counts+1,times,timeUnit);//频繁调用封禁
                return false;
    		}else{
    			BaseInject.getRedisTemplate().opsForValue().increment(key,1);
    		}
    	}else{//没有记录过
    		BaseInject.getRedisTemplate().opsForValue().set(key,1,times,timeUnit);
    	}
    	return true;
    }

}
