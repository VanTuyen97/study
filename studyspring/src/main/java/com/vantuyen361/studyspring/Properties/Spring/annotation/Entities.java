/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.Spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
public class Entities {
    @Value("${name}")//get value form file properties global.properties
    private String name;
    @Value("${lastName}")//get value form file properties global.properties
    private String lastName;
    
    @Override
    public String toString(){
        return lastName + name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
