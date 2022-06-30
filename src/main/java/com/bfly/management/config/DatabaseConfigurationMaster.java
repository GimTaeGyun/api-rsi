package com.bfly.management.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@MapperScan(basePackages = "com.bfly.management.mapper.master", sqlSessionFactoryRef = "msaterSqlSessionFactory")
@EnableTransactionManagement
public class DatabaseConfigurationMaster {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean(name = "MasterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.master")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	
	@Bean(name = "msaterSqlSessionFactory")
	public SqlSessionFactory msaterSqlSessionFactory(@Qualifier("MasterDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(this.applicationContext.getResources("classpath:/mapper/master/*Mapper.xml"));

		// 환경설정
		org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
		myBatisConfig.setMapUnderscoreToCamelCase(true);
		myBatisConfig.setMultipleResultSetsEnabled(true);
		sqlSessionFactory.setConfiguration(myBatisConfig);
		sqlSessionFactory.setTypeAliasesPackage("com.bfly.management.model");

		return sqlSessionFactory.getObject();
	}

	
	@Bean(name = "msaterSqlSessionTemplate")
	public SqlSessionTemplate msaterSqlSessionTemplate(
			@Qualifier("msaterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean(name = "masterTransactionManager")
	public PlatformTransactionManager masterTransactionManager(@Qualifier("MasterDataSource") DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		dataSourceTransactionManager.setNestedTransactionAllowed(true);
		return dataSourceTransactionManager;
	}

}