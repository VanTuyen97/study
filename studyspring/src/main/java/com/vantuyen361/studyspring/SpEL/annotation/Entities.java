/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.SpEL.annotation;

import java.util.Date;


/**
 *
 * @author vantuyen
 */
public class Entities {
    private double number;
    private String concatString;
    private boolean bool;
    private boolean compareEq;
    private Date object;
    private String refers;
    private String conditional;
    private String elvis;
    private String safe;

    public void setNumber(double number) {
        this.number = number;
    }

    public void setConcatString(String concatString) {
        this.concatString = concatString;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public void setCompareEq(boolean compareEq) {
        this.compareEq = compareEq;
    }

    public void setObject(Date object) {
        this.object = object;
    }

    public void setRefers(String refers) {
        this.refers = refers;
    }

    public void setConditional(String conditional) {
        this.conditional = conditional;
    }

    public void setElvis(String elvis) {
        this.elvis = elvis;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }

    public double getNumber() {
        return number;
    }

    public String getConcatString() {
        return concatString;
    }

    public boolean isBool() {
        return bool;
    }

    public boolean isCompareEq() {
        return compareEq;
    }

    public Date getObject() {
        return object;
    }

    public String getRefers() {
        return refers;
    }

    public String getConditional() {
        return conditional;
    }

    public String getElvis() {
        return elvis;
    }

    public String getSafe() {
        return safe;
    }
    
    @Override
    public String toString (){
        return "\nbool: " + String.valueOf(bool)+
               "\ncompareEq: " + String.valueOf(this.compareEq)+
               "\nconcatString: " + this.concatString +
               "\nnumber: " + String.valueOf(this.number) +
               "\nobject: " + object.toString()+
               "\nrefers: " + this.refers +
               "\nconditional: " + conditional +
               "\nelvis: " + elvis +
               "\nsafe: " + safe;
    }
    
}
