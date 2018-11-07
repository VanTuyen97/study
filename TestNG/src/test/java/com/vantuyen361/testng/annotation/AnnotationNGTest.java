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

/**
 *
 * @author TuyenNV22
 */
public class AnnotationNGTest {

    public AnnotationNGTest() {
    }
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("AnnotationNGTest: before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AnnotationNGTest: after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("AnnotationNGTest: before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AnnotationNGTest: after class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("AnnotationNGTest: before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AnnotationNGTest: after test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("AnnotationNGTest: before suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AnnotationNGTest: after suite");
    }

    @Test
    public void test1() {
        System.out.println("AnnotationNGTest: test 1");
    }

    @Test
    public void test2() {
        System.out.println("AnnotationNGTest: test 2");
    }

    @Test
    public void test3() {
        System.out.println("AnnotationNGTest: test 3");
    }

}
