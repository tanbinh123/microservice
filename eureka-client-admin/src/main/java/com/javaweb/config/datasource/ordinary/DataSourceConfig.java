package com.javaweb.config.datasource.ordinary;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;
import com.javaweb.config.datasource.mysql.MysqlDateSource1;
import com.javaweb.config.datasource.mysql.MysqlDateSource2;
import com.javaweb.constant.SystemConstant;
import com.javaweb.db.mybatis.interceptor.MyBatisBaseDaoInterceptor;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
    @Value("${mybatis.mapperLocations}")
    private String mybatisMapperLocations;
    
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;
	
	@Autowired
	private MysqlDateSource1 mysqlDateSource1;
	
	@Autowired
	private MysqlDateSource2 mysqlDateSource2;
	
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
	}
	
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
	}
	
	@Bean("mysql_d1_JdbcTemplate")
    public JdbcTemplate mysql_d1_JdbcTemplate(@Qualifier(SystemConstant.DATA_SOURCE_KEY_1) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("mysql_d2_JdbcTemplate")
    public JdbcTemplate mysql_d2_JdbcTemplate(@Qualifier(SystemConstant.DATA_SOURCE_KEY_2) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
	
	@Primary
	@Bean("multipleDataSourceManage")
    public MultipleDataSourceManage multipleDataSourceManage() {
		MultipleDataSourceManage multipleDataSourceManage = new MultipleDataSourceManage();
        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(SystemConstant.DATA_SOURCE_KEY_1,mysql_d1());
        dataSourceMap.put(SystemConstant.DATA_SOURCE_KEY_2,mysql_d2());
        //将mysql_d1数据源作为默认指定的数据源
        multipleDataSourceManage.setDefaultTargetDataSource(mysql_d1());
        multipleDataSourceManage.setTargetDataSources(dataSourceMap);
        //将数据源的key放到数据源上下文的key集合中,用于切换时判断数据源是否有效
        return multipleDataSourceManage;
    }
	
	@Bean
    public SqlSessionFactory sqlSessionFactory(MultipleDataSourceManage multipleDataSourceManage) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(multipleDataSourceManage);
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage/*environment.getProperty("mybatis.typeAliasesPackage"[,String.class])*/);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatisMapperLocations));
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{myBatisBaseDaoInterceptor});
        return sqlSessionFactoryBean.getObject();
    }
	
}
