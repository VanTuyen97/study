/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.ExecuteJS;

import com.vantuyen361.selenium.Page;
import com.vantuyen361.selenium.wait.Wait;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author TuyenNV22
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class ExecuteAsynScript {

    private WebDriver driver;
    private Wait wait;

    @BeforeAll
    public void beforeAll() {
        Page page = new Page(1);
        driver = page.driver;
        wait = new Wait(driver, 60);
        driver.get("https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html");
        wait.untilPageLoadComplete(90l);
    }

    @Test
    public void sendRequest() {
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        String expect = "{\n"
                + "  \"userId\": 1,\n"
                + "  \"id\": 1,\n"
                + "  \"title\": \"delectus aut autem\",\n"
                + "  \"completed\": false\n"
                + "}";
        String response = (String) ((JavascriptExecutor) driver).executeAsyncScript(
                "var callback = arguments[arguments.length - 1];"
                + "callRequest = function(link) {\n"
                + "	var xhr = new XMLHttpRequest();\n"
                + "	xhr.open('GET', link, true);\n"
                + "     xhr.onreadystatechange = function() {\n"
                + "        if (xhr.readyState == 4) {\n"
                + "            callback(xhr.responseText);\n"
                + "        }\n"
                + "    };\n"
                + "    xhr.send();\n"
                + "};\n"
                + "callRequest(arguments[0]);\n"
        , "https://jsonplaceholder.typicode.com/todos/1");

        System.out.println(response);
        assertTrue(String.format("result is %s, expect is %s", response, expect), response.equals(expect));
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }
}
