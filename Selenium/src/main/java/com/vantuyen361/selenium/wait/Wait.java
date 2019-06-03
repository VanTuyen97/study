/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.wait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author TuyenNV22
 */
public class Wait extends WebDriverWait {

    private final long timeout;
    private final WebDriver driver;

    public Wait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
        this.timeout = timeOutInSeconds;
        this.driver = driver;
    }
    
    /**
     * wait was supported by framework
     *
     * @param xpath
     */
    public void waitExpect(String xpath) {
        this.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void untilJqueryIsDone(Long timeoutInSeconds) {
        until((d)
                -> {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) {
                System.out.println("JQuery call is in Progress");
            }
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    /**
     * wait until load page success
     *
     * @param timeoutInSeconds
     */
    public void untilPageLoadComplete(Long timeoutInSeconds) {
        until((d)
                -> {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) {
                System.out.println("Document is loading");
            }
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    /**
     * Wait until timeout
     *
     * @param waitCondition
     * @param timeoutInSeconds
     */
    public void until(ExpectedCondition waitCondition, Long timeoutInSeconds) {
        try {
            withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
            until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            withTimeout(this.timeout, TimeUnit.SECONDS);
        }
    }
}
