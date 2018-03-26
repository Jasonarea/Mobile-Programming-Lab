package com.example.hyeon.lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Lab1-2
public class Main2Activity extends AppCompatActivity {
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init(); // initalization function.
    }

    public void init() {    // find view by id (reference) from xml files
        edit_name = findViewById(R.id.edit_name);
        btn_clear = findViewById(R.id.btn_clear);
        btn_print = findViewById(R.id.btn_print);
        view_print =findViewById(R.id.view_print);
    }
    public void clearClicked(View v) {
        edit_name.setText("");  //if you click CLEAR button, the edittext view is cleared
    }

    public void printClicked(View v) {
        String text = "";   // if you click PRINT button, your name is printed below.
        text = edit_name.getText().toString();  // set the text(string value) to text of edit_name
        view_print.setText(text);
    }
}
