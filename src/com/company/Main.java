package com.company;

import com.company.utils.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Model model;
    static Scanner keyboard;


    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        model = Model.getInstance();
        int opt;

        /*************************************************
         ************* DISPLAY MENU **********************
         ***********************************************/
        do {
            System.out.println("\n***********MENU************");

            System.out.println("1. View all SoftwareStaff");


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

            }
        }
        while (opt != 9);
        System.out.println("Goodbye");
    } // END OF MAIN()


    private static void viewSoftwareStaff() {
        List<SoftwareStaff> softwareStaffList = model.viewSoftwareStaff();
        for (SoftwareStaff softwareStaff : softwareStaffList) {
            System.out.println("Name: " + softwareStaff.toString());
        }
    }
}
