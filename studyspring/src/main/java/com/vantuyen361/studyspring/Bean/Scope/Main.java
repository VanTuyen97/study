/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.Assert;

/**
 *
 * @author vantuyen361
 */
public class Main {  
    public static void main(String[] args) {
        Main.setScopeOfBean();
    }
    
    /**
     * use scope of bean
     */
    public static void setScopeOfBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(com.vantuyen361.studyspring.Bean.Scope.Context.class);
        
        Entities e1 = (Entities)context.getBean("entities1");
        Entities e2 = (Entities)context.getBean("entities1");
        Assert.isTrue(e1 == e2, "scope singleton don't act");
        
        Entities e3 = (Entities)context.getBean("entities2");
        Entities e4 = (Entities)context.getBean("entities2");
        Assert.isTrue(e3 != e4, "scope prototype don't act"); // use assert of spring
        
        ((AbstractApplicationContext) context).close();
    }
}
