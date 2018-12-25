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
        System.out.println("nguyen van tuyen");
    }
}
