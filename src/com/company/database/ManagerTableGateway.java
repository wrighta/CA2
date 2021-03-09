package com.company.database;

import com.company.Manager;

import java.sql.*;
import java.util.logging.Logger;

public class ManagerTableGateway {

    private static final String TABLE_NAME = "manager";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_OFFICE = "office";


    private Connection mConnection;

    public ManagerTableGateway(Connection connection) {
        mConnection = connection;
    }

    // Get Manager by ID
    public Manager getManager(int id)  {
        String query;                   // the SQL query to execute
        Statement stmt;                 // the java.sql.Statement object used to execute the SQL query
        ResultSet rs;                   // the java.sql.ResultSet representing the result of SQL query


        String name;
        int mgrId, office;


        Manager m = null;                   // a Programmer object created from a row in the result of the query


        //query = "SELECT * FROM " + TABLE_NAME;
        // The WHERE clause is important as the table hold both programmers and hourlyworker.
        query = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + id;

        // This print if for debugging purposes only.
        System.out.println(query);

        try {
            stmt = this.mConnection.createStatement();
            rs = stmt.executeQuery(query);

            // if manager id exists it should be returned otherwise we'll assume there is no manager with this id.
             if (rs.next()) {
                id = rs.getInt(COLUMN_ID);
                name = rs.getString(COLUMN_NAME);
                office = rs.getInt(COLUMN_OFFICE);

                m = new Manager(id, name, office);
            }
        }
        catch (SQLException e) {
                System.out.println("Error caught:");
                System.out.println("\n" + e.getMessage());
                System.out.println("\tThrown in file " + e.getStackTrace()[0].getFileName());
                System.out.println("\tThrown on line " + e.getStackTrace()[0].getLineNumber());
        }




        // return the manager (it will be null if the manager did not exist
        return m;
    }

    // Called from the Model when the user wants to create a new programmer in the database, the new ID is created in the database and returned here
    public boolean insertManager(Manager m)  {

        String query;                   // the SQL query to execute
        PreparedStatement stmt;         // the java.sql.PreparedStatement object used to execute the SQL query
        int numRowsAffected;

        // I am going to create a new Programmer object, this object will have the Id after the row is inserted into the database
        //   Programmer dbProgrammer = null;

        // the required SQL INSERT statement with place holders for the values to be inserted into the database
        query = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_NAME + ", " +
                COLUMN_OFFICE +

                ") VALUES (?, ?)";

        try {
            // create a PreparedStatement object to execute the query and insert the values into the query
            stmt = mConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, m.getName());
            stmt.setInt(2, m.getOfficeNumber());


            //  execute the query and make sure that one and only one row was inserted into the database
            numRowsAffected = stmt.executeUpdate();

            // if numRowsAffected is 1 - that means the SQL insert inserted one row into the table, so the ID should have been auto-incremented and sent back here.
            // so assign this new ID to the ID.
            if (numRowsAffected == 1) {
//                    // if one row was inserted, retrieve the id that was assigned to that row in the database and ret
//                    ResultSet keys = stmt.getGeneratedKeys();
//                    keys.next();

//                    try getting the ID that is returned here and send it back to the user
//                    id = keys.getInt(1);

                return true;
            }

        }
        catch (SQLException e)
        {
            System.out.println("Enter a proper error message here");
        }

        // return the Programmer object created with the new ID, The calling program in the Model should check to ensure it is not null
        return false;
    }




}
