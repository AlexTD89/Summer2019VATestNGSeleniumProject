package com.cybertek.tests.Day18_Data_Driven_Testing;

/*
    > Data driven testing
    > Keyword driven testing
    > Test code/script and test data

    In Data driven testing we separate test data and test code. We design our test code in a way that int can read the data and execute tests based on it.
    Our test code will have the test steps. Test input data will be in external sources. Our test data will decide how many times a test case will run.

    Data driven testing is executing a certain test case against multiple sets of data.

    excel, CSV, json, xml, database, api -> external data source

    CSV -> comma separated values.


    How do you do data driven testing:
        We use apache poi libraries to do data driven testing because we store out test data in excel files.
        add dependencies apache poi to the pom file:

                        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi</artifactId>
                            <version>4.1.0</version>
                        </dependency>
                        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi-ooxml</artifactId>
                            <version>4.1.0</version>
                        </dependency>

        Apache poi -> used for excel files with xls extension
        Apache POI - ooxml  -> used for excel files with xlsx extension


        Create a utility file: ExcelUtil

        How to read excel file:
                 FileInputStream ->>    reads a file, we create fileInputStream object providing the file path
                 Workbook   ->> this is form apache poi library. Using this class we open excel file. We create workbook by providing fileInputStream
                 Sheet  ->> WorkSheet ->>  from workbook we create a worksheet object. This worksheet contains actual data.


    >>  How to do data driven test in testNG:
            in testng we have @dataprovider tags to do data driven test. Using @dataprovider we can repeat the same test multiple times.




    @dataProvider ->> decides how many times will test run ( all depends on how much data is stored in the data provider)





 */
public class notes {
}
