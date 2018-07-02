/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.argAdvice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */
@Component
@Aspect
public class AOP {
    @Before(value="execution(* com.vantuyen361.studyspring.AOP.argAdvice.TargetObject.setName(String)) and args(name)")
    public void advice(String name){
        System.out.println(name);
    }
}
