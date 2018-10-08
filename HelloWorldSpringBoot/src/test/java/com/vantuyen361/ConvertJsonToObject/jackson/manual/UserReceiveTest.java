/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson.manual;

import java.util.List;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author TuyenNV22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserReceiveTest {
    @Autowired
    private UserReceive receive;
    
    @Test
    public void getListUserTest(){
        List<User> users = receive.getListUser();
        assertFalse("getListUser(): didn't get users", users.isEmpty());
    }
}
