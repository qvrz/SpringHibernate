package com.example.eureka.springeurekaclientWorker.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.example.eureka.springeurekaclientWorker.domain.WorkerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WorkerServiceController {
    private final WorkerRepository workerRepository;
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    public WorkerServiceController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }
    @GetMapping("/get")
    public List<Worker> listPeople() {
        return Lists.newArrayList(workerRepository.findAll());
    }
    @GetMapping("/add")
    public String add()
    {
        Worker w=new Worker();
        w.setDeskNr(1);
        w.setId(1);
        w.setFreedaysLeft(10);
        w.setName("pierwszy");
        w.setPosition("glazurnik");
        workerRepository.save(w);
        return "Added";
    }

}