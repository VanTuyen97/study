/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vantuyen361.selenium.loginFacebook;

import com.vantuyen361.selenium.Page;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author TuyenNV22
 */
public class Facebook extends Page{

    public Facebook(long timeoutSeconds) {
        super(timeoutSeconds);
    }
    
    /**
     * login facebook
     */
    public boolean login() throws InterruptedException{
        this.setUrlPage("facebook.url.login");
        this.loadPage();
        //set email text
        this.sendkey(By.xpath("//input[@name='email']"),properties.getProperty("facebook.email"));
        
        //set password text
        this.sendkey(By.xpath("//input[@name='pass']"), properties.getProperty("facebook.password"));
        
        //click button login
        WebElement loginButton = this.findElement(By.xpath("//button[@name='login']"));
        loginButton.submit();
        if(!this.validPage("login"))
            this.log("login success");
        return !this.validPage("login");
    }
    /**
     * create post in facebook
     */
    public void createPost() throws InterruptedException{
        this.sendkey(By.xpath("//textarea[@name='xhpc_message']"), "this text run by selenium framework");
        Thread.sleep(1000);
        this.sendkey(By.xpath("//input[@name='composer_photo[]']"), Page.getFilePath("other/wheelcolors.jpg"));
        this.log("was post image");
        this.click(By.xpath("//button[@data-testid='react-composer-post-button']"));
    }
}
