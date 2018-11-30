package com.example.williamcarey.c16315253application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener
{

    //button variables to work with
    private Button register, reset;
    private EditText [] textfields;
    //colours to work with
    private int buttonColorSet, textFieldColorSet;

    //Person to get access to the person data
    public Person person;

    //database variable
    private MusicProductDB BEDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonColorSet = getColor(R.color.black);
        textFieldColorSet = getColor(R.color.forestGreen);

        BEDB = new MusicProductDB(getApplicationContext());
        BEDB.open();

        textfields = new EditText[] {
                findViewById(R.id.name),
                findViewById(R.id.address1),
                findViewById(R.id.address2),
                findViewById(R.id.address3),
                findViewById(R.id.email),
                findViewById(R.id.username),
                findViewById(R.id.password)
        };

        for(EditText t: textfields)
            t.setTextColor(textFieldColorSet);

        register = (Button)findViewById(R.id.register);
        register.setBackgroundColor(buttonColorSet);
        register.setOnClickListener(this);

        reset =  (Button)findViewById(R.id.reset);
        reset.setBackgroundColor(buttonColorSet);
        reset.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        if(view.getId() == reset.getId())
        {
            for(EditText t: textfields)
            {
                t.setText("");
            }
            Toast.makeText(getApplicationContext(),
                    "Textfields have been reset",
                    Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.e("Creating new person and db", "onClick: database creation method");
            /*person = new Person(textfields[0].getText().toString(),
                    textfields[1].getText().toString(),
                    textfields[2].getText().toString(),
                    textfields[3].getText().toString(),
                    textfields[4].getText().toString(),
                    textfields[5].getText().toString(),
                    textfields[6].getText().toString(),
                    getApplicationContext());*/

            Intent intent = new Intent(MainActivity.this,HomePage.class);
            startActivity(intent);
        }
    }
}

