package com.example.williamcarey.c16315253application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
//import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ModifyAccountDetails extends Activity implements View.OnClickListener{

    //buttons to work with the programme
    private Button retHome, submit, editaccount, takePic;
    //button to set the text
    private Button [] buttonsModifyAccount;
    //edittext to get at the username
    EditText username;
    //editext to get and store the data
    private EditText[] personDetails;
    //colours to work with
    private int buttonColorSet, textFieldColorSet;
    //allow for pictures to be instaianted
    //camera objects
    CameraManager cameraManager;
    CameraDevice cameraDevice;
    CameraCaptureSession cameraCaptureSession;
    CameraCharacteristics cameraCharacteristics;
    //pictures
    Bitmap profileImage;
    //TextView image
    TextView profilePicture;

    //string camera id
    private String [] cameraId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_account_details);

        buttonColorSet = getColor(R.color.black);
        textFieldColorSet = getColor(R.color.forestGreen);

        //connecting the buttons
        retHome = findViewById(R.id.goHome);
        retHome.setOnClickListener(this);
        submit = findViewById(R.id.getDetails);
        submit.setOnClickListener(this);
        editaccount = findViewById(R.id.modifyAccDet);
        editaccount.setOnClickListener(this);
        takePic = findViewById(R.id.takePic);
        takePic.setOnClickListener(this);
        profilePicture = findViewById(R.id.imageDisplayText);
        profilePicture.setOnClickListener(this);

        buttonsModifyAccount = new Button[]{
                    findViewById(R.id.goHome),
                    findViewById(R.id.getDetails),
                    findViewById(R.id.modifyAccDet),
                findViewById(R.id.takePic)
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

        //Camera instaiate
        cameraManager = getApplicationContext().getSystemService(CameraManager.class);

        try {
            //we know there is two camera
            cameraId = cameraManager.getCameraIdList();
            //cameraManager.openCamera(cameraId[0],Context.getMainExecutor(),);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.goHome: 
            {
                finish();
                break;
            }

            case R.id.imageDisplayText:
            {
                Intent picPicker = new Intent(Intent.ACTION_PICK);
                picPicker.setType("image/*");
                startActivityForResult(picPicker,1);
                break;
            }

            case R.id.takePic:
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                File output = new File(dir, "CameraContentDemo.jpeg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
                startActivityForResult(intent, 1);
                break;
            }
            default:
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
        }
    }
}
