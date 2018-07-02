/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.introduced.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author vantuyen
 */
public class Main {
    public static void main(String[]args){
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.AOP.introduced.annotation.Config.class);
        Object location =  context.getBean("location");
        System.out.println(((Person)location).detail() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(((Person)location).detail() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(((Person)location).detail() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
