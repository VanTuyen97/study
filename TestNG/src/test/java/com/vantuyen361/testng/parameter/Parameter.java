/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.parameter;

import com.vantuyen361.testng.Support;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author TuyenNV22
 */
public class Parameter extends Support {

    /**
     * get parameter from inner test tag
     *
     * @param name
     * @param age
     */
    @Test
    @Parameters({"name", "age"})
    public void test1(String name, int age) {
        log("test1 >>>> name-" + name + ", age-" + age);
    }
}
