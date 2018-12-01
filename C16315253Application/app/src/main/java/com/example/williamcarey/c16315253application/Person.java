package com.example.williamcarey.c16315253application;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class Person {
    //person details inside the database
    private String name,address,username,email, password;

    //allow connection to the database
    private MusicProductDB BEDB;

    private Cursor people;
    //variable to capture the context of the varaible
    Context Databaseapplication;

    //insertion of data into the database
    long newPerson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //register constructor
    public Person(String name, String address1, String address2,String address3,
                  String email,String username, String password, Context passed)
    {
        Log.e("Inside the person", "Person: ");
        //setting the fields to have data
        this.name = name;
        this.address = address1 + " " + address2 + " " + address3;
        this.username = username;
        this.email = email;
        this.password = password;
        this.Databaseapplication = passed;

        Log.e("Creating DB", "Person: ");
        BEDB = new MusicProductDB(this.Databaseapplication);
        BEDB.open();
        Log.e("Inserting the person into db", "Person: ");
        newPerson = BEDB.insertPerson(this.username,this.password,this.name,
                this.address,this.email);
    }//end register constructor

    public Person(String username, Context context)
    {
        this.Databaseapplication = context;
        BEDB = new MusicProductDB(this.Databaseapplication);
        BEDB.open();

        people = BEDB.getPerson(username);
        this.name = people.getString(people.getColumnIndex("name"));
        this.address = people.getString(people.getColumnIndex("address"));
        this.email = people.getString(people.getColumnIndex("email"));
        this.password = people.getString(people.getColumnIndex("password"));
        this.username = people.getString(people.getColumnIndex("username"));
    }

   /* public BackEndDatabase retDB() {
        return BEDB;
    }*/
}//end person class
