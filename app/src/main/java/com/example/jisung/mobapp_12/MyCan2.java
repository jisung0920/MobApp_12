package com.example.jisung.mobapp_12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jisung on 2017-05-18.
 */

public class MyCan2 extends View {
    Paint mPaint;
    String optype="";
    float sX = -1;
    float sY = -1;
    float tX = -1;
    float tY = -1;

    public MyCan2(Context context) {
        super(context);
    }

    public MyCan2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap img = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Bitmap bigImg = Bitmap.createScaledBitmap(img,img.getWidth()*2,img.getHeight()*2,false);
        int cenX = (this.getWidth()/2-bigImg.getWidth()/2);
        int cenY = (this.getHeight()/2 - bigImg.getHeight()/2);
        if(optype.equals("rotate"))
            canvas.rotate(45,this.getWidth()/2,getWidth()/2);
        BlurMaskFilter blur = new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL);
        mPaint.setMaskFilter(blur);
        canvas.drawBitmap(bigImg,cenX,cenY,null);
        float[] array = {2f, 0f, 0f, 0f, -25f,
                0f, 2f, 0f, 0f, -25f,
                0f, 0f, 2f, 0f, -25f,
                0f, 0f, 0f, 1f, 0f,
        };
        ColorMatrix matrix = new ColorMatrix(array);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        //mPaint.setColor(filter);
        //canvas.drawBitmap(img,);
    }

    public void setOperationType(String operationType){
        this.optype = operationType;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == event.ACTION_DOWN) {
            sX = event.getX();
            sY = event.getY();
        }
        else if(event.getAction()==event.ACTION_UP){
            tX = event.getX();
            tY = event.getY();
            invalidate();
        }
        return true;
    }
}
