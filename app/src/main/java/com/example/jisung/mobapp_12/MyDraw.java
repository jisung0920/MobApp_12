package com.example.jisung.mobapp_12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jisung on 2017-05-18.
 */

public class MyDraw extends View {
    Bitmap mBit;
    Canvas mCan;
    Paint mPaint = new Paint();
    int oldX=-1,oldY=-1;
    public MyDraw(Context context) {
        super(context);
        mPaint.setColor(Color.BLACK);
    }

    public MyDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {


        mBit = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        mCan = new Canvas();
        mCan.setBitmap(mBit);
        mCan.drawColor(Color.YELLOW);

        drawStamp();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBit!=null)
        canvas.drawBitmap(mBit,0,0,mPaint);
    }
    private void drawStamp(){
        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        mCan.drawBitmap(img,10,10,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int)event.getX();
        int Y = (int)event.getY();
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            oldX = X;
            oldY = Y;
        }
        else if(event.getAction()==MotionEvent.ACTION_MOVE){
            if(oldX!=-1) {
                mCan.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
                oldX = X;
                oldY = Y;
            }
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            if(oldX!=-1) {
                mCan.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
            }
            oldX = -1;
            oldY = -1;

        }
        return true;
    }
}
