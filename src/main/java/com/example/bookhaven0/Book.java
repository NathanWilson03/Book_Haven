package com.example.bookhaven0;

public class Book {

    private String author;
    private int code;
    private int age;


    Book(){

    }

    Book(String writer, int bookID, int years ){
        this.author = writer;
        this.code = bookID;
        this.age = years;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
