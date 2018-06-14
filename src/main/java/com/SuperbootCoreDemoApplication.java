package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wteam.superboot.core.repository.SuperRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = SuperRepositoryFactoryBean.class)
public class SuperbootCoreDemoApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(SuperbootCoreDemoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SuperbootCoreDemoApplication.class);
	}
}
