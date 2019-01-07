/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Bean.Autowired;

/**
 *
 * @author vantuyen361
 */
public class Entities {
    private String name;

    public Entities(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        StringBuffer str;
        str = new StringBuffer("Hello ");
        str.append(name);
        str.append("!");
        return str.toString();
    }
}
