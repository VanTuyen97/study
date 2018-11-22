require 'require_all'
require_rel '../support.rb'

module Facebook
  class Login < Support
    def initialize()
      super()
      @url = 'https://www.facebook.com/login/device-based/regular/login/'      
    end

    def input(email, password)
      find_by_xpath("//*[@name='email']").send_keys email
      find_by_xpath("//*[@name='pass']").send_keys password
    end

    def login_click()
      @wait.until {find_by_xpath("//*[@name='login']").enabled?}
      find_by_xpath("//*[@name='login']").click
    end
  end
end