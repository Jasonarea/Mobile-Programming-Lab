package com.example.hyeon.lab4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class Lab4_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        MyView m = new MyView(Lab4_1.this);

        ll.addView(m);
        setContentView(ll);
    }

    class MyView extends View {
        Paint paint = new Paint();
        Path path = new Path();
        public MyView(Context context) {
            super(context);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10f);
            paint.setColor(Color.BLUE);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);

        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN :
                    path.moveTo(x, y);
                    break;
                case MotionEvent.ACTION_MOVE :
                    path.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP :
                    break;
            }
            invalidate();

            return true;
        }
    }
}
