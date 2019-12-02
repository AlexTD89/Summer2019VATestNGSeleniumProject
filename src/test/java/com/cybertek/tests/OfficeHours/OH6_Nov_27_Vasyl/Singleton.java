package com.cybertek.tests.OfficeHours.OH6_Nov_27_Vasyl;

/*
singleton pattern
whenever you call this method, you’re working with the same WebDriver obj
for a single click we call three diff explicit waits
so we could just combine these codes and put it inside a method and call it again and again
we do not need to duplicate this
we need to have these reusable methods under one class and we will put it in the utility class
those methods should use the same driver for a test
utility is opening another browser and test opens a diff browser
but a singleton helps the framework to use the same driver
it ENSURES everyone is using the same browser after calling some utility from a diff class
every class has its own driver
later, we will need to create a report - we will have to combine test execution results into one single report
singleton is not the best design pattern at all
later on we will use ‘parallel execution’
singleton means we use same browser - same static - shareable
difficult concept
as of now - simplest design/approach - approach
we use static driver in singleton design
give to every test class, utility , access to same driver obj
driver get and you will get same driver obj
requirements are very simple
use an instance and make it private static - why? b/c getter
cons must be private b/c we should not create more Driver class instances - b/c you will create driver instance - you will work with some kind of instance method
no need to create obj of this class
private prevents class instantiation
return type should match - should be covariant
1418 we have some kind of if statement here
it means when driver is created driver == null
that line means var is not attached to a specific obj
it’s empty
when driver is null, we do not get an obj
What are you trying to call? there is no obj
we have to make sure it is not created yet - that’s why we use ‘if’
if the driver obj is created, then we will open the browser
if another browser is open…
switch statement can be if statement too
config file is very important- it’s a cool and convenient solution for your framework
all these things will scale your future framework
if maintenance of your framework takes a lot of time, that means there is a problem with the design
specify browser type only
diff driver everywhere
how are we going to switch a browser type at once?
what’s another solution?
instead of this chrome, we can read from ConfigReader - still , right? we are dealing with diff drivers = [opens driver from d4 and d5]
we cannot create Test Suite
with TestNG it’s ok we can do something like this
it’s not convenient at all to create a separate driver
it doesn’t matter where it’s located, you will be calling the same driver everytime
student: can we look at ConfigReader?
Vasya: java has its own properties

Singleton - it's a design pattern
        The idea is to have only one object.



 */
public class Singleton {
}
