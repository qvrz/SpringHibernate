package com.example.eureka.springeurekaclientWorker.domain;

import rx.BackpressureOverflow;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Errand
{
    @Id
    @GeneratedValue(strategy=AUTO)
    private long id;
    private int taskNr;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTaskNr() {
        return taskNr;
    }

    public void setTaskNr(int taskNr) {
        this.taskNr = taskNr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
