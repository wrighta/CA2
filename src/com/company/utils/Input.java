package com.company.utils;

import java.util.Scanner;
import com.company.Programmer;

/**
 *
 * @author wrighta
 */
public class Input {


    // Called to read in a new programmer when Create Programmer is chosen by user
    public static Programmer readProgrammer() {
        String name, email, mobile, skills;
        int staffNumber, mId;
        double salary;
        Scanner keyboard = new Scanner(System.in);


        // ask the user for all the programmer data except the ID - ID is automatically
        // created in the database when you are creating something for the first time
        System.out.print("Enter name : ");
        name = keyboard.nextLine();

        System.out.print("Enter email : ");
        email = keyboard.nextLine();

        System.out.print("Enter mobile : ");
        mobile = keyboard.nextLine();

        System.out.print("Enter staff number : ");
        staffNumber = keyboard.nextInt();
        keyboard.nextLine();

        System.out.print("Enter skills : ");
        skills = keyboard.nextLine();

        System.out.print("Enter Salary : ");
        salary = keyboard.nextDouble();
        keyboard.nextLine();

        // Asking for the manager ID - this needs to exist in the Manager table otherwise it will crash
        // I don't check here, I'll leave this for you to figure out!
        System.out.print("Enter Manger ID : ");
        mId = keyboard.nextInt();
        keyboard.nextLine();

        // Create the Programmer object p
//        Programmer p =
//                new Programmer(name, email, mobile,
//                        skills, salary, mId);

        // Create the Programmer object p
        Programmer p =
                new Programmer(name, email, mobile,
                        skills, salary);

        return p;
    }
}

