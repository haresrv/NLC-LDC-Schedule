package com.example.testsample;


import java.io.Serializable;

public class ProgramSchedule implements Serializable {
    private Integer year;
    private String fileno;      //links to program category
    private Integer prgNo;

    private String program;     //program Title

    private String room;
    private LocalDateTime fromDt;
    private LocalDateTime toDt;
    private Integer participan;      //noOfParticipants
    private String faculty;         //Internal, External or both

    private Employee trgCoord;         //coordinator

    private String parttype;    //
    private String prgType;     //????
    private Integer boys;           //????
    private Integer persons;        //????}

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

    public LocalDateTime getFromDt() {
        return fromDt;
    }

    public void setFromDt(LocalDateTime fromDt) {
        this.fromDt = fromDt;
    }

    public LocalDateTime getToDt() {
        return toDt;
    }

    public void setToDt(LocalDateTime toDt) {
        this.toDt = toDt;
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

    public Employee getTrgCoord() {
        return trgCoord;
    }

    public void setTrgCoord(Employee trgCoord) {
        this.trgCoord = trgCoord;
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
}
