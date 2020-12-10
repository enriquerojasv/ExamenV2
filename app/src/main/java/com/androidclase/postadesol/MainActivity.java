package com.androidclase.postadesol;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView circleIV;
    private FrameLayout skyFL;

    private ObjectAnimator animatorY;

    private long animationDuration = 3000;

    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatorSet = new AnimatorSet();

        circleIV = findViewById(R.id.circleIV);
        skyFL = findViewById(R.id.skyFL);
        skyFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("ejeY");
            }
        });
    }

    private void animacion(String animacion) {
        switch (animacion) {
            case "ejeY":
                animatorY = ObjectAnimator.ofFloat(circleIV, "y", 1100f);
                animatorY.setDuration(animationDuration);
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.play(animatorY);
                animatorSetY.start();
                break;
        }
    }
}