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
        log("before method");
    }

    @AfterMethod
    public void afterMethod() {
        log("after method");
    }

    @BeforeClass
    public void beforeClass() {
        log("before class");
    }

    @AfterClass
    public void afterClass() {
        log("after class");
    }

    @BeforeTest
    public void beforeTest() {
        log("before test");
    }

    @AfterTest
    public void afterTest() {
        log("after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        log("before suite");
    }

    @AfterSuite
    public void afterSuite() {
        log("after suite");
    }

    @Test
    public void test1() {
        log("test 1");
    }

    @Test
    public void test2() {
        log("test 2");
    }

    @Test
    public void test3() {
        log("test 3");
    }

}
