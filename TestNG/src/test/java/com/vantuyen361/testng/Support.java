package com.vantuyen361.testng;

/**
 * Provider many method support test
 *
 * @author TuyenNV22
 *
 */
public class Support {

    /**
     * write message to file log
     *
     * @param message
     */
    public void log(String message) {
        System.out.println(Thread.currentThread().getStackTrace()[2].toString() + ":   \t" + message);
    }
}
