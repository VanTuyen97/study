/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.annotation;

import org.testng.annotations.BeforeMethod;
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
