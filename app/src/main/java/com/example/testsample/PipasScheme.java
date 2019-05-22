/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.testsample;


import android.os.Build;

import java.io.Serializable;
import java.util.Objects;


public class PipasScheme  implements Serializable
{
    public Integer getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(Integer schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(String schemeType) {
        this.schemeType = schemeType;
    }

    public String getSchemeDesc() {
        return schemeDesc;
    }

    public void setSchemeDesc(String schemeDesc) {
        this.schemeDesc = schemeDesc;
    }

    public String getSchemeShortDesc() {
        return schemeShortDesc;
    }

    public void setSchemeShortDesc(String schemeShortDesc) {
        this.schemeShortDesc = schemeShortDesc;
    }

    private Integer schemeCode;
    private String schemeType;
    private String schemeDesc;
    private String schemeShortDesc;
    
     public PipasScheme() {
         
     }

    public PipasScheme(PipasScheme source) {
        this.schemeCode = source.schemeCode;
        this.schemeDesc = source.schemeShortDesc;
        this.schemeShortDesc = source.schemeShortDesc;
        this.schemeType = source.schemeType;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hash = 17 * hash + Objects.hashCode(this.schemeCode);

        hash = 17 * hash + Objects.hashCode(this.schemeType);
        hash = 17 * hash + Objects.hashCode(this.schemeDesc);
        hash = 17 * hash + Objects.hashCode(this.schemeShortDesc);
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
        final PipasScheme other = (PipasScheme) obj;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (!Objects.equals(this.schemeCode, other.schemeCode)) {
                return false;
            }
        }
        return true;
    }
}
