package com.ssafy.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration // @Bean 을 활용하여 빈 객체를 스프링 컨테이너에 등록시 사용
@ComponentScan(basePackages= {"com.ssafy"}) //annotation방식의context:component-scan과 동일
public class ApplicationConfig {
	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource sdds = new SimpleDriverDataSource();
		sdds.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		sdds.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		sdds.setUsername("ssafy");
		sdds.setPassword("ssafy");
		return sdds;
	}
	
}
