/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.testsample;

import android.os.Build;

import java.io.Serializable;
import java.util.Objects;

public class PipasLocation implements Serializable {
    private PipasUnit pipasUnit = new PipasUnit();
    private PipasScheme pipasScheme = new PipasScheme();
    private PipasDivision pipasDivision = new PipasDivision();

    public PipasUnit getPipasUnit() {
        return pipasUnit;
    }

    public void setPipasUnit(PipasUnit pipasUnit) {
        this.pipasUnit = pipasUnit;
    }

    public PipasScheme getPipasScheme() {
        return pipasScheme;
    }

    public void setPipasScheme(PipasScheme pipasScheme) {
        this.pipasScheme = pipasScheme;
    }

    public PipasDivision getPipasDivision() {
        return pipasDivision;
    }

    public void setPipasDivision(PipasDivision pipasDivision) {
        this.pipasDivision = pipasDivision;
    }

    public PipasLocation() {
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 89 * hash + Objects.hashCode(this.pipasUnit);

        hash = 89 * hash + Objects.hashCode(this.pipasScheme);
        hash = 89 * hash + Objects.hashCode(this.pipasDivision);
        return hash;
    }
    else
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
        final PipasLocation other = (PipasLocation) obj;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.pipasUnit, other.pipasUnit)) {
                return false;
            }

        if (!Objects.equals(this.pipasScheme, other.pipasScheme)) {
            return false;
        }
        if (!Objects.equals(this.pipasDivision, other.pipasDivision)) {
            return false;
        }
        return true;
    }
    return true;}

    @Override
    public String toString() {
        return "PipasLocation{" + "pipasUnit=" + pipasUnit + ", pipasScheme=" + pipasScheme + ", pipasDivision=" + pipasDivision + '}';
    }
    
    
}
