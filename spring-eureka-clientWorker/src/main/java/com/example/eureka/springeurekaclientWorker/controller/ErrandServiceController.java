package com.example.eureka.springeurekaclientWorker.controller;

import com.example.eureka.springeurekaclientWorker.domain.Errand;
import com.example.eureka.springeurekaclientWorker.domain.ErrandRepository;
import com.example.eureka.springeurekaclientWorker.domain.Worker;
import com.example.eureka.springeurekaclientWorker.domain.WorkerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ErrandServiceController {
    private final ErrandRepository errandRepository;
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    public ErrandServiceController(ErrandRepository errandRepository) {

        this.errandRepository = errandRepository;
    }
    @GetMapping("/getListOfErrands")
    public List<Errand> listErrands() {
        return Lists.newArrayList(errandRepository.findAll());
    }
    @GetMapping("/addErrands")
    public String addSampleErrands()
    {
        Errand e=new Errand();
        e.setId(1);
        e.setDescription("Posprzątanie biurka");
        e.setTaskNr(1);
        errandRepository.save(e);
        return "Added sample errand";
    }
}
