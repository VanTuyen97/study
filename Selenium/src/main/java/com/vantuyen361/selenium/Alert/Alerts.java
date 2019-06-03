/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.Alert;

import com.vantuyen361.selenium.Page;
import java.io.IOException;
import org.openqa.selenium.Alert;

/**
 *
 * @author TuyenNV22
 */
public class Alerts extends Page {
    private Alert alert;

    public Alerts(long timeoutSeconds) {
        super(timeoutSeconds);
    }

    @Override
    protected void init() throws IOException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.loadPage();
        this.alert = this.driver.switchTo().alert();
    }
    
    public void sendkey(){
        this.alert.sendKeys("this is Alert!");
    }
    
    public static void main(String [] args){
        Alerts alerts = new Alerts(2);
        alerts.sendkey();
        alerts.quit();
    }
    
}
