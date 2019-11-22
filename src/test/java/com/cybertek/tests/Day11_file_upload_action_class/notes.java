package com.cybertek.tests.Day11_file_upload_action_class;

/*
    File download
    File uploading
    Actions class

    _______________

    File download   -->> Selenium doesn't do file download, in using seleniu m we cannot verify the contents of the downloaded files. We can  can go to some websites, click on links
                        to download files using selenium. But we cannot verify the content. Using java+other libraries we can verify if the file exists, and we can verify the contents

    File upload -->> to upload file we normally have 2 steps:
        1. click on the button which opens file explorer using which we choose some file
        2. click another button which completes the uploading

     To upload file with selenium we have 2 steps:
        1. We provide  path to file which we want to upload to the browser button using sendKeys()
        2. click another button which completes the uploading

    ****>> to find path of the file on mac: right click on file -->> hold option key -->> click on copy file as path name
        *** windows: hold shift -->> right click on file -->> copy as path
                    right click -->> properties -->> copy the path

    InvalidArgumentException: invalid argument: File not found      -->> When we provide wrong name/path of the file it will through this exception



    What if I cannot upload file with selenium?
    New use Robot class, AutoIT, Sikuli, These tools are used to automate the desktop apps




    Actions class
    Actions class is used to do advanced user interactions like mouse hover, double click, drag, drop, scroll up/down etc
    Actions class is a class comes from selenium and is created by passing the web driver object as constructor


    actions.moveToElement();    -->> move the mouse to certain place on the webpage
    perform()   -->> complete the action, needs to be present for the action to take place
    **to find an information about any methods  -->> command (key) click on the method
    clickAndHold()    -->> clicks on element and hold it
    release() -->>    release the element after holding it
    build()   -->> when having multiple actions together we call build() to have them work together. is used to chain the actions



    JavaScriptExecutor  -->> used to send js commands to browser using selenium
    jse.executeScript("arguments[0].click();", element);    -->>    when normal actions for clicking on the webElement didn't work we use JS commands


        with JS we can scroll up/down the web page
        jse.executeScript("scroll(0, 250);");       -->> a js command, (after creating JS object)



 */

public class notes {
}
