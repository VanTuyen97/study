/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author vantuyen361
 */

@Configuration
@ComponentScan
public class Context {
    
    @Bean
    public Integer age(){
        return 22;
    }
    
    @Bean
    public String name(){
        return "Tuyen";
    }
}
