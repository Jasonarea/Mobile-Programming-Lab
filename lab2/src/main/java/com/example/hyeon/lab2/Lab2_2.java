package com.example.hyeon.lab2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lab2_2 extends AppCompatActivity {
    EditText Url;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_2);
        Url = findViewById(R.id.edit);
        nextBtn = findViewById(R.id.btn);

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String myUrl = Url.getText().toString();    //get the url from textview
                Intent intent = new Intent(Lab2_2.this, NewActivity2.class);    //make intent
                intent.putExtra("Url", myUrl);  //send the data and url string
                startActivity(intent);
            }
        });
    }
}
