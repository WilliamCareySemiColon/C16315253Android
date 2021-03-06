package com.example.williamcarey.c16315253application;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends Activity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener{

    //buttons to do with this activity
    Button search, cancel, viewItemsBought, searchKeyWord;
    //Edittext to capture the data inside the searchbar
    EditText searchBar;
    //connecting to the dropdown menu
    Spinner dropdown;

    //button array to set all the colours
    ArrayList<Button> buttons;
    //way to access the data
    ArrayAdapter<CharSequence> dropDownAdapt;

    //sample infomation to work with
    ArrayList<String> sample;
    String [] samples;

    //listview to work with
    ListView list;
    ArrayAdapter listItems;

    //colours to work with
    private int buttonColorSet;

    //plumbing code to get the look of the layout
    private Cursor c;
    private String [] dbField;
    private int [] ids;
    private SimpleCursorAdapter myAdapter;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //setting the colours
        buttonColorSet = getColor(R.color.black);

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
        dropdown = findViewById(R.id.spinnerAccDetails);
        //listview
        list = findViewById(R.id.listView);

        /*******************************************************************************
         * logic came from site
         * https://developer.android.com/guide/topics/ui/controls/spinner#java
         ******************************************************************************/
        dropDownAdapt = ArrayAdapter.createFromResource(this,R.array.user_details,
               android.R.layout.simple_spinner_dropdown_item);
        dropDownAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdown.setAdapter(dropDownAdapt);
        dropdown.setOnItemSelectedListener(this);

        /********************************************************************************/


        //setting the colour of the buttons
        for(Button b: buttons)
            b.setBackgroundColor(buttonColorSet);

        //the start of getting sample info for the listview

        /*******************************************************
         * Tried to get content from database - didn't have time
        dbField = new String[] {"name"};
        ids = new int[]{R.id.productItem};
        product = new Product(getApplicationContext());
        c = product.getAllProducts();

         myAdapter = new SimpleCursorAdapter(this, R.layout.row,
         c, dbField, ids,0);
        *******************************************************/

        //sample info
        sample = new ArrayList<String>();

        for(int i = 48; i < 91; i++)
        {
            String j =  (((char) i) + " ");
            sample.add(j);
        }

        samples = new String[sample.size()];

        for(int i = 0; i < sample.size(); i++)
            samples[i] = sample.get(i);

        //working with displaying the information
        listItems = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,samples);

        list.setAdapter(listItems);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item value
                String  itemValue =  listItems.getItem(position).toString();

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+position+"  ListItem : " +itemValue,
                        Toast.LENGTH_LONG).show();
            }
        });//end onSetItemClickListener()
    }//end oncreate

    //the listener for the buttons
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

    //the listener for the dropdown menu
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String selection = parent.getItemAtPosition(pos).toString();
        switch(selection)
        {
            case "logout":
                finish();
                break;
            case "View Account Details":
                Intent intent = new Intent(HomePage.this,ModifyAccountDetails.class);
                startActivity(intent);
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}//end class HomePage
