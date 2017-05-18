package com.example.jisung.mobapp_12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by jisung on 2017-05-18.
 */

public class MyCanvas extends View {
    Canvas mCan;
    Bitmap mBit;
    Paint mPaint;

    int oldX = -1;
    int oldY =-1;

    public MyCanvas(Context context) {
        super(context);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.BLACK);
        //this.mP
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(10,10,100,100,mPaint);
        int width = canvas.getWidth()/2-45;//전체 폭이 나옴
        int height = canvas.getHeight()/2-45;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);

        mPaint.setStrokeWidth(5);
        canvas.drawRect(width,height,width+90,height+90,mPaint);

        mPaint.setTextSize(70);
        canvas.drawText("Click me",300,300,mPaint);//x,y 시작만 지정하면 된다
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        if(x>=10&& x<=100 && y>=10&& y<=100){
            Toast.makeText(getContext(), "Button Click", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(), "Backgroud", Toast.LENGTH_SHORT).show();
        }
        return true;//이벤트를 받으려면 true
    }
}
