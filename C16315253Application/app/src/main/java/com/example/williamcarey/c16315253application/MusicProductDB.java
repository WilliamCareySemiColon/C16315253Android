package com.example.williamcarey.c16315253application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;

public class MusicProductDB {

    //database working with and the version we are working with
    private static final String DATABASE_NAME 	= "MusicProductS";
    private static final int DATABASE_VERSION 	= 1;
    //Person inside the database
    private static final String DATABASE_TABLE_PERSON = "Person";
    // associated  columns
    private static final String KEY_USERNAME 	= "username";
    private static final String KEY_PASSWORD    = "password";
    private static final String KEY_NAME 	    = "name";
    private static final String KEY_ADDRESS 	= "address";
    private static final String KEY_EMAIL	    = "email";
    private static final String KEY_PIC = "profilePic";
    //Music table inside the database
    private static final String DATABASE_TABLE_PRODUCT = "Product";
    //associated columns
    private static final String KEY_BRAND = "brand";
    private static final String KEY_WORD = "keyword";
    private static final String KEY_TYPE = "type";
    private static final String KEY_DATERELEASED = "dateReleased";
    private static final String KEY_PRICE = "price";
    private static final String KEY_ID = "_id";
    private static final String KEY_DESC = "description";
    private static final String KEY_REVIEW = "generalReview";
    //table media takes after Product
    private static final String DATABASE_TABLE_MEDIA = "Media";
    //associated column
    private static final String KEY_LINK = "link";
    //table cdRecord takes after Product
    private static final String DATABASE_TABLE_CDRECORD = "CDRecord";
    //assocaited columns
    private static final String KEY_GENRE = "genre";
    //table instruments takes after Products
    private static final String DATABASE_TABLE_INSTRUMENTS = "Instruments";
    //associated columns
    private static final String KEY_FAMILY = "family";
    private static final String KEY_SOURCEDFROM = "sourcedFrom";
    private static final String KEY_COUNTRYORIGIN = "countryOrigin";
    //desiredProduct details
    private static final String DATABASE_TABLE_DP = "DesiredProduct";
    //assiocated tables
    private static final String KEY_STATUS = "status";
    private static final String KEY_DESIREDPRO = "desiredID";


    /*********************************************************************
     SQL statement to create the database in different strings
     ****************************************************************/
    private static final String DATABASE_CREATE1 =
            "create table Person( _id integer primary key autoincrement," +
                    "username text unique not null,password text not null," +
                    " name text not null,email text not null," +
                    " address text not null,profilePic BLOB);";

    private static final String DATABASE_CREATE2 =
            "create table Product( _id integer primary key autoincrement, " +
                    "name text not null, brand text not null, " +
                    "keyword text not null, type text not null," +
                    "dateReleased text not null, price float," +
                    " description text not null,gerneralReview text not null);";

    private static final String DATABASE_CREATE3 =
            "create table Instruments ( _id integer primary key not null, " +
                    "family text not null, sourcedFrom text not null, "  +
                    "countryOrigin text not null);";

    private static final String DATABASE_CREATE4 =
            "create table Media ( _id integer primary key not null, " +
                    "link text not null);";

    private static final String DATABASE_CREATE5 =
            "create table CDRecord ( _id integer primary key not null, " +
                    "genre text not null);";

    private static final String DATABASE_CREATE6 =
            "create table DesiredProduct( desiredID integer primary key autoincrement," +
            "status text not null, username text ,_id integer, " +
                    "foreign key (username) references Person(username)," +
                    "foreign key (_id) references Product(_id) );";

    //sql statement to hold all the others into one statement
    private static final String DATABASE_CREATE =
            DATABASE_CREATE1 + DATABASE_CREATE2 + DATABASE_CREATE3
                    + DATABASE_CREATE4 + DATABASE_CREATE5
            + DATABASE_CREATE6;

    /****************************************************************************/

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    // Constructor
    public MusicProductDB(Context ctx)
    {
        Log.e("Inside the MusicProductDB Creation", "MusicProductDB: " );
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException
    {
        Log.e("Attaching the writable database", "MusicProductDB: " );
        db = DBHelper.getWritableDatabase();
        //return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    // nested dB helper class
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db)
        {

            /*db.execSQL(DATABASE_CREATE1);
            db.execSQL(DATABASE_CREATE2);
            db.execSQL(DATABASE_CREATE3);
            db.execSQL(DATABASE_CREATE4);
            db.execSQL(DATABASE_CREATE5);*/
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            // dB structure change..

        }


    }   // end nested class

