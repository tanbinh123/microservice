package com.javaweb.config.datasource.ordinary;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.javaweb.config.datasource.mysql.MysqlDateSource2;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.mybatis.interceptor.MyBatisBaseDaoInterceptor;

@Configuration
@MapperScan(basePackages=SystemConstant.DATA_SOURCE_PACKAGE_DS2,sqlSessionFactoryRef=SystemConstant.DATA_SOURCE_SQL_SESSION_FACTORY_2)
public class DataSource2Config {
	
    @Value("${mybatis2.mapperLocations}")
    private String mybatisMapperLocations;
	
	@Autowired
	private MysqlDateSource2 mysqlDateSource2;
	
	@Autowired
	private MyBatisBaseDaoInterceptor myBatisBaseDaoInterceptor;
	
	@Bean(SystemConstant.DATA_SOURCE_KEY_2)
	public DataSource mysql_d2() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl(mysqlDateSource2.getUrl());
		druidDataSource.setDriverClassName(mysqlDateSource2.getDriverClassName());
		druidDataSource.setUsername(mysqlDateSource2.getUsername());
		druidDataSource.setPassword(mysqlDateSource2.getPassword());
		druidDataSource.setInitialSize(mysqlDateSource2.getInitialSize());
		druidDataSource.setMinIdle(mysqlDateSource2.getMinIdle());
		druidDataSource.setMaxActive(mysqlDateSource2.getMaxActive());
		druidDataSource.setTestWhileIdle(mysqlDateSource2.getTestWhileIdle());
		druidDataSource.setMaxWait(mysqlDateSource2.getMaxWait());
		return druidDataSource;
		/** 参考pom.xml#spring-boot-starter-jta-atomikos
		//如果Druid数据源支持XA事务，那么也可以将MysqlXADataSource变为类似DruidXaDataSource
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(mysqlDateSource2.getUrl());
		mysqlXADataSource.setUser(mysqlDateSource2.getUsername());
		mysqlXADataSource.setPassword(mysqlDateSource2.getPassword());
		//mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
		atomikosDataSourceBean.setUniqueResourceName(SystemConstant.DATA_SOURCE_KEY_2);
		atomikosDataSourceBean.setPoolSize(10);
		atomikosDataSourceBean.setMaxPoolSize(100);
		atomikosDataSourceBean.setBorrowConnectionTimeout(300);
		//atomikosDataSourceBean.setMaxIdleTime(3600);
		//atomikosDataSourceBean.setReapTimeout(300);
		//atomikosDataSourceBean.setMaxLifetime(60000);
		//atomikosDataSourceBean.setMaintenanceInterval(60);
		//atomikosDataSourceBean.setTestQuery("select 1");
		return atomikosDataSourceBean;
		*/
	}
	
	@Bean(SystemConstant.DATA_SOURCE_D2_JDBCTEMPLATE)
    public JdbcTemplate mysql_d2_JdbcTemplate(@Qualifier(SystemConstant.DATA_SOURCE_KEY_2) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
	
	@Bean(SystemConstant.DATA_SOURCE_SQL_SESSION_FACTORY_2)
    public SqlSessionFactory sqlSessionFactory2(@Qualifier(SystemConstant.DATA_SOURCE_KEY_2) DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage/*environment.getProperty("mybatis.typeAliasesPackage"[,String.class])*/);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapperLocations));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{myBatisBaseDaoInterceptor});
        return sqlSessionFactoryBean.getObject();
    }
	
}
