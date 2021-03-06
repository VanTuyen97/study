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
public class Main{    
    @Autowired
    public Tuyen tuyen;
    /**
     * override Context contains this bean
     */
    @Autowired
    public ApplicationContext context;
    
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.Bean.Autowired.Context.class);
        Main m = (Main)context.getBean(Main.class);
    }
}
