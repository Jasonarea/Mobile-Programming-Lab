package com.example.hyeon.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab_3_2_2 extends AppCompatActivity {
    TextView nameText, genderText, smsText;
    Button returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_3_2_2);

        nameText = findViewById(R.id.nameT);
        genderText = findViewById(R.id.genderT);
        smsText = findViewById(R.id.smsT);
        Intent intent = getIntent();
        Bundle myBundle = intent.getExtras();
        nameText.setText("성명 : " + myBundle.getString("name"));
        genderText.setText("성별 : " + myBundle.getString("gender"));
        smsText.setText("수신여부 : " +myBundle.getString("sms"));

        returnBtn = findViewById(R.id.returnBtn);
        returnBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {     //if we click the button, return to previous window
                finish();
            }
        });
    }
}
