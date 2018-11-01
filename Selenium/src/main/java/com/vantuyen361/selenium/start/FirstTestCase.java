/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.start;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author TuyenNV22
 */
public class FirstTestCase {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", FirstTestCase.getFilePath("chromedriver.exe"));//must put on new WebDriver
        WebDriver driver = new ChromeDriver();// Create a new instance of the Firefox driver

        // Load a new web page in the current browser window
        driver.get("http://www.store.demoqa.com");
        FirstTestCase.webElement(driver);
        //Wait for 5 Sec
        Thread.sleep(5000);

//        driver.findElement(By.xpath("//*[@id=\"menu-item-72\"]/a")).click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");
        System.out.println("Clicking successful");

        // Close the driver
        driver.quit();
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
     * print information of page
     *
     * @param driver
     */
    public static void browserCommand(WebDriver driver) {
        System.out.println("Get Title Command: \t\t" + driver.getTitle());
        System.out.println("Get Current URL Command: \t" + driver.getCurrentUrl());
        System.out.println("Get Page Source Command: \t" + driver.getPageSource().length() + "word");
    }

    /**
     * user navigate web page
     *
     * @param driver
     * @throws InterruptedException
     */
    public static void navigateCommand(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to("http://store.demoqa.com/products-page/product-category/ipads/apple-ipad-2-16gb-wi-fi-9-7in-black/");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().back();
    }

    /**
     * interact with element
     * @param driver
     * @throws InterruptedException 
     */
    public static void webElement(WebDriver driver) throws InterruptedException {
        WebElement e = driver.findElement(By.xpath("//input[@name=\"s\"]"));
        FirstTestCase.browserCommand(driver);
        System.out.println("IsDisplayed Command: \t\t" + e.isDisplayed());
        System.out.println("IsEnabled Command: \t\t" + e.isEnabled());
        System.out.println("IsSelected Command: \t\t" + e.isSelected());
        System.out.println("getTagName Command: \t\t" + e.getTagName());
        System.out.println("getCssValue Command (color): \t\t" + e.getCssValue("color"));
        System.out.println("getAttribute Command (class): \t\t" + e.getAttribute("class"));
        System.out.println("getSize Command: \t\theight-" + e.getSize().height + ", width-" + e.getSize().width);
        System.out.println("getLocation Command: \t\tX cordinate-" + e.getLocation().x + ", Y cordinate-" + e.getLocation().y);
        System.out.println("GetText Command(innerHTML and subelement): \t\t" + driver.findElement(By.xpath("//a[@title=\"My Account\"]")).getText());
        Thread.sleep(1000);
        e.sendKeys("iphone");
        Thread.sleep(1000);
        e.clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"menu-item-72\"]/a")).click();// Alter, use .submit() if the current element is a form
    }

    /**
     * find a or more element in page
     * @param driver
     * @throws InterruptedException 
     */
    public static void findElement(WebDriver driver) throws InterruptedException {
        WebElement e = driver.findElement(By.id("id"));
        e = driver.findElement(By.name("name"));
        e = driver.findElement(By.className("class"));
        e = driver.findElement(By.tagName("tagname"));
        e = driver.findElement(By.partialLinkText("link in tag <a>"));
        e = driver.findElement(By.xpath("use xpath techniques"));
        e = driver.findElement(By.cssSelector("input[value=\"value\"]"));
        
        List<WebElement> list = driver.findElements(By.id("id"));
        list = driver.findElements(By.name("name"));
        list = driver.findElements(By.className("class"));
        list = driver.findElements(By.tagName("tagname"));
        list = driver.findElements(By.partialLinkText("link in tag <a>"));
        list = driver.findElements(By.xpath("use xpath techniques"));
        list = driver.findElements(By.cssSelector("input[value=\"value\"]"));
    }

}
