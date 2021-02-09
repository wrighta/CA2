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
        return super.toString() + "\nSkills " + skills ; //+ "\nSalary " +  salary;
    }


}
