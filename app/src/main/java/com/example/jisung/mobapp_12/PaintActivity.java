package com.example.jisung.mobapp_12;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PaintActivity extends AppCompatActivity {

    MyDraw screen;
    CheckBox c1;
    int bntCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        screen = (MyDraw)findViewById(R.id.mview);
        c1= (CheckBox)findViewById(R.id.c1);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    screen.dmode=false;
                else
                    screen.dmode=true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Blurring").setCheckable(true);
        menu.add(0,2,0,"Coloring").setCheckable(true);
        menu.add(0,3,0,"Pen Width BIG").setCheckable(true);
        menu.add(0,4,0,"Pen Color RED");
        menu.add(0,5,0,"pen Color BLUE");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==1){
            if(item.isChecked()){
                item.setChecked(false);
                screen.Blur(false);
            }
            else{
                item.setChecked(true);
                screen.Blur(true);
            }
        }
        else if(item.getItemId()==2){
            if(item.isChecked()){
                item.setChecked(false);
                screen.ColorF(false);
            }
            else{
                item.setChecked(true);
                screen.ColorF(true);
            }

        }
        else if(item.getItemId()==3){
            if(item.isChecked()){
                item.setChecked(false);
                screen.textSet(3);
            }
            else{
                item.setChecked(true);
                screen.textSet(5);

            }

        }
        else if(item.getItemId()==4){
            screen.testColor(1);
        }
        else if(item.getItemId()==5){
            screen.testColor(2);
        }


        return false;
    }
    void onClick(View v){
        if(v.getId()==R.id.erase){
            screen.clear();
        }
        else if(v.getId()==R.id.rot){
            c1.setChecked(true);
            screen.rotateSet();
        }
        else if(v.getId()==R.id.mov)
        {
            c1.setChecked(true);
            screen.moveSet();
        }
        else if(v.getId()==R.id.sca){
            c1.setChecked(true);
            screen.scaleSet();
        }
        else if(v.getId()==R.id.ske){
            c1.setChecked(true);
            screen.skewSet();
        }
    }
}
