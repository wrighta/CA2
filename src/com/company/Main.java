package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Programmer p1 = new Programmer(1, "Joe", "joe@iadt.ie", "087 7777777", "C++ Java", 700000);
        // call the get methods and print.
        System.out.println("\n\n***** Printing each instance variable by calling it's get method *********");
        // note, you can call the superclass get method even though p1 is a Programmer
        System.out.println("ID is " + p1.getId());
        System.out.println("Name is " + p1.getName());
        // Call the Programmer get methods
        System.out.println("Skills are " + p1.getSkills());

        // how would I print Salary and email...

        // An easier way - get the string from toString() - print thestring that is returned from Programmer toString()
        System.out.println("\n***** Printing with toString() *********");
        System.out.println(p1.toString());

        HourlyWorker h1 = new HourlyWorker(99, "Sam", "sam@iadt.ie", "086 6666666", 50.00);
        // call the get methods and print.
        System.out.println("\n\n***** Printing each instance variable by calling it's get method *********");
        // note, you can call the superclass get method even though h1 is a sub class
        System.out.println("ID is " + h1.getId());
        System.out.println("Name is " + h1.getName());
        // Call the Programmer get methods
        System.out.println("Hourly are " + h1.getHourlyRate());


        // An easier way - get the string from toString() - print thestring that is returned from Programmer toString()
        System.out.println("\n***** Printing with toString() *********");
        System.out.println(h1.toString());

    }
}
