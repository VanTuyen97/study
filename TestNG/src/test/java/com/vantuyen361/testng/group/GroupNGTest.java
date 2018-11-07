/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.group;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author TuyenNV22
 */
public class GroupNGTest {

    @Test(groups = {"group1"})
    public void test1() {
        System.out.println("GroupNGTest: test1 method");
    }

    @Test(groups = {"group1"})
    public void test2() {
        System.out.println("GroupNGTest: test2 method");
    }

    @Test(groups = {"group1"})
    public void test3() {
        System.out.println("GroupNGTest: test3 method");
    }

    @Test(groups = {"group2"})
    public void test4() {
        System.out.println("GroupNGTest: test4 method");
    }

    @Test(groups = {"group2"})
    public void test5() {
        System.out.println("GroupNGTest: test5 method");
    }
}
