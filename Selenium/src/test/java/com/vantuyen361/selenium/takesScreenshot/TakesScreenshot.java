/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.takesScreenshot;

import com.vantuyen361.selenium.Page;
import com.vantuyen361.selenium.wait.Wait;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author TuyenNV22
 */
@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TakesScreenshot {

    private WebDriver driver;
    private Wait wait;

    @BeforeAll
    public void beforeAll() {
        Page page = new Page(1);
        driver = page.driver;
        wait = new Wait(driver, 60);
        driver.get("https://w3c.github.io/webdriver/");
        wait.untilPageLoadComplete(90l);
    }
    
    @Test
    public void captureScreenBrowser() throws IOException {
        byte [] srcFile = ((org.openqa.selenium.TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES); // Take screen shot
        ByteArrayInputStream bis = new ByteArrayInputStream(srcFile);
        BufferedImage image = ImageIO.read(bis);
        ImageIO.write(image, "jpg", new File("screen.jpg"));
        assertTrue("Could not capture Screen", new File("screen.jpg").isFile());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }
}
