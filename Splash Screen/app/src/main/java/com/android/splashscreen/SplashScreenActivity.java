package com.android.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.splashscreen.MainActivity;
import com.android.splashscreen.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;


    //variables
    Animation topAnim,bottomAnim;
    ImageView splashImage;
    TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.topsplashanimation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottomsplashanimation);

        //Hooks
        splashImage = findViewById(R.id.imagesplash);
        splashText = findViewById(R.id.textsplash);


        splashImage.setAnimation(topAnim);
        splashText.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent openMainActivityFromSplashScreenActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(openMainActivityFromSplashScreenActivity);
                finish();
            }
        },SPLASH_SCREEN);

    }
}
