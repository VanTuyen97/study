/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson.manual;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author TuyenNV22
 */
@Component
public class UserReceive {

    private final String url = "http://localhost:3000/user";

    public List<User> getListUser() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users;

        try {
            users = objectMapper.readValue(new java.net.URL(url), new TypeReference<List<User>>() {
            });
            System.out.println(users.toString());
        } catch (IOException e) {
            users = new ArrayList();
            e.printStackTrace();
        }
        return users;
    }
}
