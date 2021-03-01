package com.company.database;

import com.company.HourlyWorker;
import com.company.Programmer;
import com.company.SoftwareStaff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SoftwareStaffTableGateway {
    // Define all fields in the staff table
    private static final String TABLE_NAME = "softwarestaff";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_STAFF_NUMBER = "staffNum";
    private static final String COLUMN_MANAGER_ID = "managerId";
    // "type" is a field in the Staff table that indicates if its a programmer or hourlyworker, this is not needed in the Java classes, only in the database
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_SKILLS = "skills";
    private static final String COLUMN_SALARY = "salary";
    private static final String COLUMN_HOURLY_RATE = "hourlyRate";


    private Connection mConnection;

    public SoftwareStaffTableGateway(Connection connection) {
        mConnection = connection;
    }

    public List<SoftwareStaff> getSoftwareStaff()  {
        String query;                   // the SQL query to execute
        Statement stmt;                 // the java.sql.Statement object used to execute the SQL query
        ResultSet rs;                   // the java.sql.ResultSet representing the result of SQL query
        List<SoftwareStaff> softwareStaffList;   // the java.util.List containing the Programmer objects created for each row

        String name, email, mobile, skills;
        int id, managerId;
        double salary, hourlyRate;

        SoftwareStaff softwareStaff;


        query = "SELECT * FROM " + TABLE_NAME ;

        softwareStaffList = new ArrayList<SoftwareStaff>();

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);

            // iterate through the result set, extracting the data from each row then creating either a Programmer or HourlyWorker and putting it into array List
            while (rs.next()) {

                id = rs.getInt(COLUMN_ID);
                name = rs.getString(COLUMN_NAME);
                email = rs.getString(COLUMN_EMAIL);
                mobile = rs.getString(COLUMN_MOBILE);
                managerId = rs.getInt(COLUMN_MANAGER_ID);

                if (rs.getString(COLUMN_TYPE).equals("programmer"))
                {
                    skills = rs.getString(COLUMN_SKILLS);
                    salary = rs.getDouble(COLUMN_SALARY);
                    softwareStaffList.add(new Programmer(id, name, email, mobile,skills,salary, managerId));
                }
                else
                {
                    hourlyRate = rs.getDouble(COLUMN_HOURLY_RATE);
                    softwareStaffList.add(new HourlyWorker(id, name, email, mobile, hourlyRate, managerId));
                }

            }
        }
        catch(SQLException ex){
            System.out.println("SoftwareStaffTableGateway Line 56: " + ex);
        }

        // return the list of Programmer objects retrieved
        return softwareStaffList;
    }

    public List<SoftwareStaff> getSoftwareStaffByManagerId(int mid)  {
        String query;                   // the SQL query to execute
        Statement stmt;                 // the java.sql.Statement object used to execute the SQL query
        ResultSet rs;                   // the java.sql.ResultSet representing the result of SQL query
        List<SoftwareStaff> softwareStaffList;   // the java.util.List will contain the softwareStaff objects for the manager

        String name, email, mobile, skills;
        int id;
        double salary, hourlyRate;



        query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_MANAGER_ID + " = " + mid;
        // for debugging purposes only, don't keep it in the code once this works.
        System.out.println("SQL QUERY IS : " + query);


        softwareStaffList = new ArrayList<SoftwareStaff>();

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);

            // iterate through the result set, extracting the data from each row then creating either a Programmer or HourlyWorker and putting it into array List
            while (rs.next()) {

                id = rs.getInt(COLUMN_ID);
                name = rs.getString(COLUMN_NAME);
                email = rs.getString(COLUMN_EMAIL);
                mobile = rs.getString(COLUMN_MOBILE);
                mid = rs.getInt(COLUMN_MANAGER_ID);

                if (rs.getString(COLUMN_TYPE).equals("programmer"))
                {
                    skills = rs.getString(COLUMN_SKILLS);
                    salary = rs.getDouble(COLUMN_SALARY);
                    softwareStaffList.add(new Programmer(id, name, email, mobile,skills,salary, mid));
                }
                else
                {
                    hourlyRate = rs.getDouble(COLUMN_HOURLY_RATE);
                    softwareStaffList.add(new HourlyWorker(id, name, email, mobile, hourlyRate, mid));
                }

            }
        }
        catch(SQLException ex){
            System.out.println("SoftwareStaffTableGateway Line 56: " + ex);
        }

        // return the list of Programmer objects retrieved
        return softwareStaffList;
    }

}
