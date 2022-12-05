package com.htec.microservicecourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.htec.commonsstudents.models.entity",
	  	    "com.htec.microservicecourses.models.entity"})
public class MicroserviceCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCoursesApplication.class, args);
	}

}
