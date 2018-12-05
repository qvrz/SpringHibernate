package com.example.eureka.springeurekaclientConsumer;

import com.example.eureka.springeurekaclientWorker.domain.Errand;
import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.example.eureka.springeurekaclientWorker.domain.WorkerRepository;
import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan("com.example.eureka")
public class WorkerConsumer {
    @Autowired
    private EurekaClient eurekaClient;
    private WorkerRepository workerRepository;

    public static void main(String[] args) {
        SpringApplication.run(WorkerConsumer.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    public WorkerConsumer(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/get/{id}")
    public Worker find(@PathVariable Long id) {
        Optional<Worker> user = workerRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
    @GetMapping("/holidays/{id}/{days}")
    public String takeHolidays(@PathVariable Long id,@PathVariable int days)
    {
        Optional<Worker> user = workerRepository.findById(id);
        int daysleft=0;
        if (user.isPresent()) {
            Worker w=user.get();
            w.setFreedaysLeft(w.getFreedaysLeft()-days);
            daysleft=w.getFreedaysLeft();
            workerRepository.save(w);
        }
        return "Worker with id "+id+" have taken "+days+" days off, he still has "+daysleft+" free days";
    }
}