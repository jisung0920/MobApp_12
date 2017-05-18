package com.example.jisung.mobapp_12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DrawFilter;
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
    Boolean dmode = true;
    BlurMaskFilter blur;

    int oldX = -1, oldY = -1;

    public MyDraw(Context context) {
        super(context);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint.setColor(Color.BLACK);

    }

    public MyDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.BLACK);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {


        mBit = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCan = new Canvas();
        mCan.setBitmap(mBit);
        mCan.drawColor(Color.YELLOW);

        drawStamp(1, 1);
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBit != null)
            canvas.drawBitmap(mBit, 0, 0, mPaint);
    }

    private void drawStamp(int x, int y) {
        Bitmap img = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mCan.drawBitmap(img, x, y, mPaint);
    }

    public void clear() {
        mBit.eraseColor(Color.WHITE);
        invalidate();
    }

    public void Blur(Boolean check) {
        if (check) {
            blur = new BlurMaskFilter(80, BlurMaskFilter.Blur.INNER);
            mPaint.setMaskFilter(blur);
        } else {
            mPaint = new Paint();
        }
        invalidate();
    }

    public void ColorF(Boolean check) {

        if (check) {
            float[] ary = {2f, 0f, 0f, 0f, -25f,
                    0f, 2f, 0f, 0f, -25f,
                    0f, 0f, 2f, 0f, -25f,
                    0f, 0f, 0f, 1f, 0f,
            };
            ColorMatrix matrix = new ColorMatrix(ary);
            mPaint.setColorFilter(new ColorMatrixColorFilter(matrix));
        }
        else
            mPaint=new Paint();
        invalidate();
    }

    public void textSet(int s) {
        mPaint.setStrokeWidth(s);

    }

    public void testColor(int i) {
        if (i == 1)
            mPaint.setColor(Color.RED);
        else
            mPaint.setColor(Color.BLUE);
    }

    public void rotateSet() {
        mCan.rotate(30, this.getWidth() / 2, this.getWidth() / 2);

    }

    public void moveSet() {
        mCan.translate(10f, 10f);
    }

    public void scaleSet() {
        mCan.scale(1.5f, 1.5f);
    }

    public void skewSet() {
        mCan.skew(0.2f, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int X = (int) event.getX();
        int Y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (!dmode)
                drawStamp(X, Y);
            invalidate();

            oldX = X;
            oldY = Y;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            if (oldX != -1) {
                if (dmode)
                    mCan.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
                oldX = X;
                oldY = Y;
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            if (oldX != -1) {
                if (dmode)
                    mCan.drawLine(oldX, oldY, X, Y, mPaint);
                invalidate();
            }
            oldX = -1;
            oldY = -1;

        }
        return true;
    }
}
