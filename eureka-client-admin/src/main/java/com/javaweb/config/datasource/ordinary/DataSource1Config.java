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

import com.javaweb.config.datasource.mysql.MysqlDateSource1;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.mybatis.interceptor.MyBatisBaseDaoInterceptor;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages=SystemConstant.DATA_SOURCE_PACKAGE_DS1,sqlSessionFactoryRef=SystemConstant.DATA_SOURCE_SQL_SESSION_FACTORY_1)
public class DataSource1Config {
	
    @Value("${mybatis1.mapperLocations}")
    private String mybatisMapperLocations;
    
	@Autowired
	private MysqlDateSource1 mysqlDateSource1;
	
	@Autowired
	private MyBatisBaseDaoInterceptor myBatisBaseDaoInterceptor;

	@Bean(SystemConstant.DATA_SOURCE_KEY_1)
	public DataSource mysql_d1() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setJdbcUrl(mysqlDateSource1.getUrl());
		hikariDataSource.setDriverClassName(mysqlDateSource1.getDriverClassName());
		hikariDataSource.setUsername(mysqlDateSource1.getUsername());
		hikariDataSource.setPassword(mysqlDateSource1.getPassword());
		hikariDataSource.setMinimumIdle(mysqlDateSource1.getMinimumIdle());
		hikariDataSource.setMaximumPoolSize(mysqlDateSource1.getMaximumPoolSize());
		hikariDataSource.setMaxLifetime(mysqlDateSource1.getMaxLifetime());
		return hikariDataSource;
		/** 参考pom.xml#spring-boot-starter-jta-atomikos
		//如果Hikari数据源支持XA事务，那么也可以将MysqlXADataSource变为类似HikariXaDataSource
		MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
		mysqlXADataSource.setUrl(mysqlDateSource1.getUrl());
		mysqlXADataSource.setUser(mysqlDateSource1.getUsername());
		mysqlXADataSource.setPassword(mysqlDateSource1.getPassword());
		//mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
		atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
		atomikosDataSourceBean.setUniqueResourceName(SystemConstant.DATA_SOURCE_KEY_1);
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
	
	@Bean(SystemConstant.DATA_SOURCE_D1_JDBCTEMPLATE)
    public JdbcTemplate mysql_d1_JdbcTemplate(@Qualifier(SystemConstant.DATA_SOURCE_KEY_1) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
	
	@Bean(SystemConstant.DATA_SOURCE_SQL_SESSION_FACTORY_1)
    public SqlSessionFactory sqlSessionFactory1(@Qualifier(SystemConstant.DATA_SOURCE_KEY_1) DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage/*environment.getProperty("mybatis.typeAliasesPackage"[,String.class])*/);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapperLocations));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{myBatisBaseDaoInterceptor});
        return sqlSessionFactoryBean.getObject();
    }
	
}
