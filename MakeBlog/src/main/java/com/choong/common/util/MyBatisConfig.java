//package com.choong.common.util;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MyBatisConfig {
//
//	@Autowired
//	private MyBatisProperties properties;
//
//	@Bean
//	public DataSource dataSourceForMyBatis() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName(properties.getDriverClassName());
//		dataSource.setUrl(properties.getUrl());
//		dataSource.setUsername(properties.getUsername());
//		dataSource.setPassword(properties.getPassword());
//		return dataSource;
//	}
//
//	@Bean
//	public SqlSessionFactoryBean sqlSessionFactoryForMyBatis(DataSource dataSource) {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		sqlSessionFactoryBean.setConfigLocation(properties.getConfigLocation());
//		sqlSessionFactoryBean.setMapperLocations(properties.getMapperLocations());
//		return sqlSessionFactoryBean;
//	}
//
//	@Bean
//	public SqlSession sqlSessionForMyBatis(SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//
//}