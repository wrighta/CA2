package com.company;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    // instance variables
    private int managerId;
    private String name;
    private int officeNumber;

    private List<SoftwareStaff> softwareStaffList;


    public Manager(int id, String name, int officeNumber){
        this.managerId = id;
        this.name = name;
        this.officeNumber = officeNumber;

        // staff is an empty list of Staff to start with.
        softwareStaffList = new ArrayList();
    }

    // add a new SoftwareStaff member to the managers list of staff
    // remember we cannot instantiate Staff objects as the class is abstract.
    // Instead Programmer or HourlyWorker objects are passed in here.
    public void addStafftoManager(SoftwareStaff s){
        softwareStaffList.add(s);
    }

    // remove a SoftwareStaff member from the mangers list of staff
    public void removeStaff(SoftwareStaff s){
        softwareStaffList.remove(s);
    }


    public int getManagerId() {
        return managerId;
    }


    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getOfficeNumber() {
        return officeNumber;
    }


    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }


    public List <SoftwareStaff> getSoftwareStaffList() {
        return softwareStaffList;
    }


    public void setSoftwareStaffList(List <SoftwareStaff> softwareStaffList) {
        this.softwareStaffList = softwareStaffList;
    }

    @Override
    public String toString() {
        return "Manager Details " +
                "manager Id : " + managerId +
                ", name : '" + name + '\'' +
                ", officeNumber : " + officeNumber +
                "\n LIST OF MANAGERS STAFF "
                 + softwareStaffList +
                '}';
    }
}
