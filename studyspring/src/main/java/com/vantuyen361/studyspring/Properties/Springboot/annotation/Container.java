/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.Springboot.annotation;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author vantuyen
 */
@Configuration
@ComponentScan
@EnableConfigurationProperties//enable support @ConfigurationProperties
public class Container {

}
