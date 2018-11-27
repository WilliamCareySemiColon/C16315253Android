package com.example.williamcarey.c16315253application;

import android.content.Context;

public class Product {
    //fields name for the products
    private String name,brand, keyword, type,
            dateReleased, desc, generalReview;
    private float price;
    private int id;
    //allowing the capability for purchasing the item
    private boolean isBought;

    //allow connection to the database
    private MusicProductDB BEDB;
    //variable to capture the context of the varaible
    Context Databaseapplication;

    //autogenerate the id through the class itself
    private static int idgenerate = 1;

    //getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getters and setters for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //getters and setters for keyword
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    //getters and setters for the type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //getters and setters for the dateReleased
    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    //getters and setters for the description
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //getters and setters for the review
    public String getGeneralReview() {
        return generalReview;
    }

    public void setGeneralReview(String generalReview) {
        this.generalReview = generalReview;
    }

    //getters and setters for the price of the object
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //getters and setters for the id of the object we are dealing with
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //getters and setters for the items that are bought
    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Product(String name, String brand, String keyword,
                   String type, String dateReleased, String desc,
                   String generalReview, float price, Context context)
    {
        //settings all the parameters of the product to the fields passed in
        this.name = name;
        this.brand = brand;
        this.keyword = keyword;
        this.type = type;
        this.dateReleased = dateReleased;
        this.desc = desc;
        this.generalReview = generalReview;
        this.price = price;
        this.id = idgenerate;
        idgenerate++;
        this.isBought = false;

        //getting the context
        Databaseapplication = context;

        BEDB = new MusicProductDB(Databaseapplication);
        BEDB.open();
    }

    //return a way to get access at the contents of the database
    /*public Cursor getAllProducts()
    {

    }*/

    //planned methods - may not be implemented in this version

    //public boolean doesItemExist();

    //public void updateDatabase();

    //public Product getUpdatedInfo(int id);
}//end person class
