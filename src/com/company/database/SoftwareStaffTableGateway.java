package com.company.database;

import com.company.HourlyWorker;
import com.company.Programmer;
import com.company.SoftwareStaff;

import java.sql.*;
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

    // Here I return the primary key ID of the SoftwareStaff that was created ...see if you can do this in other Creates...
    public int createSoftwareStaff(SoftwareStaff softwareStaff) {

            String query;                   // the SQL query to execute
            PreparedStatement stmt;         // the java.sql.PreparedStatement object used to execute the SQL query
            int numRowsAffected;
            int generatedId;

            // I am going to create a new Programmer object, this object will have the Id after the row is inserted into the database
            //   Programmer dbProgrammer = null;


            // the required SQL INSERT statement with place holders for the values to be inserted into the database
            query = "INSERT INTO " + TABLE_NAME + " (" +
                    COLUMN_NAME + ", " +
                    COLUMN_EMAIL + ", " +
                    COLUMN_MOBILE + ", " +
                    COLUMN_MANAGER_ID + ", "+
                    COLUMN_TYPE + ", " +
                    COLUMN_SKILLS + ", " +
                    COLUMN_SALARY + ", " +
                    COLUMN_HOURLY_RATE +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                // create a PreparedStatement object to execute the query and insert the values into the query
                stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, softwareStaff.getName());
                stmt.setString(2, softwareStaff.getEmail());
                stmt.setString(3, softwareStaff.getMobile());
                stmt.setInt(4, softwareStaff.getManagerId());


                // at compile time softwareStaff is a SoftwareStaff object, not a Programmer or HourlyWorker
                // therefore stmts such as the one commented below will give you errors - uncomment them to see
                //softwareStaff.getSkills();
                // At runtime the object may "take on many forms" i.e. can be a Programmer or an HourlyWorker, This is known as polymorphism.
                // So at runtime we determine the object type for softwareStaff so we can get skills&salary or hourlyRate
                if (softwareStaff.getClass() == Programmer.class) {
                    // note...I created a default constructor in Programmer and the superclass which takes no parameters
                    Programmer p1 = new Programmer();
                    p1 = (Programmer) softwareStaff;
                    stmt.setString(5, "programmer");
                    stmt.setString(6, p1.getSkills());
                    stmt.setDouble(7, p1.getSalary());
                    stmt.setNull(8, 1);
                 //   System.out.println(stmt.toString());

                }
                else if (softwareStaff.getClass() == HourlyWorker.class)
                {
                    HourlyWorker h1 = new HourlyWorker();
                    h1 = (HourlyWorker) softwareStaff;
                    stmt.setString(5, "hourlyworker");
                    stmt.setDouble(8,h1.getHourlyRate());
                }

                //  execute the query and make sure that one and only one row was inserted into the database
                numRowsAffected = stmt.executeUpdate();

                // if numRowsAffected is 1 - that means the SQL insert inserted one row into the table, so the ID should have been auto-incremented and sent back here.
                // so assign this new ID to the ID.
                if (numRowsAffected == 1) {
                    // if one row was inserted, retrieve the id that was assigned to that row in the database and ret
                    ResultSet keys = stmt.getGeneratedKeys();
                    keys.next();
                    generatedId = keys.getInt(1);
                   return generatedId;
                }

            }
            catch (SQLException e)
            {
                // remember to put sensible error logging into your code...
                //System.out.println(e);
            }

            // return the Programmer object created with the new ID, The calling program in the Model should check to ensure it is not null
            return -1;
        }

    }

