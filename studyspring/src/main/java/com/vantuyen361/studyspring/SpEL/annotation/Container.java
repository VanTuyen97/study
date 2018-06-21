/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.SpEL.annotation;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author vantuyen
 */
@Configuration
@ComponentScan
public class Container {

    /**
     * marthmetic operator
     */
    @Value("#{(2^2)*3/2-1}")
    private double number;
    
    
    /**
     * concatenation string
     */
    @Value("#{'nguyen van ' + 'tuyen'}")
    private String concatString;
    
    
    /**
     * use instanceof operator
     */
    @Value("#{'tuyen' instanceof T(String)}")
    private boolean bool;
    
    
    /**
     * use eq operator
     */
    @Value("#{100 eq 100}")
    private boolean compareEq;
    
    
    /**
     * new operator
     * must specify full package and name class use
     */
    @Value("#{new java.util.Date()}")
    private Date object;
    
    
    //reference to a bean
    /**
     * bean used to referenced
     */
    @Bean
    public String local(){
        return "ha noi";
    }
    /**
     * property reference to local bean
     * can use #{@local} or #{local}
     */
    @Value("#{@local}")
    private String refers;
    
    
    /**
     * use conditional if-then-else
     */
    @Value("#{(3>5)?'true':'false'}")
    private String conditional;
    
    
    /**
     * use Elvis operator
     */
    @Value("#{(6>5)?:'tuyen'}")
    private String elvis;
    
    
    @Value("#{null?.toString()}")
    private String safe;
    
    @Bean
    public Entities entities() {
        Entities entities = new Entities();
        entities.setBool(bool);
        entities.setCompareEq(compareEq);
        entities.setConcatString(concatString);
        entities.setNumber(number);
        entities.setObject(object);
        entities.setRefers(refers);
        entities.setConditional(conditional);
        entities.setElvis(elvis);
        entities.setSafe(safe);
        return entities;
    }
}
