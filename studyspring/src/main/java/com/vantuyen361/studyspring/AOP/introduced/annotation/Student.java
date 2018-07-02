/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.introduced.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author vantuyen
 */
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Student implements Person{
    static int index = 0;
    public int i;
    public Student(){
        name = "tuyen";
        age = 22;
        index +=1;
        i=index;
    }
    @Override
    public String detail() {
        return this.name + String.valueOf(this.age) + "number of object is: " + i; 
    }
    
    @Value("#{'nguyen van tuyen'}")
    public String name;
    
    @Value("#{21}")
    public int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
