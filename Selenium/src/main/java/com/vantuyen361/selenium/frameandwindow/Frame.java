/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.frameandwindow;

import com.vantuyen361.selenium.Page;
import java.io.IOException;

/**
 *
 * @author TuyenNV22
 */
public class Frame extends Page {

    public void getWindowHandle() {
        this.log("GetWindowHandle Command", this.driver.getWindowHandle());
    }

    public void getWindowHandles() {
        this.log("GetWindowHandles Command");
        this.driver.getWindowHandles().forEach(result -> {
            this.log("", result);
        });
    }

    public void switchToWindow() throws InterruptedException {
        this.log("SwitchTo Window Command");
        for (String result : this.driver.getWindowHandles()) {
            this.driver.switchTo().window(result);
            this.log("\t win", result);
            Thread.sleep(1000);
        }
    }

    public void switchToFrame() throws InterruptedException {
        String nameFrame ="";
        this.log("SwitchTo Frame Command");
        this.driver.switchTo().frame(nameFrame);
        this.log("\t frame", nameFrame);
        Thread.sleep(1000);

    }

}
