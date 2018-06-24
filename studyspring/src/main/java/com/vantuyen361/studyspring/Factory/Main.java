/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vantuyen
 */
public class Main {
    public static void main(String[] args) {
        //use xml
        ApplicationContext context = new ClassPathXmlApplicationContext("com/vantuyen361/studyspring/Factory/Bean.xml");
        System.out.println("initializated factory bean use xml\n");
        
        Entities entities1 = (Entities) context.getBean("factory");
        System.out.println("\n\nentities" + entities1.number + ": " + entities1.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        
        Entities entities2 = (Entities) context.getBean("factory");
        System.out.println("\n\nentities" + entities2.number + ": " + entities2.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
