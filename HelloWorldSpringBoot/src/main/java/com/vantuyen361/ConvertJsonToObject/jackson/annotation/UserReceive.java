/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author TuyenNV22
 */
@Component
public class UserReceive {

    private final String urlUser = "http://localhost:3000/user";

    public List<User> getListUser() {

        RestTemplate restTemplate = new RestTemplate();
        try {
            User[] users  = restTemplate.getForObject(this.urlUser, User[].class);
            ObjectMapper objectMapper = new ObjectMapper();
            return Arrays.asList(users);
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }
    
    public User getUser(Integer id){
        String url = this.urlUser + "/{id}";//{param} is syntax to insert param for request
        Map<String, String> param = new HashMap();
        param.put("id", id.toString());//param request
        
        RestTemplate restTemplate = new RestTemplate();
        try {
            User user  = restTemplate.getForObject(url, User.class, param);
            ObjectMapper objectMapper = new ObjectMapper();
            return user;
        } catch (RestClientException e) {
            return null;
        }
    }
}
