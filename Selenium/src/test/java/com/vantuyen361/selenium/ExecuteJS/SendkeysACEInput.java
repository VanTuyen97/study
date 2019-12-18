/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.ExecuteJS;

import com.vantuyen361.selenium.Page;
import com.vantuyen361.selenium.wait.Wait;
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

/**
 *
 * @author TuyenNV22
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class SendkeysACEInput {

    private WebDriver driver;
    private Wait wait;

    @BeforeAll
    public void beforeAll() {
        Page page = new Page(1);
        driver = page.driver;
        wait = new Wait(driver, 60);
        driver.get("https://ace.c9.io/");
        wait.untilPageLoadComplete(90l);
    }

    /**
     * Get child of element by xpath
     */
    @Test
    public void sendkeysACEInput() {
        System.out.println("=====Get Element=====");
        String id = "ace_editor_demo";
        String expect = "helo";
        wait.untilPageLoadComplete(90l);
        WebElement textACE = driver.findElement(By.id(id));
        ((JavascriptExecutor)driver).executeScript(
                "var editor = ace.edit(arguments[0]);\n" +
                "editor.setValue(arguments[1]);"
                , id, expect);
        WebElement e = driver.findElement(By.cssSelector("#ace_editor_demo .ace_line .ace_identifier"));
        String text = e.getText();
        assertTrue(String.format("actual is %s, expect is %s", text, expect), text.equals(expect));
    }
    
    @AfterAll
    public void afterAll() {
        driver.quit();
    }
}
