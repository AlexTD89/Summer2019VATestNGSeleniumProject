package com.cybertek.tests.Day14_Framework_Design_properties_driver_class_test_base_class;

/*
    Today's topic
            Framework design
            Properties file
            Reading from properties

            Singleton pattern
            New version of the webdriver factory
            Test base



    _________

    Tell about your framework?

    Automation framework is integrated system, organization of packages, files, classes, tools in a way that it makes writing and maintaining automated tests easy. Good framework must be easy to use , easy to maintain, easy to scale, easy to report
        Good framework must be:
            easy to  use
            easy to maintain
            easy to scale
            reusable
            report

    _________________

    Properties file

        1. Open InteliJ
        2. RightClick on the name of the project
        3. Name -> file
        4. Enter name: configuration.properties
        5. OK

       Single responsibility principle

       Create a properties reader file
            1. Right click on the utilities package
            2. New -> class
            3. Enter name: ConfigurationReader
            4. OK


   _____________________________
   from the Configuration File:

   url=https://qa3.vytrack.com/user/login       << This is property (more code > properties)

   Property is made of key and value
   left side of = is key
   Right side of = value




   Singleton is design pattern
   Singleton design lets us use the same version of an object across the whole program.



    Create a driver utility file
        1.Right click on the utilities package
        2.New
        3.Enter name: Driver
        4. OK
                We can open browser headless meaning we di not actually see it.

    chrome-headless (in the Driver File) ->> will open a browser which we can't visually see, BUT it runs ways faster then regular browser




    What happens : WebDriver driver = Driver.get();
        1. We call the get method from driver class
        2. It calls the configuration reader to read value from properties file
        3. Based in the value returned it will open browser.


     Create a TestBase class:
        1. Right click on the tests package
        2. New ->> class
        3. Enter name: TestBase
        4. Ok
                TestBase contains common variable and methods to all tests. Other test classes well extend the testBase.


 */


public class Notes {
}

/*
                        # BROWSER TYPE
                        # KEY=VALUE, IT IS LIKE A MAP IN JAVA
                        # WE CAN SET EVERY KIND OF DATA
                        browser=chrome
                        #URL OF OUR WEB APPLICATION
                        url= https://qa1.vytrack.com/
                        # CREDENTIALS
                        user_name= storemaneger
                        password = UserUser123
                        # WE CAN MODIFICATE ALL CREDENTIALS
 */