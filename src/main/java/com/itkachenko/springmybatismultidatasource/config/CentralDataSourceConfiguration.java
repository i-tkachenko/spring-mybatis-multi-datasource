package com.itkachenko.springmybatismultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "**.springmybatismultidatasource.repositories.central", sqlSessionFactoryRef = "centralSqlSessionFactory")
public class CentralDataSourceConfiguration {

	@Bean("centralDataSource")
	@ConfigurationProperties(prefix = "datasource.central-database")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("centralSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Autowired @Qualifier("centralDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}
