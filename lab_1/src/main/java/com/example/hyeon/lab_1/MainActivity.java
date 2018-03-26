package com.example.hyeon.lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Lab 1_1
    ImageView imageView;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find view by id from xml file.
        imageView = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView.setVisibility(View.VISIBLE);  //Set the visibility of the picture
        imageView2.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.change);
        button.setText("Change Image");
        button.setOnClickListener(this);    // execute on click listener
    }

    public void onClick(View v) {
        changeImage();  // If you click the button the photo is changed to another one
    }

    private void changeImage() {    //Use setVisibility and getVisibility to control the visibility of pictures
        if (imageView.getVisibility() == View.VISIBLE) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        } else {
            imageView2.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}