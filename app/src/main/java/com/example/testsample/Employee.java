/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.testsample;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Employee implements Serializable{


    public PersonalInfo getPersInfo() {
        return persInfo;
    }

    public void setPersInfo(PersonalInfo persInfo) {
        this.persInfo = persInfo;
    }

    public PipasLocation getPipasLocation() {
        return pipasLocation;
    }

    public void setPipasLocation(PipasLocation pipasLocation) {
        this.pipasLocation = pipasLocation;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    private PersonalInfo persInfo = new PersonalInfo();
    private PipasLocation pipasLocation = new PipasLocation();
    private Designation designation = new Designation();
   // private AMSDept amsDept;
   // private Discipline discipline;
    
    public Employee() {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 41 * hash + Objects.hashCode(this.persInfo);

        hash = 41 * hash + Objects.hashCode(this.pipasLocation);
        hash = 41 * hash + Objects.hashCode(this.designation);

        return hash;
    }
    else
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.persInfo, other.persInfo)) {
                return false;
            }

        if (!Objects.equals(this.pipasLocation, other.pipasLocation)) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }}
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + " persInfo=" + persInfo + ", pipasDivision=" + pipasLocation + ", designation=" + designation + '}';
    }

}
