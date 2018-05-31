package com.example.hyeon.lab6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class Lab6_3 extends AppCompatActivity {
    EditText Name, StudentNum;
    Button add, delete;
    ListView listView;

    String[] StudentInfo;
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_3);

        Name = findViewById(R.id.studentName);
        StudentNum = findViewById(R.id.num);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        listView = findViewById(R.id.listView);
        helper = new MySQLiteOpenHelper(Lab6_3.this, "Student.db", null, 1);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String UserName = Name.getText().toString();
                String UserNum = StudentNum.getText().toString();
                if(UserName.equals("") || UserNum.equals(""))
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();
                else {
                    insert(UserName, UserNum);
                    invalidate();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String UserName = Name.getText().toString();
                String UserNum = StudentNum.getText().toString();
                if(!UserName.equals(""))
                    DeleteByName(UserName);
                else
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
                invalidate();
            }
        });

    }
    public void insert(String Name, String Num) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", Name);
        values.put("num", Num);
        db.insert("Student", null, values);
    }
    public void DeleteByName(String Name){
        db = helper.getWritableDatabase();
        db.delete("Student", "name=?", new String[]{Name});
    }
    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("Student", null, null, null, null, null, null);
        StudentInfo = new String[c.getCount()];
        int count = 0;
        while(c.moveToNext()){
            StudentInfo[count++] = c.getString(c.getColumnIndex("name")) + ' ' +
                    c.getString(c.getColumnIndex("num"));
        }
        c.close();
    }
    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, StudentInfo);
        listView.setAdapter(adapter);
    }
}
