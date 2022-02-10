package com.javaweb.config.datasource.ordinary;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.javaweb.annotation.datasource.DataSource;
import com.javaweb.constant.SystemConstant;

/** 
多数据源这里提供了3种方式
1、包命名方式：采用mybatis时要注意不同数据源对应的dao接口名称不要一样，比如可以一个叫UserDao一个叫UserDao2，如果一样会报：Specified class is an interface
2、注解的方式：@Mapper上加上如@DataSource(value="ds1")即可
3、JdbcTemplate的方式：采用@Qualifier标注使用的数据源，然后直接使用如： mysql_d1_JdbcTemplate.query("select * from user where id = ?",new Object[]{"1"},new BeanPropertyRowMapper<User>(User.class))
注意：
1、一个方法内有多数据源操作不使用事务管理（@Transactional），多数据源可以起作用
2、一个方法内有多数据源操作且有事务管理（@Transactional），多数据源将不起作用，因为@Transactional将优先覆盖AOP
3、一个方法内有多数据源操作且使用手动提交事务，如果直接使用注入的DataSourceTransactionManager，多数据源将不起作用，因为使用的始终是同一个DataSourceTransactionManager实例
4、多数据源又有事务，普遍解法有三种：JTA、TCC、消息中间件
5、个人提供一个基于多线程、手动提交回滚事务、Callable和Future的思路（有点复杂，但很有效）
@Autowired
@Qualifier("mysql_d1")
private DataSource dataSource1;
@Autowired
@Qualifier("mysql_d2")
private DataSource dataSource2;
@Autowired
private TransactionDefinition transactionDefinition;
new Thread(()->{
	DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	dstm.setDataSource(dataSource1);
	TransactionStatus transactionStatus = dstm.getTransaction(transactionDefinition);
	//数据源1操作
	dstm.commit(transactionStatus);//手动提交事务
	//dstm.rollback(transactionStatus);//手动回滚事务
}).start();
new Thread(()->{
	DataSourceTransactionManager dstm = new DataSourceTransactionManager();
	dstm.setDataSource(dataSource2);
	TransactionStatus transactionStatus = dstm.getTransaction(transactionDefinition);
	//数据源2操作
	dstm.commit(transactionStatus);//手动提交事务
	//dstm.rollback(transactionStatus);//手动回滚事务
}).start();
6、分布式事务XA主要有三种解决方案：Atomikos、Hmily、Narayana
*/
@Aspect
@Component
public class DataSourceAspect {

	//这里写具体的数据源切换逻辑
	@Before(value=SystemConstant.DEFAULT_DATA_SOURCE_POINT_CUT)
	public void beforeMethod(JoinPoint joinPoint) throws Throwable {
	    Class<?> targetClass = joinPoint.getTarget().getClass();
	    if(targetClass!=null){
	        for(Class<?> interfaceClass:targetClass.getInterfaces()) {//获得接口类
	            DataSource dataSource = interfaceClass.getAnnotation(DataSource.class);
	            if(dataSource!=null) {//优先注解
	                String value = dataSource.value();
	                if(SystemConstant.DATA_SOURCE_PACKAGE_NAME_1.equals(value)) {
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_1);//数据源1的位置
	                }else if(SystemConstant.DATA_SOURCE_PACKAGE_NAME_2.equals(value)) {
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_2);//数据源2的位置
	                }else {
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_1);
	                }
	            }else {//次优先包
	                String packagePathDao = interfaceClass.getName();//joinPoint.getStaticPart().getSignature().getDeclaringTypeName();
	                if(packagePathDao.contains(SystemConstant.DATA_SOURCE_PACKAGE_NAME_1)){//数据源1的位置
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_1);
	                }else if(packagePathDao.contains(SystemConstant.DATA_SOURCE_PACKAGE_NAME_2)){//数据源2的位置
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_2);
	                }else {//默认数据源
	                    MultipleDataSourceManage.setDataSourceKey(SystemConstant.DATA_SOURCE_KEY_1);
	                }
	            }
	        }
	    }
	}
	
	@After(value=SystemConstant.DEFAULT_DATA_SOURCE_POINT_CUT)
	public void afterMethod(JoinPoint joinPoint) throws Throwable {
		MultipleDataSourceManage.clearDbType();
	}
	
}
