/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author TuyenNV22
 */
public class Wait {

    public static void untilJqueryIsDone(WebDriver driver) {
        untilJqueryIsDone(driver, 30l);
    }

    public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
        until(driver, (d)
                -> {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) {
                System.out.println("JQuery call is in Progress");
            }
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    public static void untilPageLoadComplete(WebDriver driver) {
        untilPageLoadComplete(driver, 30l);
    }

    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds) {
        until(driver, (d)
                -> {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) {
                System.out.println("Document is loading");
            }
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
        until(driver, waitCondition, 30l);
    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
