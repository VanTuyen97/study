/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.Springboot.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
@PropertySource("classpath:global.properties")//placeholder file properties
@ConfigurationProperties//bind and validate value file properties to this class
public class Entities {
    private String name;
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
