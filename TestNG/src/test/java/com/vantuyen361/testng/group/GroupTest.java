/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.group;

import org.testng.annotations.Test;

import com.vantuyen361.testng.Support;

/**
 *
 * @author TuyenNV22
 */
public class GroupTest extends Support {

    @Test(groups = {"group1"})
    public void test1() {
        log("test1 method");
    }

    @Test(groups = {"group1"})
    public void test2() {
        log("test2 method");
    }

    @Test(groups = {"group1"})
    public void test3() {
        log("test3 method");
    }

    @Test(groups = {"group2"})
    public void test4() {
        log("test4 method");
    }

    @Test(groups = {"group2"})
    public void test5() {
        log("test5 method");
    }
}
