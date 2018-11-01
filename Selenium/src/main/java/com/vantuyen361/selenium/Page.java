/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium;

import com.vantuyen361.selenium.loginFacebook.Facebook;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * this class support to interact with browser
 * @author TuyenNV22
 */
public class Page {
    public static String globalPath = "/global.properties";
    protected WebDriver driver;
    protected Properties properties;
    protected String urlPage;
    
    
    public Page () throws IOException {
        this.init();
    }
    
    protected void init() throws IOException{
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        this.properties = Page.loadProperties(Page.globalPath);
        System.setProperty("webdriver.chrome.driver", Page.getFilePath(this.properties.getProperty("webdriver.chrome.driver")));
        this.driver = new ChromeDriver(ops);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//timeout
    }
    
    
    public void loadPage(){
        driver.get(this.urlPage);
        System.out.println("go to Url successfully");
    }
    
    public void quit(){
        this.driver.quit();
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
    
    protected void log(String label, String content){
        System.out.println(label + ":\t\t" + content);
    }
    
    protected void log(String content){
        System.out.println(content);
    }
}
