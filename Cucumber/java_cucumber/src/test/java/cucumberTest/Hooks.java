/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cucumberTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author TuyenNV22
 */
public class Hooks {
    
    private final static Logger log = LogManager.getLogger(Hooks.class);

    /**
     * run before the first step of each scenario
     */
    @Before
    public void doSomethingBefore() {
        log.info("@Before run before the first step of each scenario");
    }

    @After
    public void doSomethingAfter(Scenario scenario) {
        log.info("@After run after the last step of each scenario");
    }

    @BeforeStep
    public void doSomethingBeforeStep(Scenario scenario) {
        log.info("@BeforeStep before a step");
    }

    @AfterStep
    public void doSomethingAfterStep(Scenario scenario) {
        log.info("@AfterStep after a step");
    }
}
