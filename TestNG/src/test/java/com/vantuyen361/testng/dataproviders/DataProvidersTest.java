/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.dataproviders;

import com.vantuyen361.testng.Support;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Tuyên
 */
public class DataProvidersTest extends Support{

    @DataProvider(name = "Auth")
    public String[][] dataProvider() {
        return new String[][]{{"tuyen", "tuyen123"}, {"nam", "nam123"}};
    }

    @Test(dataProvider = "Auth")
    public void test (String name, String password) {
        log("name-" + name + ", password-" + password);
    }
}
