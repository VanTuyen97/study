/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Autowired;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @author vantuyen361
 */
@Component
public class Main {
    /**
     * field will set value when object created (accept privated field)
     */
    @Autowired
    @Qualifier(value = "Person")
    private Entities person;
    
    private Entities student;

    /**
     * this method will to be call when bean of Main class created
     * @param student bean by "Student" name
     */
    @Autowired 
    public void setStudent(@Qualifier(value = "Student") Entities student) {
        this.student = student;
    }
    
    public void assertObject(){
        Assert.isTrue(person != null, "field was not autowire!");
        Assert.isTrue(student != null, "getter method was not call!");
    }
    
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.Bean.Autowired.Context.class);
        Main m = (Main)context.getBean(Main.class);
        m.assertObject();
    }
}
