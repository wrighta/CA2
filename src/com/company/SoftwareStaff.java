package com.company;

// SoftwareStaff class - superclass that has common information for all Staff
public  class SoftwareStaff  {

    private int id;
    private String name;
    private String email;
    private String mobile;


    public SoftwareStaff(int id, String n, String e, String m) {
        this.id = id;
        this.name = n;
        this.email = e;
        this.mobile = m;

    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    // now you know the toString() method overrides the toString() method in the Super-Super class Object
    // This method always returns a String, it's up to you to return a string that represents the object
    public String toString()
    {
        return "Name : " + getName();
    }


}
