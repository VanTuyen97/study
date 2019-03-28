/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tuyên
 */
public abstract class Person {
    /**
     * all subclass extends this class would inject age property
     */
   @Autowired
   protected Integer age;
}
