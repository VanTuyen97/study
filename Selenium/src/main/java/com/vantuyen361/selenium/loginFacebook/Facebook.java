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
    public Facebook() throws IOException{
        super();
        this.urlPage = this.properties.getProperty("facebook.url");
    }
    
    /**
     * login facebook
     */
    public void login(){
        //set email text
        WebElement email = this.driver.findElement(By.xpath("//input[@data-testid='royal_email']"));
        email.sendKeys(properties.getProperty("facebook.email"));
        
        //set password text
        WebElement password = this.driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        password.sendKeys(properties.getProperty("facebook.password"));
        
        //click button login
        WebElement loginButton = this.driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
        loginButton.submit();
    }
}
