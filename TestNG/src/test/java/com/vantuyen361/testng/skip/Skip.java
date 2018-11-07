/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.skip;

import com.vantuyen361.testng.Support;
import org.testng.annotations.Test;

/**
 *
 * @author TuyenNV22
 */
public class Skip extends Support{
    @Test(priority = 1)
    public void test1() {
        log("test1");
    }
    
    @Test(priority = 2)
    public void test2() {
        log("test2");
    }
    
    @Test(priority = 3, enabled = false)// this method will not run
    public void test3() {
        log("test3");
    }
    
    @Test(priority = 4)
    public void test4() {
        log("test4");
    }
    
}
