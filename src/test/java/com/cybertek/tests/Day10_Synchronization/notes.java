package com.cybertek.tests.Day10_Synchronization;


/*
Synchronization:
    Thread.sleep()
    implicit wait
    explicit wait
    fluent wait

    Thread.sleep(1000) -->> this method is from java, not related to Selenium. This method is used to pause the program.
                            it waits for the duration given. Be careful not to use too long or too little time. The program waits specific time you eneter, it is not being smart.
                            it is recommended to minimize the use of thread.sleep(). Using too much thread.sleep() slows the execution down.
                            it is like the pause  button in remote.
                            it's a hard coded wait

    implicitWait    -->>>   this is a wait/synchronization option from selenium.
                            It takes 2 params:
                                            1. amount of time
                                            2. unit of time (seconds, milliseconds, days)

                            this method wait for elements to be found in HTML. It only works when we call the findElement method.
                            thus it has to be declared once in the class, and any time we use the findElement() method, it will be executed
                            implicitWait waits only until element is located.
                            implicit wait is set once, then it is used by the rest of the program. if we have many findElement() methods, they will all use the same Implicit wait.


    How findElement method works:
        1. we provide some locators
        2. call the method
        3. it goes page and try find element
        4. if element found it will return the element
        5. if not found it will return the method
        6. it will check if we have implicit wait set
        7. it will keep trying to find the element during that time
        8. if element found during that time it will return the element
        9. if not found: will return: NoSuchElementException


      implicitWait() does not work with findElements().

      thread.sleep --> wait every time when we call it
      implicit wait ->> call one time, it will wait when finding element

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //written once, but is being used by all of the findElement() methods in the Test classes
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);   // waits until page is loaded






  Explicit wait:

     //click on start
        driver.findElement(By.tagName("button")).click();
     //enter username but element is not visible
        driver.findElement(By.id("username")).sendKeys("username");
    //this is what we get   ElementNotIntractableException exception

    this means we have to wait for it to be visible
    sometimes we wait for element to be enabled, we can wait for element ti have a certain text, element disappear, title to have certain text
    When we wait for specific things to happen we use Explicit wait.

    ElementNotIntractableException   -->> means, the element is found, but can't interact with it. it is hidden


        //Create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebDriverWait ->> class used to explicit wait
        it takes 2 params: driver, time in seconds

      expectedConditions.elementTobeClickable() -->> waits until the element is clickable

      Depending on which condition we are using, we pass webElement, By locator or text to the expected conditions.

      In explicit wait, waiting happens when we call the wait.until() method.
      ExplicitWait waits for the condition to complete, once the condition is met, it will stop waiting.


  TimeoutException -->> if the condition is not met, and the time runs out we get TimeoutException




  Thread    -->>    we call it every time we need it.
                    waits for whole duration

  Implicit  -->>    set/called only one time. works every time we have a findElement method
                    waits until element is found or time runs out
                    waits while trying to find element

  Explicit  -->>    call every time you need it.
                    waits until element is found or time runs out
                    waits for different conditions

  Fluent is just like explicit wait. It is more customizable version of the explicit.



  When the website is loading which one we use?!



 */
public class notes {
}
