require './features/page_objects/facebook@work/login.rb'
require 'selenium-webdriver'

facebook = Facebook::Login.new()
facebook.driver_chrome()
facebook.load_page()
print facebook.find_by_xpath("//*[@class='_50f6']").text
facebook.quit()