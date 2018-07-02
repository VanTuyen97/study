/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.argAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author vantuyen
 */
@EnableAspectJAutoProxy
@ComponentScan
@Configuration
public class Main {
    public static void main(String []args){
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.AOP.argAdvice.Main.class);
        TargetObject object = (TargetObject)context.getBean("targetObject");
        System.out.println("the target object is created>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        object.setName("tuyen");
    }
}
