class FBwork3rd
  def initialize(browser)
    @browser = browser
  end

  def inputinfo(email, pw)
    @email = email
    @pw = pw
    email_txtbx =  "//input[@id=\"userNameInput\"]"
    pw_txtbx = "//input[@id=\"passwordInput\"]"
    signin_bt =  "//span[@id=\"submitButton\"]"

    @browser.find_element(:xpath, email_txtbx).send_keys(@email)
    @browser.find_element(:xpath, pw_txtbx) .send_keys(@pw)
    @browser.find_element(:xpath, signin_bt).click
  end
end