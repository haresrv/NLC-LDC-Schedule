/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.testsample;


import org.joda.time.LocalDateTime;

import java.io.Serializable;

public class ProgramSchedule implements Serializable {
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public Integer getPrgNo() {
        return prgNo;
    }

    public void setPrgNo(Integer prgNo) {
        this.prgNo = prgNo;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDateTime getFromtime() {
        return fromtime;
    }

    public void setFromtime(LocalDateTime fromtime) {
        this.fromtime = fromtime;
    }

    public LocalDateTime getTotime() {
        return totime;
    }

    public void setTotime(LocalDateTime totime) {
        this.totime = totime;
    }

    public Integer getParticipan() {
        return participan;
    }

    public void setParticipan(Integer participan) {
        this.participan = participan;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Employee getCoord() {
        return coord;
    }

    public void setCoord(Employee coord) {
        this.coord = coord;
    }

    public String getParttype() {
        return parttype;
    }

    public void setParttype(String parttype) {
        this.parttype = parttype;
    }

    public String getPrgType() {
        return prgType;
    }

    public void setPrgType(String prgType) {
        this.prgType = prgType;
    }

    public Integer getBoys() {
        return boys;
    }

    public void setBoys(Integer boys) {
        this.boys = boys;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    private Integer year;
    private String fileno;      //links to program category
    private Integer prgNo;

    private String program;     //program Title

    private String room;
    ///private LocalDateTime fdate;
    //private String tdate;
    private LocalDateTime fromtime;
    private LocalDateTime totime;
    private Integer participan;      //noOfParticipants
    private String faculty;         //Internal, External or both


    private Employee coord;         //coordinator

    private String parttype;    //
    private String prgType;     //????
    private Integer boys;           //????
    private Integer persons;        //????
}
