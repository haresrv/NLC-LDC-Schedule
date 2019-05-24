package com.example.testsample;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.joda.time.LocalDate;

import java.io.Serializable;

public class PersonalInfo implements Serializable {
    private int cpfNo;
    private String empName;


    @JsonDeserialize(using = fetchData.class)
    private LocalDate empDob;
    @JsonDeserialize(using = fetchData.class)
    private LocalDate dojNLC;
    @JsonDeserialize(using = fetchData.class)
    private LocalDate empDor;

    private String empSex;
    private String resvnClassCode;
    private String eduQualification;

    public int getCpfNo() {
        return cpfNo;
    }

    public void setCpfNo(int cpfNo) {
        this.cpfNo = cpfNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public LocalDate getEmpDob() {
                return empDob;
    }

    public void setEmpDob(LocalDate dojNLC) {
        this.empDob=dojNLC;
    }

    public LocalDate getDojNLC() {
        return dojNLC;
    }

    public void setDojNLC(LocalDate dojNLC) {
        this.dojNLC=dojNLC;
    }

    public LocalDate getEmpDor() {
        return empDor;
    }

    public void setEmpDor(LocalDate empDor) {
        this.empDor = empDor;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getResvnClassCode() {
        return resvnClassCode;
    }

    public void setResvnClassCode(String resvnClassCode) {
        this.resvnClassCode = resvnClassCode;
    }

    public String getEduQualification() {
        return eduQualification;
    }

    public void setEduQualification(String eduQualification) {
        this.eduQualification = eduQualification;
    }

}
