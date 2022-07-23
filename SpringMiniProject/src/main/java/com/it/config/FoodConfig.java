package com.it.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Spring 5 ==> Spring-Boot
@Configuration
/*
 *   <context:component-scan base-package="com.it.*"/>
     <!-- JSP 찾기 = jsp경로명 , 확장자 : ViewResolver-->
     <bean id="viewResolver"
        class="org.springframework.web.servlet.view.InternalResourceViewResolver"
        p:prefix="/"
        p:suffix=".jsp"
     />
 */
// context:component-scan base-package="com.it.*"/>
@ComponentScan(basePackages = {"com.it.*"})
// <mybatis-spring:scan base-package="com.it.mapper"/>
@MapperScan(basePackages = {"com.it.mapper"})
// <tx:annotation-driven/>
@EnableTransactionManagement
public class FoodConfig {
   /*
    *   <bean id="viewResolver"
        class="org.springframework.web.servlet.view.InternalResourceViewResolver"
        p:prefix="/"
        p:suffix=".jsp"
     />
    */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
          p:driverClassName="com.mysql.cj.jdbc.Driver"
          p:url="jdbc:mysql://localhost:3306/db0611?serverTimezone=UTC"
          p:username="root"
          p:password="1111"
       />
	 */
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/db0611?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("1111");
		return ds;
	}
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
         p:dataSource-ref="ds"
    />
     * 
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	/*
	 * <bean id="transactionManager"
       class="org.springframework.jdbc.datasource.DataSourceTransactionManager"
       p:dataSource-ref="ds"
     />
	 */
	@Bean("transactionManager")
	public DataSourceTransactionManager txManager()
	{
		DataSourceTransactionManager tx=new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
}






