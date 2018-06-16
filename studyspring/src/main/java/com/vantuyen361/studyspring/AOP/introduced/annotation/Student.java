/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.AOP.introduced.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen
 */

@Component
public class Student implements Person{
    public Student(){
        name = "tuyen";
        age = 22;
    }
    @Override
    public String detail() {
        return this.name + String.valueOf(this.age) + "toi la nguyen van tuyen"; 
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
