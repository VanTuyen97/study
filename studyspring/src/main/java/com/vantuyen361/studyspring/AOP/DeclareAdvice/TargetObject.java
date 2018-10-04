/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.DeclareAdvice;

import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
public class TargetObject {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void throwException(String message){
        System.out.println("start throw exception");
        throw new NullPointerException("exception");
    }
}
