package com.example.hyeon.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Lab3_2 extends AppCompatActivity {
    TextView nameText, genderText, smsText;
    EditText nameEdit;
    RadioGroup radioGroup;
    RadioButton boy, girl;
    CheckBox sms, email;
    Button restBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_2);

        nameText = findViewById(R.id.nameText);
        nameEdit = findViewById(R.id.nameEdit);
        genderText = findViewById(R.id.genderText);
        radioGroup = findViewById(R.id.radioGroup);
        boy = findViewById(R.id.boy);
        girl = findViewById(R.id.girl);
        smsText = findViewById(R.id.smsText);
        sms = findViewById(R.id.sms);
        email = findViewById(R.id.email);
        restBtn = findViewById(R.id.registerBtn);

        restBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lab_3_2_2.class);
                Bundle myBundle = new Bundle();
                myBundle.putString("name", nameEdit.getText().toString());
                if(boy.isChecked())     //is boy checked, put the boy, else put the girl
                    myBundle.putString("gender", "남");
                else
                    myBundle.putString("gender", "여");
                String checkMail = "";
                if(sms.isChecked())     //create string because of checkbox allows multi-checking
                    checkMail += "SMS   ";
                if(email.isChecked())
                    checkMail += "e-mail";
                myBundle.putString("sms", checkMail);
                intent.putExtras(myBundle);
                startActivity(intent);
            }
        });
    }
}
