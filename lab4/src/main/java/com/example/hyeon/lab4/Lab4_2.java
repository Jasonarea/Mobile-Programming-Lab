package com.example.hyeon.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Lab4_2 extends AppCompatActivity {
    LinearLayout page = null;
    Button button = null;

    Animation translateLeft = null;
    Animation translateRight = null;

    boolean isPageState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4_2);

        page = (LinearLayout)findViewById(R.id.page);
        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingAnimationListener listener = new SlidingAnimationListener();
        translateLeft.setAnimationListener(listener);
        translateRight.setAnimationListener(listener);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(isPageState) {
                    page.startAnimation(translateRight);
                }
                else {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                }
            }
        });
    }

    class SlidingAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation){

        }
        @Override
        public void onAnimationEnd(Animation animation){
            if(isPageState) {
                page.setVisibility(View.INVISIBLE);
                button.setText("Open Page");
                isPageState = false;
            }
            else {
                button.setText("Close Page");
                isPageState = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation){

        }
    }
}
