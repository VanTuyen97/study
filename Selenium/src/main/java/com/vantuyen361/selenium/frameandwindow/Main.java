/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.selenium.frameandwindow;

import java.io.IOException;

/**
 *
 * @author TuyenNV22
 */
public class Main {
    public static void main(String[]args) throws IOException{
        Frame frame = new Frame();
        frame.getWindowHandle();
        frame.getWindowHandles();
        frame.quit();
    }
}
