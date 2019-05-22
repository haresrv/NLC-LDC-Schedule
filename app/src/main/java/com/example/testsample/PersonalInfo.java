/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.testsample;

import java.io.Serializable;
import java.time.LocalDate;

public class PersonalInfo implements Serializable {
    private int cpfNo;
    private String empName;
    
    private LocalDate empDob;
    private LocalDate dojNLC;
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

    public void setEmpDob(LocalDate empDob) {
        this.empDob = empDob;
    }

    public LocalDate getDojNLC() {
        return dojNLC;
    }

    public void setDojNLC(LocalDate dojNLC) {
        this.dojNLC = dojNLC;
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
/*
    public Integer getAge() {
        return java.time.Period.between(this.empDob, LocalDate.now()).getYears();
    } 
    */
}
