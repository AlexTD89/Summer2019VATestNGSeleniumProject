package com.cybertek.tests.Day_xml_runner;

/*

    XML -> file type used to store and transfer data. It uses html like format, unlike html xml does not have pre defined tags.


    TestNG xml runners ->> another way of triggering testNG tests.

    TODO:
    Create testng xml runner file
    1. right click on the name of the project
    2. New -> file
    3. Enter name: testng_runner.xml
    4. OK
    5. add this line to the xml file: this line tells that it is being used for testNG, this line makes the file xml runner
            <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

    6. next code put it in file: this file says -->> using testng xml runner we group our tests in different ways and execute
            <suite name="Vytrack automation" verbose="1">

            </suite>


    7. following code: show which package to run
            <test name="Vytrack smoke test">
                <packages>
                    <package name="com.cybertek.tests.Day16_page_object_model_2"></package>
                </packages>
            </test>

     8. run the file,

     9. to add more packages write this line with the package wanted again
            <package name="com.cybertek.tests.Day17..."></package>
            <package name="com.cybertek.tests.Day18..."></package>
            <package name="com.cybertek.tests.Day19..."></package>



     This is a smoke test



     HOW TO RUN ALL THE TESTS: (BUT NOT RECOMMENDED) (IF YOU HAVE UNSTABLE TESTS)wa
                    <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
                    <suite name="Vytrack automation" verbose="1">
                    <!--    HOW TO RUN A SPECIFIC PACKAGE-->
                        <test name="Vytrack smoke test">
                            <packages>
                                <package name=".*"></package>
                            </packages>
                        </test>
                    </suite>



in testng xml we can pass parameters to the test from the xml   ->>     <parameter name="env" value="qa1"></parameter>
    we are passing variable called name, and it's value is "qa1".
       THEN we go to the TestBase->> beforeMethod ->> and do some chnages there



   @Optional ->



        runner.xml can only run testNG tests !!!!!






cmd+/  ->> comment a code











 */


public class notes {


}
