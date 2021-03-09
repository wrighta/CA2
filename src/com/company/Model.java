package com.company;

import com.company.database.DBConnection;
import com.company.database.ManagerTableGateway;
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
    private ManagerTableGateway mGateway;


    private Model() {

        try {
            Connection conn = DBConnection.getInstance();
            this.sGateway = new SoftwareStaffTableGateway(conn);
            this.mGateway = new ManagerTableGateway(conn);

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

    // gets a manager using an ID from the database then gets all that managers softwarestaff from the DB
    public Manager viewManager(int id){
        Manager m = mGateway.getManager(id);
        m.setSoftwareStaffList(this.sGateway.getSoftwareStaffByManagerId(id));
        return m;
    }

    public boolean createManager(Manager m){
        return (mGateway.insertManager(m));
    }
}


