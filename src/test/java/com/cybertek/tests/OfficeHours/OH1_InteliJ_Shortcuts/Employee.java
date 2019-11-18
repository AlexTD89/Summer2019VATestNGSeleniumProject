package com.cybertek.tests.OfficeHours.OH1_InteliJ_Shortcuts;
public class Employee {


    String Name;
    String ID;
    int age;
    int SSN;
    String JobTitile;
    double salary;

    public Employee(String Name, String ID, int age, int SSN, String JobTitile, double salary ) {
        this.Name = Name;
        this.ID = ID;
        this.age = age;
        this.SSN = SSN;
        this.JobTitile = JobTitile;
        this.salary = salary;
    }


    public void getInfo() {
        System.out.println("Employee' name is: "+Name);
        System.out.println("Social Security number is: "+SSN);
        System.out.println("Age is: "+age);
        System.out.println("Job title is: "+JobTitile);
        System.out.println("Employee ID is: "+ID);
        System.out.println("Salary is: $"+salary);

        System.out.println("-------------------------------------------");
    }




}