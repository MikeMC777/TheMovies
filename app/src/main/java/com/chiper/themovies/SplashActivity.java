package com.chiper.themovies;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    private long delay = 100;
    private ProgressBar pbSplash;
    Handler h = new Handler();
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        } catch (RuntimeException e) {

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();

        pbSplash = findViewById(R.id.progressBar);


        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while(i <= delay){
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            pbSplash.setProgress(i);
                        }
                    });
                    try{
                        Thread.sleep(50);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    i++;
                }
                Intent intent = new Intent(SplashActivity.this, MoviesListActivity.class);
                startActivity(intent);
                finish();
            }
        });
        hilo.start();
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
