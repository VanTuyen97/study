# module FridayStepHelper
#   def is_it_friday(day)
#     if day == 'Friday'
#       p 'TGIF'
#     else
#       p 'Nope'
#     end
#   end
# end
# World FridayStepHelper

# Given("today is Friday") do
#   @today = 'Friday'
# end

# Given("today is Sunday") do
#   @today = 'Sunday'
# end

# When("I ask whether it's Friday yet") do
#   @actual_answer = is_it_friday(@today)
# end

# Then("I should be told {string}") do |expected_answer|
#   expect(@actual_answer).to eq(expected_answer)
# end


# require 'rubygems'
# require 'selenium-webdriver'

# Given(/^I am on the Google search page$/) do
#   @driver = Selenium::WebDriver.for :firefox
#   @driver.get "http://google.com"
# end

# When("I search for {string}") do |string|
#   element = @driver.find_element(name: "q")
#   element.send_keys "Cheese!"
#   element.submit
# end

# Then("the page title should start with {string}") do |string|
#   wait = Selenium::WebDriver::Wait.new(timeout: 10)
#   wait.until { @driver.title.downcase.start_with? "cheese!" }
#   puts "Page title is #{@driver.title}"
#     @driver.close
# end

# Given("I'm {int} \\(year)(s) old!") do |age|
#   puts "age: #{age}"
# end
Given(/^I am at facebook @ work login page$/) do
  @login = FBwork1st.new(@browser)
  @browser.get "https://fpt.facebook.com/groups/237769780236209/"
end

When(/^I hit log in$/) do
  @login.login
end

When(/^I choose my branch$/) do
  @choose = FBwork2nd.new(@browser)
  @choose.choose
end

When(/^I input my info as "(.*)" and "(.*)" and signin$/) do |email, pw|
  @signin = FBwork3rd.new(@browser)
  @signin.inputinfo(email, pw)
end

When(/^I input my post as "(.*)"$/) do |post|
  @post = FBwork4th.new(@browser)
  @post.writepost(post)
end

Then(/^I should see the post$/) do
  @post.verifypost
end
