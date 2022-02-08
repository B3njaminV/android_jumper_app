package app.android_jumper_app;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FenetreDeJeu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
        Log.d("LAJ","FJ-onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        ((TextView)findViewById(R.id.textView)).setText("@" + getIntent().getStringExtra("joueur"));

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

        Button buttonClick = (Button) findViewById(R.id.button2);
        buttonClick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){

                    ImageView jumper = (ImageView) findViewById(R.id.imageView);
                    Log.d("LAJ","FJ-JE SAUTE");

                    return true;
                }
                return false;
            }
        });

        Log.d("LAJ","FJ-onStart");
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
