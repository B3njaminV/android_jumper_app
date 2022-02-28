package app.android_jumper_app.model;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.android_jumper_app.R;

public class FenetreDeJeu extends AppCompatActivity {

    public PrimeRun p;
    private boolean enTrainDeSauter=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
        Log.d("LAJ","FJ-onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        ((TextView)findViewById(R.id.textView)).setText("@" + getIntent().getStringExtra("joueur_pseudo"));
        ((TextView)findViewById(R.id.points)).setText(getIntent().getStringExtra("joueur_score"));
        animationFond();
        //p = new PrimeRun(143);
        new Thread(p).start();
        Log.d("LAJ","FJ-onStart");
    }

    public void animationFond(){
        final ImageView backgroundOne = (ImageView) findViewById(R.id.background_one);
        final ImageView backgroundTwo = (ImageView) findViewById(R.id.background_two);

        final ValueAnimator animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = backgroundOne.getWidth();
                final float translationX = width * progress;
                backgroundOne.setTranslationX(translationX);
                backgroundTwo.setTranslationX(translationX - width);
            }
        });
        animator.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(enTrainDeSauter == false){
                    enTrainDeSauter=true;
                    ((ImageView)findViewById(R.id.imageView)).setTranslationY(-500);
                }else{
                    ((ImageView)findViewById(R.id.imageView)).setTranslationY(0);
                    enTrainDeSauter=false;
                }
        }
        Log.d("LAJ","FJ-onTouchEvent");
        return false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LAJ","FJ-onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LAJ","FJ-onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LAJ","FJ-onDestroy");
    }

}
