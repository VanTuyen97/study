/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.studyspring.Properties.javaSE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author TuyenNV22
 */
public class Main {

    private Properties properties;
    private static final String PATH = "/global.properties";
    private String path;

    public Main(String path) throws IOException {
        this.path = path;
        this.loadProperties1();
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
//        System.out.println("print: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        try {
//            final Properties properties = new Main().loadProperties2("/global.properties");
//            System.out.println(properties.keySet().toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Main main = new Main(PATH);
        main.setProperties("vantuyen", "99");
    }

    public void setProperties(String key, String value) throws IOException, URISyntaxException,FileNotFoundException  {
        URL url = this.getClass().getResource(this.path);
        
        File file = Paths.get(url.toURI()).toFile();
        FileOutputStream out = new FileOutputStream(file);
        
        this.properties.setProperty(key, value);
        this.properties.store(out, null);
        out.close();
    }

    /**
     * load file properties from classpath (resources) use non-static method.
     * @return
     * @throws IOException
     */
    private void loadProperties1() throws IOException {
        this.properties = new Properties();
        InputStream stream = this.getClass().getResourceAsStream(this.path);
        properties.load(stream);
    }

    /**
     * load file properties from classpath (resources) use static method.
     *
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
