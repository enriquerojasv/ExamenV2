package com.androidclase.postadesol;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
                animacion(skyFL);
                startColorAnimation(skyFL);
            }
        });
    }

    private void startColorAnimation(View v) {
        int colorStart = 0xFF217FD3;
        int color2 = 0xFF9E8D84;
        int color3 = 0xFFF2A523;
        int colorEnd = 0xFF000000;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v, "backgroundColor", colorStart, color2, color3, colorEnd);

        colorAnim.setDuration(animationDuration+1500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }

    private void animacion(FrameLayout skyFL) {
        animatorY = ObjectAnimator.ofFloat(circleIV, "y", 1100f);
        animatorY.setDuration(animationDuration);
        AnimatorSet animatorSetY = new AnimatorSet();
        animatorSetY.play(animatorY);
        animatorSetY.start();
    }
}
