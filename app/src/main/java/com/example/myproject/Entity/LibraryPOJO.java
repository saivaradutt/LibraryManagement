package com.example.myproject.Entity;

public class LibraryPOJO {

    public int id;
    public String title;
    public String description;
    public String author;
    public double price;
    //public String imagePath;


    public LibraryPOJO(int id, String title, String str_des, String auth, double price1) {

        this.id = id;
        this.title = title;
        this.description = str_des;
        this.author = auth;
        this.price = price1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
