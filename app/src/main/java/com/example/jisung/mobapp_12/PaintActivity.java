package com.example.jisung.mobapp_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"Blurring").setCheckable(true);
        menu.add(0,2,0,"Coloring").setChecked(true);
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
            }
            else{
                item.setChecked(true);
            }
        }
        else if(item.getItemId()==2){

        }
        else if(item.getItemId()==3){

        }
        else if(item.getItemId()==4){}
        else if(item.getItemId()==5){}


        return true;
    }
}
