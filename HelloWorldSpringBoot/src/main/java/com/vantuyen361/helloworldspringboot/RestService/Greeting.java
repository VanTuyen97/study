/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.helloworldspringboot.RestService;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TuyenNV22
 */
public class Greeting {
    private final long id;
    private final Map<String, String> content = new HashMap();

    public Greeting(long id, String name, String age) {
        this.id = id;
        this.content.put("name", name);
        this.content.put("age", age);
    }

    public long getId() {
        return id;
    }

    public Map<String, String> getContent() {
        return content;
    }
}
