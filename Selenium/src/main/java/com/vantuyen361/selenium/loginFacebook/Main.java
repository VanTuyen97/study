/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.loginFacebook;

import java.io.IOException;

/**
 *
 * @author TuyenNV22
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        Facebook facebook = new Facebook();

        Thread.sleep(1000);
        facebook.login();

//        Thread.sleep(1000);
//        facebook.createPost();

        Thread.sleep(5000);
        facebook.quit();
    }
}
