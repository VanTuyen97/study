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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class support to interact with browser. default instance will load
 * facebook page
 *
 * @author TuyenNV22
 */
public class Page {

    public static String globalPath = "/global.properties";
    protected WebDriver driver;
    protected Properties properties;
    protected String urlPage;
    protected WebDriverWait wait;

    public Page() {
        try {
            this.init();
        } catch (IOException ex) {
            this.log(ex.toString());
            System.exit(0);
        }
    }

    protected void init() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");//disable notification for chrome 
        ops.addArguments("disable-infobars");//don't allow display string "chrome is being controlled by automated test software" when chrome run
        this.properties = Page.loadProperties(Page.globalPath);
        this.urlPage = this.properties.getProperty("facebook.url");//default
        System.setProperty("webdriver.chrome.driver", Page.getFilePath(this.properties.getProperty("webdriver.chrome.driver")));
        this.driver = new ChromeDriver(ops);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//timeout
        this.wait = new WebDriverWait(this.driver, 30);
    }

    public void loadPage() {
        driver.get(this.urlPage);
        System.out.println("go to Url successfully");
    }

    public void quit() {
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
        String filePath = curDir + "/src/main/resources/" + relativeFilePath;
        return filePath;
    }

    /**
     * get properties file
     *
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

    protected void log(String label, String content) {
        System.out.println(label + ":\t\t" + content);
    }

    protected void log(String content) {
        System.out.println(content);
    }

    protected void click(By element) {
        try {
            this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException ex) {
            this.log(ex.getMessage());
        }
    }

    protected WebElement findElement(By element) {
        WebElement e = this.driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        return e;
    }

    protected void sendkey(By element, String str) {
        WebElement e = this.findElement(element);
        e.sendKeys(str);
    }

    protected boolean setUrlPage(String property) {
        this.urlPage = this.properties.getProperty(property);
        if (this.urlPage == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Exactly current url contain a substring
     * @param url substring of url
     * @return 
     */
    protected boolean validPage(String url) {
        return this.driver.getCurrentUrl().contains(url);
    }
}
