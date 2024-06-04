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
@MapperScan(
		basePackages = "**.springmybatismultidatasource.repositories.archive",
		sqlSessionFactoryRef = "archiveSqlSessionFactory"
)
public class ArchiveDataSourceConfiguration {

	@Bean("archiveDataSource")
	@ConfigurationProperties(prefix = "datasource.archive-database")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean("archiveSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Autowired @Qualifier("archiveDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
}
