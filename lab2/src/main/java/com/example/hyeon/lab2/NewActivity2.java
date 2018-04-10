package com.example.hyeon.lab2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity2 extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        textView = findViewById(R.id.textview);
        goBtn = findViewById(R.id.gobtn);
        backBtn = findViewById(R.id.backbtn);

        Intent passedIntent = new Intent(this.getIntent());
        final String myUrl = passedIntent.getStringExtra("Url");    //get the url string from Lab2_2 class
        textView.setText(myUrl);    //set the textview mesesage

        goBtn.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(myUrl.equals(""))    //if there is no text in url
                    Toast.makeText(getApplication(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();   //make toast message
                else {  //if not
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + myUrl));   //go to url
                    startActivity(intent);
                }
            }
        }));
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override       //if we click the back button
            public void onClick(View view) {
                Toast.makeText(getApplication(), "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
                finish();   //make the toast message and return to previous window
            }
        });
    }
}
