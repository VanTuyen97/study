package com.vantuyen361.testng.priority;

import com.vantuyen361.testng.Support;
import org.testng.annotations.Test;

public class PriorityTest extends Support {

    @Test(priority=3)
    public void Test1() {
        log("test1 priority is 3");
    }
    
    @Test(priority=2)
    public void test2() {
        log("test2 priority is 2");
    }
    
    @Test(priority=1)
    public void test3() {
        log("test3 priority is 1");
    }
}