package com.vantuyen361.testng.start;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TuyenNV22
 */
public class Message {

    private String message;

    public Message() {
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    public String printMessage() {
        System.out.println(message);
        return message;
    }

    /**
     * add "Hi!" to the message
     */
    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}
