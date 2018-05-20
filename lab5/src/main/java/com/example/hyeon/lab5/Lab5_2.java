package com.example.hyeon.lab5;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab5_2 extends AppCompatActivity {
    TextView factorial;
    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_2);
        factorial = (TextView)findViewById(R.id.textView2);
        btn = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Factorial().execute();
            }
        });
    }

    private class Factorial extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected Integer doInBackground(Void... voids) {
            int fact = 1;
            int values = Integer.parseInt(editText.getText().toString());
            for(int i = values; i>=1;i--) {
                try {
                    Thread.sleep(500);
                    fact *= i;
                    publishProgress(i);
                }catch(Exception e){}
            }
            return fact;
        }


        @Override
        protected void onPreExecute() {
            factorial.setText("");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            factorial.append(Integer.toString(values[0].intValue()) + ' ');
        }

        @Override
        protected void onPostExecute(Integer value) {
            factorial.append("\n" + "= " + value);
        }
    }
}
