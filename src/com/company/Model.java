package com.company;

import com.company.database.DBConnection;
import com.company.database.SoftwareStaffTableGateway;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Model {

    private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }


    private List<SoftwareStaff> softwareStaffList;
    private SoftwareStaffTableGateway sGateway;


    private Model() {

        try {
            Connection conn = DBConnection.getInstance();
            this.sGateway = new SoftwareStaffTableGateway(conn);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public List viewSoftwareStaff() {
        this.softwareStaffList = this.sGateway.getSoftwareStaff();

        return softwareStaffList;
    }

}


