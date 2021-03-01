package com.company;

import com.company.utils.Input;
import com.mysql.cj.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Model model;
    static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
     //   keyboard = new Scanner(System.in);
        model = Model.getInstance();
        int opt;




        /*************************************************
         ************* DISPLAY MENU **********************
         ***********************************************/
        do {
            System.out.println("\n***********MENU************");

            System.out.println("1. View all SoftwareStaff");
            System.out.println("2. View Manager by Id");
            System.out.println("3. Create New Manager ...");
            System.out.println("4. Assign SoftwareStaff to existing Manager...");


            System.out.println("9. Exit");
            System.out.println("**************************");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);


            /***********************************************
             ****** DECIDE WHAT OPTION USER CHOSE***********
             ***********************************************/
            switch (opt) {
                case 1: {
                    viewSoftwareStaff();
                    break;
                }
                case 2: {
                    viewManagerbyId();
                }
                case 3: {
                    System.out.println("Not implemented yet, First implement a simple Create New Manager, consider assigning new or existing SoftwareStaff to that Manager..you may need to get the manager ID from the gateway.. ");
                }

                case 4: {
                    System.out.println("Not implemented yet, lots of ways to do this...consider if the User can Create new SoftwareStaff and Assign them to to the manager or Assign existing Software Staff");
                }

            }
        }
        while (opt != 9);
        System.out.println("Goodbye");
    } // END OF MAIN()

    private static void viewManagerbyId() {
        System.out.println("Enter the id for the manager...");
        int id = keyboard.nextInt();
        Manager m = null;
        //consume the new line that will come after typing in the ID integer
        keyboard.nextLine();

       System.out.println("Do you also want to view the staff for that Manager? y/n");
       if (keyboard.nextLine().equalsIgnoreCase("y"))
            m = model.viewManager(id);
       else
           System.out.println("Can you write the code that just gets manager with ID but no staff");

       // at the moment if you choose n above this print statement will try print a null pointer = manager m is null, therefore crash the program.
       System.out.println("************PRINTING MANAGER DETAILS **************\n\n" + m.toString());

    }


    private static void viewSoftwareStaff() {
        List<SoftwareStaff> softwareStaffList = model.viewSoftwareStaff();
        for (SoftwareStaff softwareStaff : softwareStaffList) {
            System.out.println("Name: " + softwareStaff.toString());
        }
    }
}
