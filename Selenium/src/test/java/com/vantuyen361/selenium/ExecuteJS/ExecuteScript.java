/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.ExecuteJS;

import com.vantuyen361.selenium.Page;
import com.vantuyen361.selenium.wait.Wait;
import static java.lang.System.out;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author TuyenNV22
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class ExecuteScript {
    private WebDriver driver;
    private Wait wait;
    
    @BeforeAll
    public void beforeAll(){
        Page page = new Page(1);
        driver = page.driver;
        wait = new Wait(driver, 60);
        driver.get("https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html");
        wait.untilPageLoadComplete(90l);
    }
    
    /**
     * scroll to element
     */
    @Test
    public void scroll() {
        System.out.println("=====Scroll to element=====");
        By by = By.cssSelector("a[name='executeAsyncScript-java.lang.String-java.lang.Object...-']");
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement e = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("onscroll = true; arguments[0].scrollIntoView(true);", e);
        System.out.println("\n\n");
    }
    
    /**
     * Get child of element by xpath
     */
    @Test
    public void getElement() {
        System.out.println("=====Get Element=====");
        String expect = "executeScript";
        By by = By.cssSelector("h4");
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement e = (WebElement) ((JavascriptExecutor)driver).executeScript("return document.getElementsByTagName(\"h4\")[0];");
        String text = e.getText();
        assertTrue(String.format("actual is %s, expect is %s.", text, expect), text.equals(expect));
        System.out.println("\n\n");
    }
    
    @AfterAll
    public void afterAll(){
        driver.quit();
    }
}
