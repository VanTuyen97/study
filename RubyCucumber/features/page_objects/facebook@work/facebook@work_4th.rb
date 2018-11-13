class FBwork4th
  def initialize(browser)
    @browser = browser
  end

  def writepost(post)
    @post = post

    write_txtbx = "//textarea[contains(@placeholder,'Write something...')]"
    @browser.find_element(:xpath, write_txtbx)
    @browser.find_element(:xpath, write_txtbx).send_keys(@post)

    post_bt = "//button[@data-testid='react-composer-post-button']"
    $wait.until {@browser.find_element(:xpath, post_bt).enabled?}
    @browser.find_element(:xpath, post_bt).click
  end

  def verifypost
    post_txt = "//p[contains(.,'post')]"
    $wait.until {@browser.find_element(:xpath, post_txt).displayed?}
  end
end