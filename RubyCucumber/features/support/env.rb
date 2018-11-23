# import will used with all file.rb
require 'rubygems'
require 'require_all'
require 'selenium-webdriver'
# import assertions
require "test/unit/assertions"
include Test::Unit::Assertions
# require_rel "../step_definitions/stepdefs.rb"
# require_rel "../page_objects/facebook@work/login.rb"

Before do |scenario|
  @browser = Facebook::Login.new()
end

After do |scenario|
  @browser.quit if @browser.browser
end