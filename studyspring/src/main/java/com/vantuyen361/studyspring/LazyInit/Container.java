/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.LazyInit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author vantuyen
 */
@Configuration
@ComponentScan
public class Container {
    @Lazy
    @Bean
    public Entities lazy(){
        Entities entities = new Entities();
        return entities;
    }
    
    @Lazy(false)
    @Bean
    public Entities lazyFalse(){
        Entities entities = new Entities();
        entities.setFirstName("nam");//after instance bean, firstName is tuyen because object after returned will ioc by @Value
        return entities;
    }
}
