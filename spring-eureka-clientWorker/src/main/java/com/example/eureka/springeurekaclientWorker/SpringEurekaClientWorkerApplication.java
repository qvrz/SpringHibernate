package com.example.eureka.springeurekaclientWorker;

import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.example.eureka.springeurekaclientWorker.domain.WorkerRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@EnableEurekaClient
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.example.eureka.springeurekaclient.domain","com.example.eureka.springeurekaclientWorker.controller"})
public class SpringEurekaClientWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientWorkerApplication.class, args);
	}

}
