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
    get value from file properties use annotation @Value and @PropertySource
    */
    @Value("${name}")//get value form file properties global.properties
    private String name;
    @Value("${lastName}")//get value form file properties global.properties
    private String lastName;

    @Bean
    public Entities entities2() {
        Entities entities = new Entities();
        entities.setLastName(name);
        entities.setName(lastName);
        return entities;
    }

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

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

}
