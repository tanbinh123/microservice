package com.javaweb.util.core;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import com.javaweb.constant.CommonConstant;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

public class HttpUtil {
	
	private static SSLContext sslContext = null;
	
	static{
		try{
			SSLContext sSLContext = new SSLContextBuilder().loadTrustMaterial(null,new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] arg0,String arg1) {
					return true;
				}
			}).setProtocol("TLSv1.2").build();
			sslContext = sSLContext;
		}catch(Exception e){
			
		}
	}
	
	//忽略HTTPS证书
    public static CloseableHttpClient getCloseableHttpClientWithoutCertificate() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] arg0,String arg1) throws CertificateException {
                	
                }
                public void checkServerTrusted(X509Certificate[] arg0,String arg1) throws CertificateException {
                	
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx,NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();
            return httpclient;
        } catch (Exception e) {
            return HttpClients.createDefault();
        }
    }
	
	//获得HTTP或HTTPS连接
	public static CloseableHttpClient getCloseableHttpClient(String url) {
		return getCloseableHttpClient(url,null);
	}
	
	//获得HTTP或HTTPS连接
	public static CloseableHttpClient getCloseableHttpClient(String url,HttpHost httpHost) {
		//HttpHost proxy = new HttpHost(ip,port); 
		HttpClientBuilder httpClientBuilder = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler(3,false));
		if(url.contains("https")){
			SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext);
			//上面不行的话，请尝试下面的写法，其实上面的写法已经能满足了，之所以可能会用到下面的写法是因为有些地方强制必须唯一使用https，而有些地方可以兼容同时使用http和https
			//SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial(null,new TrustSelfSignedStrategy()).build(),NoopHostnameVerifier.INSTANCE);
			httpClientBuilder.setSSLSocketFactory(sslcsf);
			if(httpHost!=null){
				httpClientBuilder.setRoutePlanner(new DefaultProxyRoutePlanner(httpHost));
			}
		}
		return httpClientBuilder.build();
	}
	
	//获得默认请求设置
	public static RequestConfig getDefaultRequestConfig() {
		Builder builder = RequestConfig.custom();
		builder.setConnectTimeout(10*1000).setSocketTimeout(10*1000);
		return builder.build();
	}
	
	//获取URL连接
	public static URLConnection getURLConnection(String url) throws Exception {
		return new URL(url).openConnection();
	}
	
	//默认GET请求
	public static String defaultGetRequest(String url,List<Header> list) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Content-Type","application/json;charset=UTF-8");
		if(list!=null&&list.size()!=0) {
			list.stream().forEach(i->httpGet.setHeader(i));
		}
		httpGet.setConfig(getDefaultRequestConfig());
		HttpResponse httpResponse = httpClient.execute(httpGet);
		String response = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			/** 返回流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(byteArrayOutputStream);
			byteArrayOutputStream.toByteArray();
			*/
			/** 返回json字符串
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = new ObjectMapper().readValue(httpEntity.getContent(),String.class);
			String response = IOUtils.toString(httpEntity.getContent(),StandardCharsets.UTF_8);
			*/
		}
		httpClient.close();
		return response;
	}
	
	//默认POST请求
	public static String defaultPostRequest(String url,String body,List<Header> list) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
		if(list!=null&&list.size()!=0) {
			list.stream().forEach(i->httpPost.setHeader(i));
		}
		httpPost.setConfig(getDefaultRequestConfig());
		if((body!=null)&&(!(body.trim().equals(CommonConstant.EMPTY_VALUE)))) {
			StringEntity stringEntity = new StringEntity(body,StandardCharsets.UTF_8);
			httpPost.setEntity(stringEntity);
		}
		HttpResponse httpResponse = httpClient.execute(httpPost);
		String response = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			/** 返回流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(byteArrayOutputStream);
			byteArrayOutputStream.toByteArray();
			*/
			/** 返回json字符串
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = new ObjectMapper().readValue(httpEntity.getContent(),String.class);
			String response = IOUtils.toString(httpEntity.getContent(),StandardCharsets.UTF_8);
			*/
		}
		httpClient.close();
		return response;
	}
	
	//默认PUT请求
	public static String defaultPutRequest(String url,String body,List<Header> list) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		HttpPut httpPut = new HttpPut(url);
		httpPut.setHeader("Content-Type","application/json;charset=UTF-8");
		if(list!=null&&list.size()!=0) {
			list.stream().forEach(i->httpPut.setHeader(i));
		}
		httpPut.setConfig(getDefaultRequestConfig());
		if((body!=null)&&(!(body.trim().equals(CommonConstant.EMPTY_VALUE)))) {
			StringEntity stringEntity = new StringEntity(body,StandardCharsets.UTF_8);
			httpPut.setEntity(stringEntity);
		}
		HttpResponse httpResponse = httpClient.execute(httpPut);
		String response = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			/** 返回流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(byteArrayOutputStream);
			byteArrayOutputStream.toByteArray();
			*/
			/** 返回json字符串
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = new ObjectMapper().readValue(httpEntity.getContent(),String.class);
			String response = IOUtils.toString(httpEntity.getContent(),StandardCharsets.UTF_8);
			*/
		}
		httpClient.close();
		return response;
	}
	
	//默认DELETE请求
	public static String defaultDeleteRequest(String url,String body,List<Header> list) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		HttpDelete httpDelete = new HttpDelete(url);
		httpDelete.setHeader("Content-Type","application/json;charset=UTF-8");
		if(list!=null&&list.size()!=0) {
			list.stream().forEach(i->httpDelete.setHeader(i));
		}
		httpDelete.setConfig(getDefaultRequestConfig());
		HttpResponse httpResponse = httpClient.execute(httpDelete);
		String response = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			/** 返回流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(byteArrayOutputStream);
			byteArrayOutputStream.toByteArray();
			*/
			/** 返回json字符串
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = new ObjectMapper().readValue(httpEntity.getContent(),String.class);
			String response = IOUtils.toString(httpEntity.getContent(),StandardCharsets.UTF_8);
			*/
		}
		httpClient.close();
		return response;
	}
	
	//XML格式的POST请求
	public static String xmlPostRequest(String url,String body) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
		httpPost.setConfig(getDefaultRequestConfig());
		StringEntity stringEntity = new StringEntity(body,StandardCharsets.UTF_8);
		httpPost.setEntity(stringEntity);
		HttpResponse httpResponse = httpClient.execute(httpPost);
		String response = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			response = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			/** 返回流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			httpResponse.getEntity().writeTo(byteArrayOutputStream);
			byteArrayOutputStream.toByteArray();
			*/
			/** 返回json字符串
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = new ObjectMapper().readValue(httpEntity.getContent(),String.class);
			String response = IOUtils.toString(httpEntity.getContent(),StandardCharsets.UTF_8);
			*/
		}
		httpClient.close();
		return response;
	}
	
	//图片流获取
	public static InputStream getInputStream(String url) throws Exception {
		CloseableHttpClient httpClient = getCloseableHttpClient(url);
		//SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		SSLConnectionSocketFactory sslcsf = new SSLConnectionSocketFactory(sslContext);
		httpClient = HttpClients.custom().setSSLSocketFactory(sslcsf).build();
		//URI uri = new URIBuilder(url).build();
		//HttpGet httpGet = new HttpGet(uri);
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		InputStream inputStream = null;
		if(httpResponse.getStatusLine().getStatusCode()==200) {
			inputStream = httpResponse.getEntity().getContent();
		}
		httpClient.close();
		return inputStream;
	}
	
	//随机生成IP地址
	public static String getRadmonIp(){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<4;i++){
			stringBuilder.append(MathUtil.getRandomNumForLCRC(0,255)).append(CommonConstant.DOT);
		}
		String out = stringBuilder.toString();
		out = out.substring(0,out.length()-1);
		return out;
	}
	
	//获取用户真实IP
	public static String getIpAddress(HttpServletRequest request){  
    	String ipAddress = request.getHeader("x-forwarded-for");  
    	if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
    	    ipAddress = request.getHeader("Proxy-Client-IP");  
    	}  
    	if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
    	    ipAddress = request.getHeader("WL-Proxy-Client-IP");  
    	}  
    	if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
    	    ipAddress = request.getRemoteAddr();  
    	    if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){  
    		//根据网卡取本机配置的IP  
    		InetAddress inet=null;  
    		try {  
    		    inet = InetAddress.getLocalHost();  
    		} catch (UnknownHostException e) {  
    		    //do nothing  
    		}  
    		ipAddress= inet.getHostAddress();  
    	    }  
    	}  
    	//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
    	if(ipAddress!=null && ipAddress.length()>15){//"***.***.***.***".length() = 15  
    	    if(ipAddress.indexOf(",")>0){  
    		ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
    	    }  
    	}  
    	return ipAddress;
	}
	
	//获得linux的ssh连接
	public static BufferedInputStream getLinuxSSH(String ip,int port,String userName,String passWord,String fileName) throws Exception {
		BufferedInputStream bis = null;
		Connection c = new Connection(ip,port);
		c.connect();
		boolean isAuthed = c.authenticateWithPassword(userName,passWord);
		if(isAuthed) {
			SCPClient scpClient = c.createSCPClient();
			bis = scpClient.get(fileName);
			//LineNumberReader lnr = new LineNumberReader(new InputStreamReader(bais,"UTF-8"));
		}
		return bis;
	}
	
	//获取host
	public static String getHost(String url){
		return URI.create(url).getHost();
	}
	
	//域名解析获取IP
	public static String getDnsIp(String host/*getHost(url)*/){
		try {
			String dnsIp = InetAddress.getByName(host).getHostAddress().toString();
			if(dnsIp==CommonConstant.NULL_VALUE){
				return CommonConstant.LOCAL_HOST_IP;//这里默认是localhost，可根据自身业务改变
			}else{
				return dnsIp;
			}
		} catch (UnknownHostException e) {
			return CommonConstant.LOCAL_HOST_IP;//这里默认是localhost，可根据自身业务改变
		}
	}
	
	//ping IP
	public static boolean pingIpSuccess(String ip/*127.0.0.1*/,String charsetName/*gbk*/){
		String line = null;
        boolean result = false;
		try{
			Process process = Runtime.getRuntime().exec("ping "+ip);
			LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(process.getInputStream(),charsetName));
			int count = 1;
        	while ((line = lineNumberReader.readLine()) != null) {
        		if(line.contains("TTL")){
        			result = true;
        			break;
        		}
        		if(count>2){
        			break;
        		}
        		count++;
            }
            lineNumberReader.close();
            process.destroy();
		}catch(Exception e){
			//do nothing
		}
		return result;
	}

}
