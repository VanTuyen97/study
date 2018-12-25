/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vantuyen361.testng.factory;

import com.vantuyen361.testng.Support;
import org.testng.annotations.Test;

/**
 *
 * @author vantuyen361
 */
public class UnitTest extends Support{
    
    public static int count = 0;
    
    public int uniquite(){
        count += 1;
        return count;
    }
    
    @Test
    public void testMethod(){
        log("test " + uniquite());
    }
}
