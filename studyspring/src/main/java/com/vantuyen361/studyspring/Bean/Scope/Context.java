/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Scope of bean
 * @author vantuyen361
 */
@Configuration
public class Context {
    @Bean(name = {"entities1"})
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//default, create only single object instance per Spring context
//    @Scope("singleton") //or
    public Entities entities1(){
        return new Entities();
    }
    
    @Bean(value = {"entities2"})//Intended to be used when no other attributes are needed (priority <<)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)//create new object for each bean
//    @Scope("prototype") //or
    public Entities entities2(){
        return new Entities();
    }
}
