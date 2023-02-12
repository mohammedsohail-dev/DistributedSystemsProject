package com.skiers.project;


import org.springframework.boot.web.servlet.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ServletComponentScan
@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProjectApplication.class, args);
	}

}
