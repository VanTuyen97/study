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
@Test(groups= {"Partial groups"})
public class GroupTest extends Support {

    @Test(groups = {"group1"})
    public void test1() {
        log("group1");
    }

    @Test(groups = {"group2"})
    public void test2() {
        log("group2");
    }

    @Test(groups = {"group3"})
    public void test3() {
        log("group3");
    }

    @Test(groups = {"group4"})
    public void test4() {
        log("group4");
    }

    @Test(groups = {"group5"})
    public void test5() {
        log("test5 method");
    }
}
