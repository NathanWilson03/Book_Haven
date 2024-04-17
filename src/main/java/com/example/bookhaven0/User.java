package com.example.bookhaven0;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private List<String> bookCollection = new ArrayList<>();



    public User(String name, String key) {
        userName = name;
        password = key;


    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "username= " + userName + ", password= " + password ;
    }


}
