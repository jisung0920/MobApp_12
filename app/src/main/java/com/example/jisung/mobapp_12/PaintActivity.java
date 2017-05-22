package com.example.jisung.mobapp_12;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class PaintActivity extends AppCompatActivity {

    MyDraw screen;
    CheckBox c1;
    int bntCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        checkPermission();
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
        else if(v.getId() == R.id.open){
            if(screen.open(getExternalPath()))
                Toast.makeText(this, "불러왔습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.save){
            if (screen.save(getExternalPath()))
                Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "저장에 실패하였습니다.", Toast.LENGTH_SHORT).show();
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

    public void checkPermission() {
        int permissioninfo = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissioninfo == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "SDCard 쓰기 권한 있음", Toast.LENGTH_SHORT).show();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(getApplicationContext(), "권한의 필요성 설명", Toast.LENGTH_SHORT).show();

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        String str = null;
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                str = "SD Card 쓰기권한 승인";
            else str = "SD Card 쓰기권한 거부";
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }


    public String getExternalPath() {
        String sdPath = "";
        String ext = Environment.getExternalStorageState();
        if (ext.equals(Environment.MEDIA_MOUNTED)) {
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/"; //sdPath = "/mnt/sdcard/";
        } else sdPath = getFilesDir() + "";
        return sdPath;
    }
}
