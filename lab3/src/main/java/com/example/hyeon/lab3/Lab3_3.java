package com.example.hyeon.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab3_3 extends AppCompatActivity {
    public Button btnFrag1;
    public Button btnFrag2;

    public fragment1 firstFrag;
    public fragment2 secondFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_3);

        init();

        btnFrag1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {   //Using Fragment manager, replace the fragment to another
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, firstFrag).commit();
            }
        });

        btnFrag2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {   //Using Frament manager, replace the fragment to another
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, secondFrag).commit();
            }
        });
    }

    public void init() {
        btnFrag1 = (Button)findViewById(R.id.tab1Btn);
        btnFrag2 = (Button)findViewById(R.id.tab2Btn);

        firstFrag = new fragment1();
        secondFrag = new fragment2();
    }
}
