/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.testsample;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;
public class PipasUnit  implements Serializable
{
    public Integer getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Integer unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitShortDesc() {
        return unitShortDesc;
    }

    public void setUnitShortDesc(String unitShortDesc) {
        this.unitShortDesc = unitShortDesc;
    }

    private Integer unitCode;
    private String unitName;
    private String unitShortDesc;
    public PipasUnit()
    {

    }
    
    public PipasUnit(PipasUnit source) {
        this.unitCode = source.unitCode;
        this.unitName = source.getUnitName();
        this.unitShortDesc = source.getUnitShortDesc();
    }    

    public PipasUnit(Integer unitCode, String unitName)
    {
        this.unitCode = unitCode;
        this.unitName = unitName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 97 * hash + Objects.hashCode(this.unitCode);

        hash = 97 * hash + Objects.hashCode(this.unitName);
        hash = 97 * hash + Objects.hashCode(this.unitShortDesc);
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
        final PipasUnit other = (PipasUnit) obj;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.unitCode, other.getUnitCode())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "TcoUnit{" + "unitCode=" + unitCode + ", unitName=" + unitName + ", unitShortDesc=" + unitShortDesc + '}';
    }


}

