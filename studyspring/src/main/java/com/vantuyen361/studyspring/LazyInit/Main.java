/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.LazyInit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vantuyen
 */
public class Main {
    public static void main(String[] args) {
        //use annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.LazyInit.Container.class);
        System.out.println("initializated factory bean use annotation\n");
        
        //default lazy-intit is false
        Entities entities = (Entities) context.getBean("entities");
        System.out.println("entities" + entities.number + ": " + entities.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("\n\n");
        
        //default @lazy is true
        Entities lazy = (Entities) context.getBean("lazy");
        System.out.println("entities" + lazy.number + ": " + lazy.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("\n\n");
        
        //@lazy is false
        Entities lazyFalse = (Entities) context.getBean("lazyFalse");
        System.out.println("entities" + lazyFalse.number + ": " + lazyFalse.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        
        System.out.print("\n\n\n");
        //use xml
        context = new ClassPathXmlApplicationContext("com/vantuyen361/studyspring/LazyInit/Bean.xml");
        System.out.println("initializated factory bean use xml\n");
        
        //default lazy-intit is false
        entities = (Entities) context.getBean("entities");
        System.out.println("entities" + entities.number + ": " + entities.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("\n\n");
        
        //default lazy-init is false
        lazy = (Entities) context.getBean("lazy");
        System.out.println("entities" + lazy.number + ": " + lazy.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("\n\n");
        
        //@lazy is false
        Entities lazyTrue = (Entities) context.getBean("lazyTrue");
        System.out.println("entities" + lazyTrue.number + ": " + lazyTrue.toString() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
