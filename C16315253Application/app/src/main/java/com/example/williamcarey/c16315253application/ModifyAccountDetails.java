package com.example.williamcarey.c16315253application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyAccountDetails extends Activity implements View.OnClickListener{

    //buttons to work with the programme
    private Button retHome, submit, editaccount;
    //button to set the text
    private Button [] buttonsModifyAccount;
    //edittext to get at the username
    EditText username;
    //editext to get and store the data
    private EditText[] personDetails;
    //colours to work with
    private int buttonColorSet, textFieldColorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_account_details);

        buttonColorSet = getColor(R.color.black);
        textFieldColorSet = getColor(R.color.white);

        //connecting the buttons
        retHome = findViewById(R.id.goHome);
        retHome.setOnClickListener(this);
        submit = findViewById(R.id.getDetails);
        submit.setOnClickListener(this);
        editaccount = findViewById(R.id.modifyAccDet);
        editaccount.setOnClickListener(this);

        buttonsModifyAccount = new Button[]{
                    findViewById(R.id.goHome),
                    findViewById(R.id.getDetails),
                    findViewById(R.id.modifyAccDet)
                };

        //setting the colour of the buttons
        for(Button b: buttonsModifyAccount)
            b.setBackgroundColor(buttonColorSet);
        //connecting the textview part of the username
        username = findViewById(R.id.usernameDisplayInput);

        personDetails = new EditText[]
                {

                        findViewById(R.id.nameDisplaytextfield),
                        findViewById(R.id.addressDisplayBar),
                        findViewById(R.id.emailDisplayBar),
                        findViewById(R.id.passwordDisplayText)
                };

    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.goHome: 
            {
                finish();
                break;
            }
            default:
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
        }
    }
}
