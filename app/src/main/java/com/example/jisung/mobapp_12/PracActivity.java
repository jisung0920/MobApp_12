package com.example.jisung.mobapp_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PracActivity extends AppCompatActivity {
    MyCan2  canvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prac);
        canvas = (MyCan2)findViewById(R.id.canvas);
    }
    public void onClick(View v){
        canvas.setOperationType((String)v.getTag());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Blurring");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==1)
            canvas.setOperationType("Blur");
        return true;
    }
}
