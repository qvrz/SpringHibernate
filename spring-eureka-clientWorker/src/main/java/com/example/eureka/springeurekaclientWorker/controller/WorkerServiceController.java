package com.example.eureka.springeurekaclientWorker.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.eureka.springeurekaclientWorker.domain.Errand;
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
    @GetMapping("/getListOfWorkers")
    public List<Worker> listPeople() {
        return Lists.newArrayList(workerRepository.findAll());
    }
    @GetMapping("/addWorkers")
    public String addSampleWorkers()
    {
        Worker w=new Worker();
        w.setDeskNr(1);
        w.setFreedaysLeft(1009);
        w.setName("Tomasz");
        w.setPosition("Szef");
        workerRepository.save(w);
        Worker t=new Worker();
        t.setDeskNr(215);
        t.setFreedaysLeft(700);
        t.setName("Karol");
        t.setPosition("Programista");
        workerRepository.save(t);
        return "Added sample workers to db";
    }

}