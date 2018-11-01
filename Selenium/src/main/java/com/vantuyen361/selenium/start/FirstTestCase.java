/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.start;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author TuyenNV22
 */
public class FirstTestCase {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", FirstTestCase.getFilePath("chromedriver.exe"));//must put on new WebDriver
        WebDriver driver = new ChromeDriver();// Create a new instance of the Firefox driver

        FirstTestCase.wait(driver);
        // Load a new web page in the current browser window
        driver.get("http://www.store.demoqa.com");
        System.out.println(driver.findElement(By.xpath("//nav[@id='footer']")).getAttribute("class"));
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
     *
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
     *
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

    public static void wait(WebDriver driver) {
        //1. wait for a certain amount of time before (from load page success) throwing an exception that it cannot find the element on the page
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2. amount of time to wait for a page load to complete before throwing an error
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

        //3. amount of time to wait for an asynchronous script to finish execution before throwing an error
        driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);

        //3. 
        FluentWait fluentWait = new FluentWait(driver);
        //Specify the timout of the wait
        fluentWait.withTimeout(5000, TimeUnit.MILLISECONDS);
        //Sepcify polling time
        fluentWait.pollingEvery(250, TimeUnit.MILLISECONDS);// the loop is execute: thread will sleeping 250ms, after each check condition (in until() method). 
        //Specify what exceptions to ignore
        fluentWait.ignoring(NoSuchElementException.class); //This is how we specify the condition to wait on.
        //This is what we will explore more in this chapter
        fluentWait.until(ExpectedConditions.alertIsPresent());
        //can use Predicate to alter (allway return boolean)
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the element!!");
                WebElement element = arg0.findElement(By.id("target"));
                if (element != null) {
                    System.out.println("Target element found");
                }
                return element;
            }
        };
        fluentWait.until(function);
        

        //4. condition wait
        WebDriverWait wait = new WebDriverWait(driver, 10);//param is WebDriver and timeout
        driver.get("http://www.store.demoqa.com");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
    }

    /**
     * execute javascript command console
     *
     * @param driver
     */
    public static void javascriptExecutor(WebDriver driver) {
        Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
    }
}
