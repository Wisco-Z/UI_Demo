package com.android.ui_demo;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.uidemo.R;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        final ProgressBar progressBar = findViewById(R.id.progress);
        progressBar.setProgress(80);
        //在Android中，4.0以后是不能直接在线程中操作控件的
        //进度条是个特例
        new Thread(){
            @Override
            public void run() {
                for(int i = 1 ; i <= 100 ; i++) {
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
