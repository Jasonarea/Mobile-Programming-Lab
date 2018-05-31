package com.example.hyeon.lab6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab6_2 extends AppCompatActivity {
    EditText studentNum, name;
    Button call, save, init;
    SharedPreferences sp;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_2);

        studentNum = findViewById(R.id.sn);
        name = findViewById(R.id.sn2);
        call = findViewById(R.id.call);
        save = findViewById(R.id.save);
        init = findViewById(R.id.initialize);

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                applySharedPreferences();
            }
        });
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sharedPreference();
                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_LONG).show();
            }
        });
        init.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                studentNum.setText("");
                name.setText("");
            }
        });

    }
    public void sharedPreference() {
        sp = getSharedPreferences("getInfo", MODE_PRIVATE);
        toEdit = sp.edit();
        toEdit.putString("StudentNum", studentNum.getText().toString());
        toEdit.putString("Name", name.getText().toString());
        toEdit.commit();
    }

    public void applySharedPreferences() {
        sp = getSharedPreferences("getInfo", MODE_PRIVATE);
        if(sp != null && sp.contains("StudentNum")){
            String snum = sp.getString("StudentNum", "nonum");
            studentNum.setText(snum);
        }
        if(sp!=null && sp.contains("Name")){
            String sName = sp.getString("Name", "noname");
            name.setText(sName);
        }
    }
}
