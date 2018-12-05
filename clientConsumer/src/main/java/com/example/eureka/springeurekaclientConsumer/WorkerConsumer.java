package com.example.eureka.springeurekaclientConsumer;

import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WorkerConsumer {
    @Autowired
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(WorkerConsumer.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/urlop/{id}/{dni}")
    public String getConf(@PathVariable("id") String id, @PathVariable("dni") String dni) {
        Application application
                = eurekaClient.getApplication("worker-service");
        List<InstanceInfo> instances = application.getInstances();
        InstanceInfo instanceInfo = instances.iterator().next();
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        ResponseEntity<Worker> responseEntity = restTemplate.getForEntity("http://" + hostname + ":" + port + "/getWorker/" + id, Worker.class);
        return "zzz...";
    }
}