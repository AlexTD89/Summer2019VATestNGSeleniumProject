package com.cybertek.tests.OfficeHours.OH7_Collections;

import java.util.*;

public class collections_OH {


    public static void main(String[] args) {

        // polymorphism ->> object type is child, reference type is parent class/interface
        List<String> cars = new ArrayList<>();
        //created object from ArrayList
        ArrayList<String> arrList = new ArrayList<>();

        List<String> languages = new LinkedList<>();

        List<String> books = new Vector<>();

//        List<String> s = new List<>(); // can't create object of abstract class or interface

        cars.add("hello");
        cars.add("truenow");
        cars.add("again");



        for (int i = cars.size()-1; i >= 0; i--) {
            System.out.println("cars.get(i) = " + cars.get(i));

        }


        System.out.println("=====================================");
//        Iterator
        //Set does not accept any duplicates, so it will delete all the duplicates automatically
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(10);
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        //how to iterate through the numbers, since Set does not have indexes we can't use for loop
        // we have to use the Iterator, and nasNext(), next() methods

        Iterator itr = numbers.iterator();

        System.out.println(itr.hasNext()); //true,  will check if the Set has any value
        System.out.println(itr.next()); // 20, prints the next value

        // we use while loop and next() method to iterate through a Set, in set all values are in mixed order
        while(itr.hasNext()){
            System.out.println(itr.next());
        }





    }
}
