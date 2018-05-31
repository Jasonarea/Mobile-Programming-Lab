package com.example.hyeon.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Lab6_1 extends AppCompatActivity {
    EditText editText;
    Button writeFile, clear, readFile, finishApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_1);

        editText = findViewById(R.id.txtData);
        writeFile = findViewById(R.id.btn1);
        clear = findViewById(R.id.btn2);
        readFile = findViewById(R.id.btn3);
        finishApp = findViewById(R.id.btn4);

        final String[] text = {""};
        writeFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileWriter writer;
                    String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/App";
                    File dir = new File(dirPath);
                    //폴더가 없다면 새로 만들어준다.
                    if(!dir.exists()) {
                        dir.mkdir();
                    }
                    //myApp 폴더 밑에 myFile.txt 파일 지정
                    File file = new File(dir + "/myFile.txt");
                    if(!file.exists())
                        file.mkdir();
                    PrintWriter write = new PrintWriter(file);
                    write.print("");
                    write.close();
                    //file write
                    writer = new FileWriter(file, true);
                    writer.write(editText.getText().toString());
                    writer.flush();
                    writer.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        readFile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                File sdCard = Environment.getExternalStorageDirectory();
                File directory = new File(sdCard.getAbsolutePath() + "/App");
                directory.mkdirs();

                try {
                    File file = new File(directory, "myFile.txt");
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    int i = 0;
                    String text = "";
                    while((i = isr.read()) != -1) {
                        text += (char)i;
                    }
                    editText.setText(text);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        finishApp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
