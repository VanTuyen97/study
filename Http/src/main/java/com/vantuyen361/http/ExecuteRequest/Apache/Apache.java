/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.http.ExecuteRequest.Apache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author TuyenNV22
 */
public class Apache {
    public static void main(String[] args) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request1 = new HttpGet(args[0]);//get request to URL
        HttpResponse response1 = client.execute(request1);
        int code = response1.getStatusLine().getStatusCode();
        
        if(code != 200){
            System.out.println("request false");
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader((response1.getEntity().getContent())));) {
            // Read in all of the post results into a String.
            StringBuffer output = new StringBuffer();
            Boolean flag = true;
            while (flag) {
                String currentLine = br.readLine();
                if (currentLine == null) {
                    flag = false;
                } else {
                    output.append(currentLine);
                }
            }
            System.out.println("Response-->" + output);
        } catch (Exception e) {
            System.out.println("Exception" + e);

        }

    }
}
