class FBwork1st
  def initialize(browser)
    @browser = browser
  end

  def login
    login_bt = "//button[@type='submit']"
    @browser.find_element(:xpath, login_bt).click
  end
end