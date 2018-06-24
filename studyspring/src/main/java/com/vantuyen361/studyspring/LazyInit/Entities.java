/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.LazyInit;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
public class Entities {
    @Value("#{'tuyen'}")
    private String firstName;
    @Value("#{'nguyen van'}")
    private String lastName;
    public static int NUMBER = 0;
    public int number = 0;
    
    public Entities(){
        NUMBER += 1; 
        number = NUMBER;
    }
    
    /**
     * method called when bean instanced
     */
    @PostConstruct
    public void init(){
        System.out.println("method initialization for object of class Entities " + NUMBER);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString(){
        return this.lastName + " " + this.firstName;
    }
    
}
