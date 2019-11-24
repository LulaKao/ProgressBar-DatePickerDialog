package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button btn;
    LinearLayout page_progressBar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        page_progressBar = findViewById(R.id.llProgressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_progressBar.setVisibility(View.VISIBLE); //讓 ProgressBar 的 layout 出現

                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(3000); //讓 ProgressBar 轉3秒
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        finally{
                            //ProgressBar 結束後切換到 DatePickerDialog 的 Activity
                            intent = new Intent();
                            intent.setClass(MainActivity.this,DatePickerDialog.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }).start();
            }
        });
    }
}