    /***************************************************************************
     * Getting the creation of all the database
     **************************************************************************/
    public long createProductTable(String name)
    {
        String one = "The first", two = "The second", three = "The third",
                four = "The fourth",five = "The fifth";
        ContentValues initialValues = new ContentValues();

        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_BRAND,name);
        initialValues.put(KEY_WORD,name);
        initialValues.put(KEY_TYPE,name);
        initialValues.put(KEY_DATERELEASED,name);
        initialValues.put(KEY_PRICE,0.00);
        initialValues.put(KEY_DESC,name);
        initialValues.put(KEY_REVIEW,name);

        return db.insert(DATABASE_TABLE_PRODUCT, null, initialValues);
    }

    public void recreateProduct()
    {
        db.execSQL("DROP TABLE PRODUCT");
        db.execSQL(DATABASE_CREATE2);
    }

    /***************************************************************************
     *
     **************************************************************************/

    /***************************************************************
     * Database connections to get access to the person content
     * inside the database
     **************************************************************/

    public long insertPerson(String username, String password, String name,
                             String addressLine, String email)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_USERNAME, username);
        initialValues.put(KEY_PASSWORD, password);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_ADDRESS, addressLine);
        initialValues.put(KEY_EMAIL,email);
        //initialValues.put(KEY_PIC,null);
        return db.insert(DATABASE_TABLE_PERSON, null, initialValues);
    }

    public boolean deletePerson(String username)
    {

        return db.delete(DATABASE_TABLE_PERSON, KEY_USERNAME +
                "=" + username, null) > 0;
    }

    public Cursor getAllPeople()
    {
        return db.query(DATABASE_TABLE_PERSON, new String[]
                        {
                                KEY_USERNAME,
                                KEY_PASSWORD,
                                KEY_NAME,
                                KEY_EMAIL,
                                KEY_ADDRESS
                        },
                null, null, null, null, null);
    }

    public Cursor getPerson(String username) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE_PERSON, new String[]
                                {
                                        KEY_USERNAME,
                                        KEY_PASSWORD,
                                        KEY_NAME,
                                        KEY_EMAIL,
                                        KEY_ADDRESS
                                },
                        KEY_USERNAME + "=" + username,
                        null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //
    public boolean updatePerson(String username, String password, String name,
                                String addressLine, String email, Bitmap profilePic)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_PASSWORD, password);
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL,email);
        args.put(KEY_ADDRESS,addressLine);
        //args.put(KEY_PIC,profilePic);
        return db.update(DATABASE_TABLE_PERSON, args,
                KEY_USERNAME + "=" + username, null) > 0;
    }

    /*********************************************************************************
     * Database access to the Product tables
     ******************************************************************************/

    public Cursor getAllProduct()
    {
        return db.query(DATABASE_TABLE_PRODUCT, new String[]
                        {
                                KEY_ID,
                                KEY_NAME,
                                KEY_BRAND,
                                KEY_WORD,
                                KEY_TYPE,
                                KEY_DATERELEASED,
                                KEY_PRICE,
                                KEY_DESC,
                                KEY_REVIEW
                        },
                null, null, null, null, null);
    }

    public Cursor getProduct(int id) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE_PRODUCT, new String[]
                                {
                                        KEY_NAME,
                                        KEY_BRAND,
                                        KEY_WORD,
                                        KEY_TYPE,
                                        KEY_DATERELEASED,
                                        KEY_PRICE,
                                        KEY_ID,
                                        KEY_DESC,
                                        KEY_REVIEW
                                },
                        KEY_ID + "=" + id,
                        null, null, null, null, null);

        if (mCursor != null)
        {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //
    public boolean updateProduct(String name , String brand, String keyword,
                                 String type, String dateReleased, float price,
                                 int id, String desc, String review, boolean isBought)
    {
        int isB = (isBought ? 1 : 0);
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name); args.put(KEY_BRAND, brand);
        args.put(KEY_WORD,keyword); args.put(KEY_TYPE,type);
        args.put(KEY_DATERELEASED,dateReleased);
        args.put(KEY_PRICE,price); args.put(KEY_DESC,desc);
        return db.update(DATABASE_TABLE_PRODUCT, args,
                KEY_ID + "=" + id, null) > 0;
    }
}
