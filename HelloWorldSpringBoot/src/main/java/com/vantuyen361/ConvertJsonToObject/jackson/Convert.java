/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 * get json from address web and convert from object using ObjectMapper.
 * @author TuyenNV22
 */
public class Convert {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Device> device = objectMapper.readValue(new java.net.URL("http://171.244.43.172:8083/price"), new TypeReference<List<Device>>(){});
            System.out.println(device.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
