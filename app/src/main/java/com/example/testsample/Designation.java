/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.testsample;

import android.os.Build;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Designation implements Serializable {
    public String getRevGradeCode() {
        return revGradeCode;
    }

    public void setRevGradeCode(String revGradeCode) {
        this.revGradeCode = revGradeCode;
    }

    public String getEmpCurrGradeCode() {
        return empCurrGradeCode;
    }

    public void setEmpCurrGradeCode(String empCurrGradeCode) {
        this.empCurrGradeCode = empCurrGradeCode;
    }

    public LocalDate getEmpCurrGradeDate() {
        return empCurrGradeDate;
    }

    public void setEmpCurrGradeDate(LocalDate empCurrGradeDate) {
        this.empCurrGradeDate = empCurrGradeDate;
    }

    public Integer getEmpCurrDesgCode() {
        return empCurrDesgCode;
    }

    public void setEmpCurrDesgCode(Integer empCurrDesgCode) {
        this.empCurrDesgCode = empCurrDesgCode;
    }

    public String getDesgDesc() {
        return desgDesc;
    }

    public void setDesgDesc(String desgDesc) {
        this.desgDesc = desgDesc;
    }

    public String getDesgShortDesc() {
        return desgShortDesc;
    }

    public void setDesgShortDesc(String desgShortDesc) {
        this.desgShortDesc = desgShortDesc;
    }

    public String getDesgType() {
        return desgType;
    }

    public void setDesgType(String desgType) {
        this.desgType = desgType;
    }

    public LocalDate getEmpCurrDesgDate() {
        return empCurrDesgDate;
    }

    public void setEmpCurrDesgDate(LocalDate empCurrDesgDate) {
        this.empCurrDesgDate = empCurrDesgDate;
    }

    private String revGradeCode;
    private String empCurrGradeCode;
    private LocalDate empCurrGradeDate;
    
    private Integer empCurrDesgCode;
    private String desgDesc;
    private String desgShortDesc;
    private String desgType;
    
    private LocalDate empCurrDesgDate;

    @Override
    public int hashCode() {
        int hash = 7;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 59 * hash + Objects.hashCode(this.revGradeCode);

        hash = 59 * hash + Objects.hashCode(this.empCurrGradeCode);
        hash = 59 * hash + Objects.hashCode(this.empCurrGradeDate);
        hash = 59 * hash + Objects.hashCode(this.empCurrDesgCode);
        hash = 59 * hash + Objects.hashCode(this.desgDesc);
        hash = 59 * hash + Objects.hashCode(this.desgShortDesc);
        hash = 59 * hash + Objects.hashCode(this.desgType);
        hash = 59 * hash + Objects.hashCode(this.empCurrDesgDate);
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
        final Designation other = (Designation) obj;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.revGradeCode, other.revGradeCode)) {
                return false;
            }

        if (!Objects.equals(this.empCurrGradeCode, other.empCurrGradeCode)) {
            return false;
        }
        if (!Objects.equals(this.desgDesc, other.desgDesc)) {
            return false;
        }
        if (!Objects.equals(this.desgShortDesc, other.desgShortDesc)) {
            return false;
        }
        if (!Objects.equals(this.desgType, other.desgType)) {
            return false;
        }
        if (!Objects.equals(this.empCurrGradeDate, other.empCurrGradeDate)) {
            return false;
        }
        if (!Objects.equals(this.empCurrDesgCode, other.empCurrDesgCode)) {
            return false;
        }
        if (!Objects.equals(this.empCurrDesgDate, other.empCurrDesgDate)) {
            return false;
        }
        return true;
    }
    else
        return true;
    }

}
