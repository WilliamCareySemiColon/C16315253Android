package com.example.williamcarey.c16315253application;

import android.content.Context;

public class Person {
    private String name,address,username,email, password;

    //allow connection to the database
    private MusicProductDB BEDB;
    //variable to capture the context of the varaible
    Context Databaseapplication;

    //insertion of data into the database
    long newPerson;

    //register constructor
    public Person(String name, String address1, String address2,String address3,
                  String email,String username, String password, Context passed)
    {
        //setting the fields to have data
        this.name = name;
        this.address = address1 + " " + address2 + " " + address3;
        this.username = username;
        this.email = email;
        this.password = password;
        this.Databaseapplication = passed;

        BEDB = new MusicProductDB(this.Databaseapplication);
        BEDB.open();

        newPerson = BEDB.insertPerson(this.username,this.password,this.name,
                this.address,this.email);
    }//end register constructor

   /* public BackEndDatabase retDB() {
        return BEDB;
    }*/
}//end person class
