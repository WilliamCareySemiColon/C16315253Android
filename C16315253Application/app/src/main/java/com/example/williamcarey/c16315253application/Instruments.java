package com.example.williamcarey.c16315253application;

import android.content.Context;

public class Instruments extends Product {

    private String family, sourcedFrom, countryOrigin;

    //getters and setters for the family of the instrument
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    //getters and setters for sourcedFrom
    public String getSourcedFrom() {
        return sourcedFrom;
    }

    public void setSourcedFrom(String sourcedFrom) {
        this.sourcedFrom = sourcedFrom;
    }

    //getters and setters for the counrtyOrigin
    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    //constructor
    public Instruments(String name, String brand, String keyword,
                       String type, String dateReleased, String desc,
                       String generalReview, float price,
                       Context context, String family,
                       String sourcedFrom, String countryOrigin)
    {
        super(name, brand, keyword, type, dateReleased, desc,
                generalReview, price, context);

        this.family = family;
        this.countryOrigin = countryOrigin;
        this.sourcedFrom = sourcedFrom;
    }
}
