package com.example.bookhaven0;

public class Admin {


    private String adminName = "HavenBoss";
    private int adminCode = 11111;

    Admin(){

    }

    Admin(String name, int code){
        this.adminName = name;
        this.adminCode = code;
    }


    public int getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(int adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    @Override
    public String toString(){

        return adminName + ", " + adminCode;

    }



}
