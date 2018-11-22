require 'selenium-webdriver'
require 'rubygems'

# support many method for selenium
class Support
    @browser = nil
    @url = nil
    @wait = nil

    #setter @browser
    def browser=(browser)
        @browser = browser
    end

    #getter @browser
    def browser
        return @browser
    end

    #setter @url
    def url=(url)
        @url = url
    end

    #getter @browser
    def url
        return @url
    end

    #init object page
    def initialize (browser = nil, url = nil) 
        @browser = browser
        @url = url
        @wait = Selenium::WebDriver::Wait.new(:timeout => 10)
    end

    #find element with xpath
    def find_by_xpath(xpath)
        element = @wait.until { @browser.find_element(:xpath, xpath)}
        @wait.until {element.displayed?}
        return element
    end

    #find element with id
    def find_by_id(id)
        @browser.find_element(:id, id)
    end

    #find element with class name
    def find_by_class(class_name)
        @browser.find_element(:class, class_name)
        # @browser.find_element(:class_name, class_name)
    end

    #load page
    def load_page()
        @browser.get url if @url
    end

    # load chrome driver
    def driver_chrome()
        #--disable-notifications: disable notification for chrome
        #disable-infobars: don't allow display string "chrome is being controlled by automated test software" when chrome run
        caps = Selenium::WebDriver::Remote::Capabilities.chrome(chromeOptions: {args: ["disable-infobars", "--disable-notifications"]})
        @browser = Selenium::WebDriver.for :chrome, desired_capabilities: caps
        @browser.manage.timeouts.implicit_wait = 10 #wait 10 seconds
    end

    # load firefox driver
    def driver_firefox()
        @browser = Selenium::WebDriver.for :firefox
        @browser.manage.timeouts.implicit_wait = 10 #wait 10 seconds
    end

    #print value object
    def display()
        print "@browser: \t" + @browser.to_s() + "\n" if @browser
        print "@url:     \t" + @url + "\n" if @url
    end

    def quit()
        @browser.quit
    end
end