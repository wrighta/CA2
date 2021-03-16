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

            System.out.println("1. Create a SoftwareStaff");
            System.out.println("2. Read all SoftwareStaff");
            System.out.println("3. Update a SoftwareStaff");
            System.out.println("4. Delete a SoftwareStaff");

            System.out.println("5. View Manager by Id");
            System.out.println("6. View all Managers");
            System.out.println("7. Create New Manager ...");
            System.out.println("8. Assign SoftwareStaff to existing Manager...");


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
                    createSoftwareStaff();
                    break;
                }

                case 2: {
                    viewSoftwareStaff();
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    break;
                }

                case 5: {
                    viewManagerbyId();
                    break;
                }
                case 6: {
//                    viewAllManagers();
//                    break;
                }
                case 7: {
                    createNewManager();
                    break;
                }

                case 8: {
                    System.out.println("Not implemented yet, lots of ways to do this...consider if the User can Create new SoftwareStaff and Assign them to to the manager or Assign existing Software Staff");
                    break;
                }

            }
        }
        while (opt != 9);
        System.out.println("Goodbye");
    } // END OF MAIN()

    // Creates either a Programmer or HourlyWorker
    private static void createSoftwareStaff() {
        SoftwareStaff softwareStaff = null;
        
        System.out.println("\nWhat do you want to create??");
        System.out.println("1. Programmer");
        System.out.println("2. Hourly Worker");

        int choice = Integer.parseInt(keyboard.nextLine());
       
        switch (choice){
            case 1:
            {
                softwareStaff = Input.readProgrammer();
                int generatedId = model.createSoftwareStaff(softwareStaff);
                System.out.println("Software staff created with Id "+ generatedId);
                break;
            }
            case 2: 
            {
                // do something similar for second subclass
                break;
            }
            

        }
        model.createSoftwareStaff(softwareStaff);
                

       

    }

    private static void createNewManager() {
        Manager m = Input.readManager();

        if (model.createManager(m))
            System.out.println("Success : manager Added to DB");
        else
            System.out.println("Oh Ohh Something went wrong");

    }

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
