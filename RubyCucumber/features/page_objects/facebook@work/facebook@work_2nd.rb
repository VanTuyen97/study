class FBwork2nd
  def initialize(browser)
    @browser = browser
  end

  def choose
    software_bt = "//span[text()='FPT Software']"
    @browser.find_element(:xpath, software_bt).click
  end
end