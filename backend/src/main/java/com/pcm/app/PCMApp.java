package com.pcm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.pcm.controllers.PCMRepoController;
import com.pcm.repo.EmployeeRepoService;
import com.pcm.repo.LocationRepoService;
import com.pcm.repo.PCRepoService;


@EntityScan("com.pcm.*")
@EnableJpaRepositories(value="com.pcm.repo")

@SpringBootApplication
public class PCMApp {

	public PCMApp() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public PCMRepoController pcmRepoController(){
		return new PCMRepoController();
	}
	
	
	@Bean
	public EmployeeRepoService employeeRepoService(){
		return new EmployeeRepoService();
	}
	

	@Bean
	public PCRepoService pcRepoService(){
		return new PCRepoService();
	}
	

	@Bean
	public LocationRepoService locationRepoService(){
		return new LocationRepoService();
	}
	
	
	@Bean
	public UrlBasedViewResolver setUpViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(PCMApp.class, args);
		
	}
}
