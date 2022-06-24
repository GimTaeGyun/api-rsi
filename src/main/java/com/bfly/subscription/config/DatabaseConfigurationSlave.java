package com.bfly.subscription.config;

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
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.bfly.subscription.mapper.slave", sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class DatabaseConfigurationSlave {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari.slave")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(this.applicationContext.getResources("classpath:/mapper/slave/*Mapper.xml"));

		// 환경설정
		org.apache.ibatis.session.Configuration myBatisConfig = new org.apache.ibatis.session.Configuration();
		myBatisConfig.setMapUnderscoreToCamelCase(true);
		myBatisConfig.setMultipleResultSetsEnabled(true);
		sqlSessionFactory.setConfiguration(myBatisConfig);
		sqlSessionFactory.setTypeAliasesPackage("com.bfly.subscription.model");

		return sqlSessionFactory.getObject();
	}

	@Bean(name = "slaveSqlSessionTemplate")
	public SqlSessionTemplate slaveSqlSessionTemplate(
			@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}