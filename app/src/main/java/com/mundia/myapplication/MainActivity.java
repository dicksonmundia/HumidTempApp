package com.mundia.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIMER = 3000;

    Animation topAnim, botomAnim;
    TextView mWelcome, mTech, mHTC;
    ImageView mLogo, mImage;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMER);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        
        mHTC = findViewById(R.id.mHTCTxt);
        mWelcome = findViewById(R.id.mWelcomeTxt);
        mTech = findViewById(R.id.mTech);

        mImage = findViewById(R.id.mImage);
        mLogo = findViewById(R.id.mLogo);

        mLogo.setAnimation(botomAnim);
        mTech.setAnimation(botomAnim);
        mImage.setAnimation(topAnim);
        mHTC.setAnimation(topAnim);
        mWelcome.setAnimation(topAnim);


    }
}