/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.factory;

import org.testng.annotations.Factory;


/**
 *
 * @author vantuyen361
 */
public class Factories {
    @Factory
    public Object[] createInstance(){
        UnitTest[] tests = new UnitTest[10];
        for(int index = 0; index<10; index++){
            tests[index] = new UnitTest();
        }
        return tests;
    }
}
