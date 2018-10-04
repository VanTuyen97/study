/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.DeclareAdvice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author vantuyen
 */
@Component
@Aspect
public class AOP {
    //Alternative, execution(public String com.vantuyen361.studyspring.AOP.DeclareAdvice.TargetObject.getName())
    @Pointcut("execution(* com.vantuyen361.studyspring.AOP.DeclareAdvice.TargetObject.getName())")
    public void getName(){}
    
    @Before(value="getName()")
    public void before(){
        System.out.println("before");
    }
    
    @After(value="getName()")
    public void advice(){
        System.out.println("after");
    }
    
    @AfterReturning(value="getName()",
            returning="name")
    public void afterReturn(String name){
        System.out.println("result is: " + name);
    }
    
    @AfterThrowing(value="execution(* com.vantuyen361.studyspring.AOP.DeclareAdvice.TargetObject.throwException(String)) and args(message)")
    public void afterThrow(String message){
         System.out.println("message: " + message);
    }
}
