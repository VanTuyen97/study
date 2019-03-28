/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author vantuyen361
 */
@Component
public class Tuyen extends Person{
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private String name;

    public Tuyen() {
    }
    
    @Override
    public String toString(){
        StringBuffer str;
        str = new StringBuffer("Hello ");
        str.append(name);
        str.append("!");
        return str.toString();
    }
}
