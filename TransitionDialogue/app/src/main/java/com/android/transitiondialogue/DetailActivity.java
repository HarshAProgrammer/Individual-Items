package com.android.transitiondialogue;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {
    TextView productDescription;
    ImageView productImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setTransitionDialogue();

    }

    private void setTransitionDialogue() {
        final TransitionDialogue transitionDialogue = new TransitionDialogue(DetailActivity.this);
        transitionDialogue.startTransitionDialogue();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                transitionDialogue.dismissDialogue();
            }
        }, 2000);
    }



}
