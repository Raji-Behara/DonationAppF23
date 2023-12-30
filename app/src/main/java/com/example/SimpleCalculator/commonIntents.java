package com.example.SimpleCalculator;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.activity.result.ActivityResultContracts;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.donationappf23.R;

public class commonIntents
        extends AppCompatActivity {

    Button cameraBut;
    Button searchBut;
    ImageView cameraImage;
    EditText searchTxt;
    Button callBut;

    ActivityResultLauncher<Intent> cameraActivityLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_intents);
        cameraBut = findViewById(R.id.camerabutton);
        searchBut = findViewById(R.id.searchbutton);
        cameraImage = findViewById(R.id.image);
        searchTxt = findViewById(R.id.searchtext);
        callBut = findViewById(R.id.callbutton);

        searchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!searchTxt.getText().toString().isEmpty()) {
                    String  query = searchTxt.getText().toString();
                    Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                    searchIntent.putExtra(SearchManager.QUERY, query);

                  //  if (searchIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(searchIntent);
                 //   }
                }
            }
        });

        cameraBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // implicit
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Log.d("permission","after give the permission");
               // if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    // if there are more than 1 app to handle the intent,
                    // the os will ask the user.
                    //  startActivityForResult(cameraInent, REQUEST_IMAGE_CAPTURE);
                   cameraActivityLauncher.launch(cameraIntent);
               // }
            }else {
                requestPermissions(new String []{Manifest.permission.CAMERA},100);
                Log.d("permission","after request the permission");

            }

            }
        });

        cameraActivityLauncher = registerForActivityResult(
               new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){

                            Bitmap bitmap= result.getData().getParcelableExtra("data");
                            cameraImage.setImageBitmap(bitmap);
                        }
                    }
                });

        callBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                    if (!searchTxt.getText().toString().isEmpty()) {
                        String phoneNumber = searchTxt.getText().toString();

                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phoneNumber));
                        // if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                        //}
                    }
                }else {

                    requestPermissions(new String []{Manifest.permission.CALL_PHONE},100);

                }

            }
        });



    }
}