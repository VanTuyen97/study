Given("I start browser") do
  @browser.driver_firefox()
end

When("I access facebook login page") do
  @browser.load_page()
end

When("I input email - {string} with password - {string}") do |email, password|
  @browser.input(email, password)
end

When("I click login button") do
  @browser.login_click()
end

Then("login facebook success") do
  assert(@browser.verify(),"login failure")
end