/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.exception;

import org.testng.annotations.Test;

import com.vantuyen361.testng.Support;

/**
 *
 * @author TuyenNV22
 */
public class ExceptionTest extends Support {
    
    @Test(expectedExceptions=ArithmeticException.class) //test method must throw arithmetic exception if else test failure
    public void exceptionTest() {
        log("");//print com.vantuyen361.testng.exception.ExceptionTest.exceptionTest(ExceptionTest.java:19): 
        int i = 2/0; //throw a arithemtic exception 
        System.out.println(i);
    }
}
