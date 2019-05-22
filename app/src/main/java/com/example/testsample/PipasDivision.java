/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.testsample;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;



public class PipasDivision implements Serializable
{
    public Integer getDivCode() {
        return divCode;
    }

    public void setDivCode(Integer divCode) {
        this.divCode = divCode;
    }

    public String getDivDesc() {
        return divDesc;
    }

    public void setDivDesc(String divDesc) {
        this.divDesc = divDesc;
    }

    public String getDivShortDesc() {
        return divShortDesc;
    }

    public void setDivShortDesc(String divShortDesc) {
        this.divShortDesc = divShortDesc;
    }

    public String getEsttCode() {
        return esttCode;
    }

    public void setEsttCode(String esttCode) {
        this.esttCode = esttCode;
    }

    public Integer getPersUnitCode() {
        return persUnitCode;
    }

    public void setPersUnitCode(Integer persUnitCode) {
        this.persUnitCode = persUnitCode;
    }

    private Integer divCode;
    private String divDesc;
    private String divShortDesc;
    
    private String esttCode;
    private Integer persUnitCode;
    
    public PipasDivision() {
        
    }
    
    public PipasDivision(PipasDivision source) {
        this.divCode = source.divCode;
        this.divDesc = source.divDesc;
        this.divShortDesc = source.divShortDesc;
        
        this.esttCode = source.esttCode;
        this.persUnitCode = source.persUnitCode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 89 * hash + Objects.hashCode(this.divCode);

        hash = 89 * hash + Objects.hashCode(this.divDesc);
        hash = 89 * hash + Objects.hashCode(this.divShortDesc);
        hash = 89 * hash + Objects.hashCode(this.esttCode);
        hash = 89 * hash + Objects.hashCode(this.persUnitCode);
        return hash;
    }
    return -1;}

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
        final PipasDivision other = (PipasDivision) obj;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.divCode, other.divCode)) {
                return false;
            }
        }
        return true;
    }
}
