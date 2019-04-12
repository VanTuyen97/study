# Selenium webdriver
## Concept
1. [Selenium](https://en.wikipedia.org/wiki/Selenium_(software)): is a portable software-testing framework for web applications.
2. [Selenium WebDriver](https://en.wikipedia.org/wiki/Selenium_(software)#Selenium_WebDriver): accepts commands (sent in Selenese, or via a Client API) and sends them to a browser.
  
3. [Xpath](https://developer.mozilla.org/en-US/docs/Web/XPath):  is a query language for select nodes from an xml.

## Required

1. [Download](https://docs.seleniumhq.org/docs/03_webdriver.jsp#setting-up-a-selenium-webdriver-project) selenium webdriver java client and setup environment.

2. Download browser driver.

   - [FireFoxDriver](https://github.com/mozilla/geckodriver/releases).
  
   - [Chrome](http://chromedriver.storage.googleapis.com/index.html): [config](https://sites.google.com/a/chromium.org/chromedriver/capabilities) chrome.

## Use
1. [Step 1](https://docs.seleniumhq.org/docs/03_webdriver.jsp#selenium-webdriver-s-drivers): Load browser driver ([WebDriver](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.html)).
   ```java
   WebDriver driver = new ChromeDriver();
   ```

2. [Step 2](https://docs.seleniumhq.org/docs/03_webdriver.jsp#fetching-a-page): Load a page.
   ```java
   driver.get("http://www.google.com");
   ```

3. [Browser command (driver)](http://toolsqa.com/selenium-webdriver/browser-commands/).
   <details>

    - Get: load page 
        ```java
        driver.get("http://www.google.com");
        ```
    - [Get title](http://toolsqa.com/selenium-webdriver/browser-commands/#crayon-5becdfd0e68a5485172444): fetches the Title of the current page
        ```java 
        driver.getTitle();
        ```
    - [Get current URL](http://toolsqa.com/selenium-webdriver/browser-commands/#crayon-5becdfd0e68ae700958072): fetches the string representing the Current URL which is opened in the browser.
        ```java 
        driver.getCuuentUrl();
        ```
    - [Get page source](http://toolsqa.com/selenium-webdriver/browser-commands/#crayon-5becdfd0e68b0312844027): This method returns the Source Code of the page.
        ```java
        driver.getPageSource();
        ```
    - [Close](http://toolsqa.com/selenium-webdriver/browser-commands/#crayon-5becdfd0e68b1466950791): This method Close only the current window the WebDriver is currently controlling.
        ```java 
        driver.close();
        ```
    - [Quit](http://toolsqa.com/selenium-webdriver/browser-commands/#crayon-5becdfd0e68b2704684749): This method Closes all windows opened by the WebDriver.
        ```java
        driver.quit();
        ```
   </details>
4. [Navigation command](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html).
    ```java 
    driver.navigate();
    ```
   <details>

    - [back()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html#back--): Move back a single "item" in the browser's history.
  
    - [forward()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html#forward--): Move a single "item" forward in the browser's history.
  
    - [refresh()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html#refresh--): Refresh the current page.
  
    - [to(String url)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html#to-java.lang.String-): Load a new web page in the current browser window.
  
    - [to(java.net.URL url)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebDriver.Navigation.html#to-java.net.URL-): Overloaded version of to(String) that makes it easy to pass in a URL.
   </details>
5. [Explicit and Implicit Waits](https://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp#explicit-and-implicit-waits).
   - [Explicit wait](https://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp#explicit-waits): define to wait for a certain condition to occur before proceeding further in the code. use [ExpectedConditions](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html) class
        ```java
        wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
        ```
   - [Implicit Waits](https://docs.seleniumhq.org/docs/04_webdriver_advanced.jsp#implicit-waits): An implicit wait is to tell WebDriver to poll the DOM for a certain amount of time when trying to find an element or elements if they are not immediately available.
        ```java
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ```
6. [Fetch a element](https://docs.seleniumhq.org/docs/03_webdriver.jsp#locating-ui-elements-webelements): return object `WebElement`
   <details>
   
   - [By ID](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-id).
        ```java
        driver.findElement(By.id("coolestWidgetEvah"));
        ```
   - [By Class Name](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-class-name).
        ```java
        driver.findElements(By.className("cheese"));
        ```
   - [By Tag Name](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-tag-name).
        ```java
        driver.findElement(By.tagName("iframe"));
        ```

   - [By Name](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-name).
        ```java 
        driver.findElements(By.className("cheese"));
        ```
   - [By link Text](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-link-text).
        ```java
        driver.findElement(By.tagName("iframe"));
        ```
   - [By Partial link text](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-partial-link-text).
        ```html
        <a href="http://www.google.com/search?q=cheese">search for cheese</a>>
        ```
        ```java
        driver.findElement(By.linkText("cheese"));
        ```
   - [By CSS](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-css).
        ```html
        <div id="food"><span class="dairy">milk</span><span class="dairy aged">cheese</span></div>
        ```
        ```java
        driver.findElement(By.cssSelector("#food span.dairy.aged"));
        ```
   - [By Xpath](https://docs.seleniumhq.org/docs/03_webdriver.jsp#by-xpath).
        ```java
        driver.findElements(By.xpath("//input"));
        ```
   - [Using JavaScript](https://docs.seleniumhq.org/docs/03_webdriver.jsp#using-javascript). 
        ```java 
        (WebElement) ((JavascriptExecutor)driver).executeScript("return $('.cheese')[0]");
        ```
    </details>
7. [Use element](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html): use object `WebElement`
   ```java
    driver.findElement(By.id("coolestWidgetEvah"));
   ```
   <details>

   - [clear()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#clear--): If this element is a text entry element, this will clear the value.
  
   - [click()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#click--): Click this element.
  
   - [findElement(By by)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#findElement-org.openqa.selenium.By-): Find the first WebElement using the given method.
  
   - [getAttribute(String name)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getAttribute-java.lang.String-): Get the value of the given attribute of the element.
  
   - [getCssValue(String propertyName)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getCssValue-java.lang.String-): Get the value of a given CSS property.
  
   - [getLocation()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getLocation--): Where on the page is the top left-hand corner of the rendered element?.
  
   - [getRect()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getRect--).
  
   - [getSize()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getSize--): What is the width and height of the rendered element?
  
   - [getTagName()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#getTagName--): Get the tag name of this element.
  
   - [getText()](https://docs.seleniumhq.org/docs/03_webdriver.jsp#getting-text-values): Get the visible (i.e).
  
   - [isDisplayed()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#isDisplayed--): Is this element displayed or not? This method avoids the problem of having to parse an element's "style" attribute.
  
   - [isEnabled()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#isEnabled--): Is the element currently enabled or not? This will generally return true for everything but disabled input elements.
  
   - [isSelected()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#isSelected--): Determine whether or not this element is selected or not.
  
   - [sendKeys(CharSequence... keysToSend)](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#sendKeys-java.lang.CharSequence...-): Use this method to simulate typing into an element, which may set its value.
  
   - [submit()](https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html#submit--): If this current element is a form, or an element within a form, then this will be submitted to the remote server.
  
    </details>
## Tip:
1. Default, Internet Explorer don't support Scroll: We have to setup `onscroll = true` to browser support this.
```java
((JavascriptExecutor) driver).executeScript("onscroll = true; arguments[0].scrollIntoView(true);", e);
```
