/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import global.Common;

/**
 *
 * @author vantuyen361
 */
public class Runnable_Lambda extends Common{

    /**
     * using {@link java.lang.Runnable} in lambdas
     */
    public void runnable_Lambda() {
        this.log("\n=== Runnable_Lambda ===");
        Runnable r2 = () -> System.out.println("create instance Runnable use Lambda");
        r2.run();
    }

    public void runnable() {
        this.log("\n=== Runnable_Lambda ===");
        
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log("create instance Runnable");
            }
        };
        
        r1.run();
    }
}
