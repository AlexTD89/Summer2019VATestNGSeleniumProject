package com.cybertek.tests.Day13_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExamplesTest {
    private static WebDriver driver;
//    WebDriver driver;
    @BeforeMethod
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
    }

//    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement myTable = driver.findElement(By.id("table1"));
        System.out.println(myTable.getText());

        //verify that jsmith@gmail.com is present in table
        Assert.assertTrue(myTable.getText().contains("jsmith@gmail.com")); // pass
    }

    @Test
    public void getAllHeaders(){
        //get all columns names individually
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());   // headers.size() = 6
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        //get all column names in a single webelement
        WebElement headers2 = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println(headers2.getText());


    }

    @Test
    public void printTableSize(){
        // Number of Columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("number of columns = " + headers.size());

        //Number of row with headers
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("number of rows = " + rows.size());

        //Number of rows excluding headers
        List<WebElement> rowsNoheaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("number of rows excluding headers = " + rowsNoheaders.size());
        /*
                number of columns = 6
                number of rows = 5
                number of rows excluding headers = 4

         */
    }

    @Test
    public void getRow(){
        //get any from the table using index, we will ignore the headers. 1st row is the 1st row in the body
        WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println(row.getText());
        row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row.getText());
        row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        System.out.println(row.getText());

        /*
                Smith John jsmith@gmail.com $50.00 http://www.jsmith.com edit delete
                Bach Frank fbach@yahoo.com $51.00 http://www.frank.com edit delete
                Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete
         */

        /*
            get all the table row dynamically. we can do it in 2 steps
                1. get the number of rows
                2. based on the number of rows iterate each one
        */
        List<WebElement> rowsNoheaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= rowsNoheaders.size(); i++) {
             String xpath = "//table[@id='table1']/tbody/tr["+i+"]";
            System.out.println(xpath);
            WebElement singleRow = driver.findElement(By.xpath(xpath));
            System.out.println(singleRow.getText());

        }
        /*
                    //table[@id='table1']/tbody/tr[1]
                    Smith John jsmith@gmail.com $50.00 http://www.jsmith.com edit delete
                    //table[@id='table1']/tbody/tr[2]
                    Bach Frank fbach@yahoo.com $51.00 http://www.frank.com edit delete
                    //table[@id='table1']/tbody/tr[3]
                    Doe Jason jdoe@hotmail.com $100.00 http://www.jdoe.com edit delete
                    //table[@id='table1']/tbody/tr[4]
                    Conway Tim tconway@earthlink.net $50.00 http://www.timconway.com edit delete
         */

    }


    @Test
    public void getAllCellsInRow(){
        List<WebElement> allCellsInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement cell : allCellsInRow) {
            System.out.println(cell.getText());

        }
        System.out.println("allCellsInRow.size() = " + allCellsInRow.size());   // allCellsInRow.size() = 6
        /*
                Smith
                John
                jsmith@gmail.com
                $50.00
                http://www.jsmith.com
                edit delete
         */
    }

    @Test
    public void getSingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(singleCell.getText());
        singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[3]"));
        System.out.println(singleCell.getText());
        /*
                Smith
                jsmith@gmail.com
         */
    }

    @Test
    public void printAllCellByIndex(){
        //get numbers of rows
        int rowNumber = getNumberOfRows();
        //get number of columns
        int colNumber = getNumberOfCols();

        System.out.println("rowNumber = " + rowNumber);
        System.out.println("colNumber = " + colNumber);

        /*
                    rowNumber = 4
                    colNumber = 6
         */
                    // Building a stream
        //iterates each row of the table
        for (int i = 1; i <= rowNumber; i++) {
            //iterator each cell in the row
            for (int j = 1 ; j <= colNumber; j++) {
                //i ->> index of the (row)
                // j -->> index of the rd (cell)
                String xpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement cell = driver.findElement(By.xpath(xpath));
                System.out.println(cell.getText());


            }
        }

        //this method works for only balanced tables (when rows matches the size of table), doesn't for unbalanced

    }

    private static int getNumberOfCols() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    /*
        returns number of row in the body of the table. skips the table header
     */
    private static int getNumberOfRows() {
        List<WebElement> allRowsExcludingHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsExcludingHeaders.size();
    }

    @Test
    public void getSpecificCell(){
        // get cell by given index
        int r = 1;
        int c = 2;

        String xpath = "//table[@id='table1']/tbody/tr["+r+"]/td["+c+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        System.out.println(cell.getText()); // John


    }

    @Test
    public void detCellInRelationToAnotherCellInSameRow(){
        /*
        Find the cell of The Jason's email
            find cell with Jason name
            after it , find cell with the email:

        Find cell in a table in relation ti other cell (cell 1) in same row:
            1. Find cell 1  : //table[@id='table1']//td[.='Jason']
            2. Find the row where cell 1 is: //table[@id='table1']//td[.='Jason']/..
                /.. in xpath means go to the parent of the element
            3. FInd cell 2 from that row, that contains email
                //table[@id='table1']//td[.='Jason']/../td[3]
                /td[3] ->> go to certain cell of the table

         */

        //get email of Jason
        String name = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+name+"']/../td[3]";
        System.out.println(driver.findElement(By.xpath(xpath)).getText()); // jdoe@hotmail.com


    }

}
