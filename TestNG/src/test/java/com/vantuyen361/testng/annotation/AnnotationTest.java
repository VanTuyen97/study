/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.annotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vantuyen361.testng.Support;

/**
 *
 * @author TuyenNV22
 */
public class AnnotationTest extends Support {

    public AnnotationTest() {
    }
    
    @BeforeMethod
    public void beforeMethod() {
        log("");
    }

    @AfterMethod
    public void afterMethod() {
        log("");
    }

    @BeforeClass
    public void beforeClass() {
        log("");
    }

    @AfterClass
    public void afterClass() {
        log("");
    }

    @BeforeTest
    public void beforeTest() {
        log("");
    }

    @AfterTest
    public void afterTest() {
        log("");
    }

    @BeforeSuite
    public void beforeSuite() {
        log("");
    }

    @AfterSuite
    public void afterSuite() {
        log("");
    }

    @Test
    public void test1() {
        log("");
    }

    @Test
    public void test2() {
        log("");
    }

    @Test
    public void test3() {
        log("");
    }

}
