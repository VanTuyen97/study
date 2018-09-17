/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.helloworldspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tuyen
 */
@RestController
@EnableAutoConfiguration
public class Main {
    @RequestMapping("/")
    String home(){
        return "Hello World";
    }
    
    public static void main(String []args)throws Exception{
        SpringApplication.run(Main.class, args);
    }
}
