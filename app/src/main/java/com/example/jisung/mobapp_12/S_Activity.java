package com.example.jisung.mobapp_12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class S_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_);
    }
    void onClick(View v){
        if(v.getId()==R.id.bt1){
            Intent intent = new Intent(this,PracActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this,PaintActivity.class);
            startActivity(intent);
        }
    }
}
