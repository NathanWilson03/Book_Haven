package com.example.bookhaven0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Book {

    private String title;

    private String author;
    private int code;
    private double price;



    Book(){

    }

    Book(String writer, int bookID, String name, double value ){
        this.author = writer;
        this.code = bookID;
        this.title = name;
        this.price = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



public String toString(){
        return title + ", " + code + ", " + author + ", " + price + "\n"; // toString
}

}
