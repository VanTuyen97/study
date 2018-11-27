package cucumberTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartIT {

    private final static Logger log = LogManager.getLogger(StartIT.class);

    @Given("today is Sunday")
    public void today_is_Sunday() {
        log.info("today is Sunday");
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        log.info("I ask whether it's Friday yet");
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        log.info("I should be told");
    }
}
