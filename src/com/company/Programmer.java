package com.company;


// Programmer "is-a" SoftwareStaff
// So Programmer inherits id, name, email and mobile from SoftwareStaff
public class Programmer extends SoftwareStaff{
    private String skills;
    private double salary;


    public Programmer(String n, String e, String m, String sk, double sl) {
        // Calling the Superclass constructor - SoftwareStaff
        // This constructor expects and ID, name, email, mobile and staffnumber passed in
        // Since we don't have an id yet we pass in -1 (ie. this programmer is not yet created in the database.)
        super(-1, n,e,m);
        this.skills = sk;
        this.salary = sl;
    }

    public Programmer(int id, String n, String e, String m, String sk, double sl) {
        super(id,n,e,m);
        this.skills = sk;
        this.salary = sl;

        // call to superclass constructor must be the first line in sub-class constructor.
        // super(id,n,e,m); don't have you call to the super class after the other assignments

    }

    public Programmer(int id, String n, String e, String m) {
        super(id, n, e, m);
    }



     @Override
    public void printDetailedReport() {
        System.out.println("******DETAILED STAFF REPORT **********");
        System.out.println("Staff ID : " + super.getId());
        System.out.println("Staff Name : " + super.getName());
        System.out.println("Staff Email : " + super.getEmail());
        System.out.println("Staff Mobile : " + super.getMobile());
        System.out.println("Skills : " + skills);
        System.out.println("Salary : " + salary);
        System.out.println("Monthly Pay : " + calcPay());
        System.out.println("**************************************");
    }

    @Override
    public void printSummary() {
        System.out.println("********* SUMMARY ***************");
        System.out.println("Staff ID : " + super.getId());
        System.out.println("Staff Email : " + super.getEmail());
        System.out.println("Monthly Pay : " + calcPay());
        System.out.println("********************************");
    }


    @Override
    public double calcPay() {
        // lets say they get paid monthly. So divide salary by 12
        return salary/12;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        // super.toString() calls the super class SoftwareStaff's toString method()
        // this returns a String for the SoftwareStaff instance variables which is concatenated to these other strings below.
        // then the whole string is returned to the calling program (in our case the test program in main().
        return "\n\nProgrammer " + super.toString() + "\nSkills : " + skills + "\nSalary : " + salary ; //+ "\nSalary " +  salary;
    }


}
