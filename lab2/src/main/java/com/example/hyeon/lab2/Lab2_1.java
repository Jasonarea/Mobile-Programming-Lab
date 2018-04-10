package com.example.hyeon.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab2_1 extends AppCompatActivity {
    Button button1;
    EditText Name, Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_1);

        button1 = (Button)findViewById(R.id.btn1);
        Name = (EditText)findViewById(R.id.edittext1);
        Age = (EditText)findViewById(R.id.edittext2);


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {   // If we click the button
                String loginName = Name.getText().toString();
                String loginAge = Age.getText().toString();
                String toast = "Student info : " + loginName + ", " + loginAge;     //create toast message string
                Intent intent = new Intent(Lab2_1.this, NewActivity.class);
                intent.putExtra("login", toast);        //send another activity with string

                startActivity(intent);
            }
        });
    }
}
