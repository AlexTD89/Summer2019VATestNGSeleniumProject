package com.cybertek.tests.Day13_WebTables;


/*

WebTables:
    in html tables are represented with <table> tags

    Tables are (usually) made of <head> and <tbody>.

    <thead> -> this is the table header, here we have the table
    <th> -> this tag indicates a cell that is used for table headers.
    <tbody> -> this is the body of a table, where data is

    <tr> table row, indicate one whole row
    <td> -->> cell in a table body



    //table[@id='table1']/tbody/tr[ 1]
    Find cell (cell 2) in a table in relation to other cell (cell 1) in same row:
    1. Find cell 1
    //table[@id=‘table1']//td[.='Jason']
    Find the table. Then find a cell with certain text in that table.

    2. Find the row where cell 1 is
    //table[@id=‘table1']//td[.='Jason']/..
    /.. —> in xpath it goes to the parent of the element

    3. Find cell 2 from that row
    //table[@id=‘table1']//td[.='Jason']/../td[3]
    /td[3] —> go the the third cell which contains emails





    for the grey window after loading the page vytrack, do overcome it give thread.sleep or wait.until(visibilityOfElement)
            or wait.until(elementISClicable)... because of the grey window you get the exception of ..clickIntercepted exception




 */


public class notes {
}
