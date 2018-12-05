package com.example.eureka.springeurekaclientWorker.domain;

import com.example.eureka.springeurekaclientWorker.domain.Errand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Worker
{
    @Id
    @GeneratedValue(strategy=AUTO)
    private long id;
    private String name;
    private String position;
    private int deskNr;
    private int freedaysLeft;

    @JsonIgnore
    @OneToMany(
            mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Errand> errands = Lists.newArrayList();


    public List<Errand> getErrands() {
        return errands;
    }

    public void setErrands(List<Errand> errands) {
        this.errands = errands;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", deskNr=" + deskNr +
                ", freedaysLeft=" + freedaysLeft +
                ", doneThisMonth=" + errands +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDeskNr() {
        return deskNr;
    }

    public void setDeskNr(int deskNr) {
        this.deskNr = deskNr;
    }

    public int getFreedaysLeft() {
        return freedaysLeft;
    }

    public void setFreedaysLeft(int freedaysLeft) {
        this.freedaysLeft = freedaysLeft;
    }

}