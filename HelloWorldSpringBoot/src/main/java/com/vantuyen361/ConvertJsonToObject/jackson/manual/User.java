/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.ConvertJsonToObject.jackson.manual;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author TuyenNV22
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
