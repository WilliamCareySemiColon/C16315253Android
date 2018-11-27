package com.example.williamcarey.c16315253application;

import android.content.Context;

public class CDRecord extends Product {

    private String genre;

    //getters and setters for the application
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //constructor
    public CDRecord(String name, String brand, String keyword,
                    String type, String dateReleased, String desc,
                    String generalReview, float price,
                    Context context, String genre)
    {
        super(name, brand, keyword, type, dateReleased, desc,
                generalReview, price, context);
        this.genre = genre;
    }
}
