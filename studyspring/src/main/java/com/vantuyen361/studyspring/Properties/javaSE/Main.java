/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.javaSE;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author TuyenNV22
 */
public class Main {

    public static void main(String[] args){
        System.out.println("print: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        try {
            final Properties properties = new Main().loadProperties2("/global.properties");
            System.out.println(properties.keySet().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * load file properties from classpath (resources) use non-static method.
     * @param fileClasspath is string start by / and name of file properties.
     * @return
     * @throws IOException 
     */
    private Properties loadProperties1(String fileClasspath) throws IOException {
        Properties properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream(fileClasspath);
        properties.load(stream);
        return properties;
    }
    
    /**
     * load file properties from classpath (resources) use static method.
     * @param fileClasspath is string start by / and name of file properties.
     * @return
     * @throws IOException 
     */
    private static Properties loadProperties2(String fileClasspath) throws IOException {
        Properties properties = new Properties();
        InputStream stream = Main.class.getClass().getResourceAsStream(fileClasspath);
        properties.load(stream);
        return properties;
    }
}
