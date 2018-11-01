/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vantuyen361.selenium.loginFacebook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author TuyenNV22
 */
public class Facebook {
    private WebDriver driver;
    private Properties properties;
    public String urlPage;
    public static String globalPath = "/global.properties";
    
    public Facebook () throws IOException {
        this.init();
    }
    
    private void init() throws IOException{
        this.properties = Facebook.loadProperties(Facebook.globalPath);
        System.setProperty("webdriver.chrome.driver", Facebook.getFilePath(this.properties.getProperty("webdriver.chrome.driver")));
        this.driver = new ChromeDriver();
        this.urlPage = this.properties.getProperty("facebook.url");
    }
    
    public void quit(){
        this.driver.quit();
    }
    
    public void loadPage(){
        driver.get(this.urlPage);
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
    
    /**
     * get absolute path to driver on classpath
     *
     * @param relativeFilePath
     * @return
     */
    public static String getFilePath(String relativeFilePath) {
        String curDir = System.getProperty("user.dir");
        String filePath = curDir + "/src/main/resources/Driver/" + relativeFilePath;
        return filePath;
    }
    
    /**
     * get properties file
     * @param fileClasspath
     * @return
     * @throws IOException 
     */
    private static Properties loadProperties(String fileClasspath) throws IOException {
        Properties properties = new Properties();
        InputStream stream = Facebook.class.getClass().getResourceAsStream(fileClasspath);
        properties.load(stream);
        return properties;
    }
}
