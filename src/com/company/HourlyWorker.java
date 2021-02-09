package com.company;

public class HourlyWorker extends SoftwareStaff{

    private double hourlyRate;

    // we have added the managerId as a parameter, representing the one-many relationhsip with manager.
    // it is passed to the superclass constructor
    public HourlyWorker(int id, String n, String e, String m, double hourlyRate){
        super(id, n, e, m);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcPay() {
        // lets say these guys get paid weekly and they alway do 40 hours a week.
        return hourlyRate * 40;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }


    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}

