package com.example.bookhaven0;

public class Employee {

    private String employeeName;
    private String employeePassword;

    Employee(){

    }

    Employee(String name, String code){
        this.employeeName = name;
        this.employeePassword = code;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePasscode(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    @Override
    public String toString() {
        return employeeName+ ", " + employeePassword + "\n";
    }

}
