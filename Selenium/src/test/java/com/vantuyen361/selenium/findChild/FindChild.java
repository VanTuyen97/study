/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.findChild;

import com.vantuyen361.selenium.Page;
import com.vantuyen361.selenium.wait.Wait;
import java.util.List;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
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
@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindChild {
    private WebDriver driver;
    private Wait wait;
    
    @BeforeAll
    public void beforeAll(){
        Page page = new Page(1);
        driver = page.driver;
        wait = new Wait(driver, 60);
        driver.get("https://w3c.github.io/webdriver/");
        wait.untilPageLoadComplete(90l);
    }
    
    /**
     * Get child of element by xpath
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findChildByXpath() {
        System.out.println("=====Get child by Xpath=====");
        List<WebElement> sections = driver.findElements(By.xpath("//section[@id='protocol'] //section"));
        String title = sections.get(2).findElement(By.xpath(".//*[@class='secno']")).getText();
        System.out.println(title);
        String expect  = "6.3";
        assertTrue(String.format(("actual is '%s', expect is '%s'"), title, expect), title.equals(expect));
        System.out.println("\n\n");
    }
    
    /**
     * Get child of element by css Selector
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findChildBySelector() {
        System.out.println("=====Get child by css Selector=====");
        List<WebElement> sections = driver.findElements(By.cssSelector("#protocol section"));
        String title = sections.get(2).findElement(By.cssSelector("h3")).getText();
        System.out.println(title);
        String expect  = "6.3 Processing model";
        assertTrue(String.format(("actual is '%s', expect is '%s'"), title, expect), title.equals(expect));
        System.out.println("\n\n");
    }
    
    /**
     * Get child of element by css Selector
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findChildByClass() {
        System.out.println("=====Get child by Class=====");
        List<WebElement> sections = driver.findElements(By.cssSelector("#protocol section"));
        String title = sections.get(2).findElement(By.className("secno")).getText();
        System.out.println(title);
        String expect  = "6.3";
        assertTrue(String.format(("actual is '%s', expect is '%s'"), title, expect), title.equals(expect));
        System.out.println("\n\n");
    }
    
    /**
     * Get element by javascript
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findByJavaScript() {
        System.out.println("=====Get by JavaScript=====");
        String expect = "Execute Async Script";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dfn-execute-async-script")), 20l);
        WebElement elem = (WebElement)((JavascriptExecutor)driver).executeScript("return document.getElementById('dfn-execute-async-script');");
        String text = elem.getText();
        assertTrue(String.format(("actual is '%s', expect is '%s'"), text, expect), text.equals(expect));
        System.out.println("\n\n");
    }
    
    /**
     * Get element by linktext
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findByLinkText() {
        System.out.println("=====Get by LinkText=====");
        String expect = "https://github.com/w3c/webdriver/";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dfn-execute-async-script")), 20l);
        WebElement elem = driver.findElement(By.linkText("GitHub w3c/webdriver"));
        String text = elem.getAttribute("href");
        assertTrue(String.format(("actual is '%s', expect is '%s'"), text, expect), text.equals(expect));
        System.out.println("\n\n");
    }
    
    /**
     * Get element by partialLinkText
     */
    @RepeatedTest(value = 20, name = RepeatedTest.CURRENT_REPETITION_PLACEHOLDER)
    public void findByPartialLinkText() {
        System.out.println("=====Get by LinkText=====");
        String expect = "https://github.com/w3c/webdriver/";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dfn-execute-async-script")), 20l);
        WebElement elem = driver.findElement(By.partialLinkText("GitHub w3c/webdriver"));
        String text = elem.getAttribute("href");
        assertTrue(String.format(("actual is '%s', expect is '%s'"), text, expect), text.equals(expect));
        System.out.println("\n\n");
    }
    
    @AfterAll
    public void afterAll(){
        driver.quit();
    }
}
