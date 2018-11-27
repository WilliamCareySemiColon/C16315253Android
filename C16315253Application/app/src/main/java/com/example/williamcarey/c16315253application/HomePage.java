package com.example.williamcarey.c16315253application;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends Activity implements View.OnClickListener{

    //buttons to do with this activity
    Button search, cancel, viewItemsBought, searchKeyWord;
    //Edittext to capture the data inside the searchbar
    EditText searchBar;
    //connecting to the spinner
    Spinner dropdwon;

    //button array to set all the colours
    ArrayList<Button> buttons;

    //colours to work with
    private int buttonColorSet, textFieldColorSet;

    //plumbing code to get the look of the layout
    /*private Cursor c;
    private String [] dbField;
    private int [] ids;
    private SimpleCursorAdapter myAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //setting the colours
        buttonColorSet = getColor(R.color.black);
        textFieldColorSet = getColor(R.color.white);

        buttons = new ArrayList<Button>();
        //setting all the buttons
        search = findViewById(R.id.search);
        search.setOnClickListener(this);
        buttons.add(search);
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        buttons.add(cancel);
        viewItemsBought = findViewById(R.id.viewItemsBought);
        viewItemsBought.setOnClickListener(this);
        buttons.add(viewItemsBought);
        //the layout with the search bar attachment
        searchBar = findViewById(R.id.searchBar);
        searchKeyWord = findViewById(R.id.SearchKeyWord);
        searchKeyWord.setOnClickListener(this);
        buttons.add(searchKeyWord);
        //connecting the spinner
        dropdwon = findViewById(R.id.spinnerAccDetails);

        //setting the colour of the buttons
        for(Button b: buttons)
            b.setBackgroundColor(buttonColorSet);

    }
    public void onClick(View view)
    {
        Button sample = (Button) view;
        String statement =  sample.getText().toString();
        /*switch (view.getId())
        {
            case search.getId():
                Toast.makeText(getApplicationContext(),
                        "You pressed")
        }*/

        Toast.makeText(getApplicationContext(),
                "You pressed the " + statement + " button",Toast.LENGTH_LONG).show();
    }
}
