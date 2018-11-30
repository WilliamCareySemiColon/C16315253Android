package com.example.williamcarey.c16315253application;

//application imports
import android.app.Activity;
//content imports
import android.content.Context;
import android.content.Intent;
//graphics import
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
/*****************************************************************
 * commented out parts of the code that I planned to implement
 * but didn't have the time
 *
 *
//camera2 imports
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
//net imports
import android.media.ImageReader;
import android.net.Uri;
*****************************************************************/
//os imports
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
/***************************************************************
import android.os.Environment;
//provider import
import android.provider.MediaStore;
//views util
import android.util.Size;
import android.util.SparseIntArray;
//views import
import android.view.Surface;
import android.view.TextureView;
******************************************************************/
import android.view.View;
//widget imports
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
//import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**************************************************
//io imports
import java.io.File;
import java.util.ArrayList;
**************************************************/

public class ModifyAccountDetails extends Activity implements View.OnClickListener{

    //buttons to work with the programme
    private Button retHome, submit, editaccount, takePic;
    //button to set the text
    private Button [] buttonsModifyAccount;
    //edittext to get at the username
    private EditText username;
    //editext to get and store the data
    private EditText[] personDetails;
    //colours to work with
    private int buttonColorSet, textFieldColorSet;
    //allow for pictures to be instaianted
    /**************************************************************************************
    //objects to work with the camera
    private CameraManager cameraManager;
    private CameraDevice cameraDevice;
    private CameraCaptureSession cameraCaptureSession;
    private CameraCharacteristics cameraCharacteristics;
    private CaptureRequest.Builder builder;
    Camera camera;
    //string camera id
    private String [] cameraId;
    //pictures
    Bitmap profileImage;
    //getting the parameters of the pictures working with
    private int imageWidth, imageHeight;
    private Size [] jpegSize;
    private Size previewSize;
    private ImageReader imageReader;
    private ArrayList<Surface> surfaces;
    private static final int MAX_PICS = 2;
    private static final SparseIntArray CAMERA_ORIETATION = new SparseIntArray();
    static
    {
        CAMERA_ORIETATION.append(Surface.ROTATION_0,90);
        CAMERA_ORIETATION.append(Surface.ROTATION_90,0);
        CAMERA_ORIETATION.append(Surface.ROTATION_180,270);
        CAMERA_ORIETATION.append(Surface.ROTATION_270,180);
    }
     ***************************************************************************************/
    //TextView image
    ImageView profilePicture;



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
        /******************************************************************************************
        cameraManager = (CameraManager)getSystemService(Context.CAMERA_SERVICE);
        surfaces = new ArrayList<>(MAX_PICS);
        try {
            cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraDevice.getId());
            jpegSize =
            cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)
                .getOutputSizes(ImageFormat.JPEG);
            imageWidth = jpegSize[0].getWidth();
            imageHeight = jpegSize[0].getHeight();
            imageReader.newInstance(imageWidth,imageHeight,ImageFormat.JPEG,1);
            surfaces.add(imageReader.getSurface());
            //surfaces.add(new Surface())
            cameraId = cameraManager.getCameraIdList();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        //camera = Camera.open(1);
         ******************************************************************************************/
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

            /***************************************************************************************
             * Had plans to take pictures but didn't have the time to implement fully
            case R.id.takePic:
            {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
               // File output = new File(dir, "CameraContentDemo.jpeg");
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivityForResult(intent, 1);
                break;
            }
            ***************************************************************************************/
            default: {
                Button b = (Button)view;
                String s = b.getText().toString();
                Toast.makeText(getApplicationContext(), "Hello " +s
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    profilePicture.setImageBitmap(selectedImage);
                    profilePicture.setRotation(270);
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
