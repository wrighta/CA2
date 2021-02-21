package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Hmmmm - should we able to instantiate the SoftwareStaff?? It's not Programme, its not an hourlyWorker, it's just a generic Staff object.
        // SoftwareStaff s1 = new SoftwareStaff(99, "Joe Soap", "joe@soap.ie", "555 9999");

        // softwareStaffList is a list of SoftwareStaff object (it can be a mix of programmers and hourlyworker)
        List<SoftwareStaff> softwareStaffList = new ArrayList();

        Programmer p1 = new Programmer(1, "Joe", "joe@iadt.ie", "087 7777777", "C++ Java", 700000);
        Programmer p2 = new Programmer(2, "Jim", "jim@iadt.ie", "087 6666666", "Kotlin", 800000);
        Programmer p3 = new Programmer(3, "Jane", "jane@iadt.ie", "087 5555555", "Python", 900000);
        Programmer p4 = new Programmer(4, "June", "june@iadt.ie", "087 4444444", "Web Dev", 1000000);

        HourlyWorker h1 = new HourlyWorker(99, "Sam", "sam@iadt.ie", "086 6666666", 50.00);
        HourlyWorker h2 = new HourlyWorker(98, "Sarah", "sarah@iadt.ie", "086 7777777", 40.00);
        HourlyWorker h3 = new HourlyWorker(97, "Sonny", "sonny@iadt.ie", "086 8888888", 30.00);
        HourlyWorker h4 = new HourlyWorker(96, "Seth", "seth@iadt.ie", "086 9999999", 20.00);

        // add Programmer and HourlyWorker object to the managers list of staff
        softwareStaffList.add(p1);
        softwareStaffList.add(p2);
        softwareStaffList.add(h1);
        softwareStaffList.add(h2);

        Manager m1 = new Manager(101, "Mister Bloggs", 123);
        m1.setSoftwareStaffList(softwareStaffList);

        m1.addStafftoManager(p3);
        m1.addStafftoManager(h3);

        System.out.println("********MANAGER DETAILS************");
        System.out.println(m1.toString());



//        // call the get methods and print.
//        System.out.println("\n\n***** Printing each instance variable by calling it's get method *********");
//        // note, you can call the superclass get method even though p1 is a Programmer
//        System.out.println("ID is " + p1.getId());
//        System.out.println("Name is " + p1.getName());
//        // Call the Programmer get methods
//        System.out.println("Skills are " + p1.getSkills());
//
//        System.out.println("Pay per month is " + p1.calcPay());
//
//        // how would I print Salary and email...
//
//        // An easier way - get the string from toString() - print thestring that is returned from Programmer toString()
//        System.out.println("\n***** Printing with toString() *********");
//        System.out.println(p1.toString());
//
//        HourlyWorker h1 = new HourlyWorker(99, "Sam", "sam@iadt.ie", "086 6666666", 50.00);
//        // call the get methods and print.
//        System.out.println("\n\n***** Printing each instance variable by calling it's get method *********");
//        // note, you can call the superclass get method even though h1 is a sub class
//        System.out.println("ID is " + h1.getId());
//        System.out.println("Name is " + h1.getName());
//        // Call the Programmer get methods
//        System.out.println("Hourly are " + h1.getHourlyRate());
//
//        System.out.println("Pay per week is " + h1.calcPay());
//
//        // An easier way - get the string from toString() - print thestring that is returned from Programmer toString()
//        System.out.println("\n***** Printing with toString() *********");
//        System.out.println(h1.toString());

    }
}
