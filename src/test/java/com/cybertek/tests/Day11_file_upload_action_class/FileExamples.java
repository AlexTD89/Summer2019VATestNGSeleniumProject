package com.cybertek.tests.Day11_file_upload_action_class;

import org.testng.annotations.Test;

public class FileExamples {

    @Test
    public void tes1(){
        System.out.println(System.getProperty("user.dir"));
        // prints the path location of this project: /Users/alex/IdeaProjects/Summer2019VATestNGSeleniumProject
        System.out.println(System.getProperty("os.name"));
        //prints name of the operating system:  Mac OS X
        System.out.println(System.getProperty("user.home"));
        //prints the path to user home folder:  /Users/alex

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/test_file.txt";   // right click on the file, here in inteliJ, copy relative path
        String fullPath = projectPath+relativePath;
        System.out.println(fullPath);   // /Users/alex/IdeaProjects/Summer2019VATestNGSeleniumProjectsrc/test/resources/test_file.txt
    }
}
