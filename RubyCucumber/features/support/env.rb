require 'rubygems'
require 'selenium-webdriver'
# require "step_definitions/*/*.rb"
# require "page_objects/*/*.rb"
# include Test::Unit::Assertions

Before do |scenario|
#   profile = Selenium::WebDriver::Firefox::Profile.from_name('tudm2')
#   caps = Selenium::WebDriver::Remote::Capabilities.firefox(firefox_options: {profile: profile})
#   @browser = Selenium::WebDriver.for :firefox, desired_capabilities: caps
#   @browser.manage.timeouts.implicit_wait = 10
#   $wait = Selenium::WebDriver::Wait.new(:timeout => 10)
    @browser = Selenium::WebDriver.for :firefox
end

After do |scenario|
  @browser.quit
end