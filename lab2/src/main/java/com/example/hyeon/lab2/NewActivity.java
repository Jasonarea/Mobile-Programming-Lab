package com.example.hyeon.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = new Intent(this.getIntent());     //get intent
        if(passedIntent != null) {
            String s = passedIntent.getStringExtra("login");    //get string
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();   //make toast message
        }

        Button button0 = (Button)findViewById(R.id.btn0);
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();   //if we click the stop button then new activity is closed
            }
        });
    }
}
