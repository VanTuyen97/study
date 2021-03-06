/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.Spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author vantuyen
 */
@Configuration
@ComponentScan
@PropertySource("classpath:global.properties")//placeholder file properties
public class Container {

    /*
    get value from file properties use annotation @PropertySource and use env is properties placeholder to get value
    */
    @Autowired
    private Environment env;//

    @Bean
    public Entities entities1() {
        Entities entities = new Entities();
        entities.setLastName(env.getProperty("name"));
        entities.setName(env.getProperty("lastName"));
        return entities;
    }


    public void setEnv(Environment env) {
        this.env = env;
    }

}
