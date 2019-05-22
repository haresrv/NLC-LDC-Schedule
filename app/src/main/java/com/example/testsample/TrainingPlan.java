/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.testsample;

import java.io.Serializable;

/** @author Admin */
public class TrainingPlan implements Serializable {
    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getPrgName() {
        return prgName;
    }

    public void setPrgName(String prgName) {
        this.prgName = prgName;
    }

    public Employee getProgCoord() {
        return progCoord;
    }

    public void setProgCoord(Employee progCoord) {
        this.progCoord = progCoord;
    }

    public ProgramCategory getProgCategory() {
        return progCategory;
    }

    public void setProgCategory(ProgramCategory progCategory) {
        this.progCategory = progCategory;
    }

    public ParticipantCategory getParticipant() {
        return participant;
    }

    public void setParticipant(ParticipantCategory participant) {
        this.participant = participant;
    }

    public Integer getNoOfPrgs() {
        return noOfPrgs;
    }

    public void setNoOfPrgs(Integer noOfPrgs) {
        this.noOfPrgs = noOfPrgs;
    }

    public Float getPrgDays() {
        return prgDays;
    }

    public void setPrgDays(Float prgDays) {
        this.prgDays = prgDays;
    }

    private String fileno;
    private String prgName;
    
    private Employee progCoord = new Employee();
    private ProgramCategory progCategory = new ProgramCategory();
    private ParticipantCategory participant = new ParticipantCategory();
    
    private Integer noOfPrgs = new Integer(0);
    private Float prgDays = new Float(0);


}

