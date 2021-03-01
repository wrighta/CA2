package com.company.database;

import com.company.Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
