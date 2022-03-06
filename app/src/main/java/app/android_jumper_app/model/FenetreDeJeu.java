package app.android_jumper_app.model;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.android_jumper_app.R;

public class FenetreDeJeu extends AppCompatActivity {

    public PrimeRun p;
    public Tuyau t;
    public Jumper j;
    public RectF spriteRect = new RectF();
    public RectF bottomPipeRect = new RectF();
    private ImageView tuyau;
    private ImageView backgroundOne;
    private ImageView backgroundTwo;
    private float largeurEcran;
    private float hauteurEcran;
    private float avance = 10;
    private final int avanceB = 800;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
        backgroundOne = (ImageView) findViewById(R.id.background_one);
        backgroundTwo = (ImageView) findViewById(R.id.background_two);
        largeurEcran = backgroundOne.getWidth();
        hauteurEcran = backgroundOne.getHeight();
        backgroundOne.setTranslationX(0);
        backgroundTwo.setTranslationX(avanceB);
        Log.d("LAJ","FJ-onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        ((TextView)findViewById(R.id.textView)).setText("@" + getIntent().getStringExtra("joueur_pseudo"));
        ((TextView)findViewById(R.id.points)).setText("200 points");

        tuyau = (ImageView) findViewById(R.id.tuyau);

        //animationFond();
        t = new Tuyau(0, largeurEcran, hauteurEcran, avance);
        j = new Jumper();
        p = new PrimeRun(143, this);
        new Thread(p).start();
        tuyau.setTranslationX(t.getX());
        Log.d("LAJ","FJ-onStart");
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                j.calculCoordonnee();
                ((ImageView)findViewById(R.id.imageView)).setTranslationY(j.getY());
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

    public void updateTuyau(){
        if(t.getX() == -1200){
            t.remisAZero(200);
        }
        t.avance();
        tuyau.setTranslationX(t.getX());
    }

    public void updateBackground() {
        if (backgroundOne.getX() == -avanceB)
        {
            backgroundOne.setX(avanceB);
        }
        backgroundOne.setX(backgroundOne.getX()-avance);
        if (backgroundTwo.getX() == -avanceB)
        {
            backgroundTwo.setX(avanceB);
        }
        backgroundTwo.setX(backgroundTwo.getX()-avance);
    }

}
