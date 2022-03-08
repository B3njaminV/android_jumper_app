package app.android_jumper_app.model.fenetre;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.android_jumper_app.R;
import app.android_jumper_app.model.classe.Jumper;
import app.android_jumper_app.model.boucle.PrimeRun;
import app.android_jumper_app.model.classe.Score;
import app.android_jumper_app.model.classe.Tuyau;

public class FenetreDeJeu extends AppCompatActivity {

    public PrimeRun p;
    public Tuyau t;
    public Jumper j;
    private Score s;
    public ImageView tuyau;
    public ImageView jumper;
    private ImageView backgroundOne;
    private ImageView backgroundTwo;
    private ImageView chateau;
    private TextView end;
    private TextView endScore;
    private TextView score;
    private Button endButton;
    private float largeurEcran;
    private float hauteurEcran;
    private float largeurJumper;
    private float hauteurJumper;
    private final float avance = 10;
    private final int avanceB = 800;
    public int vitesseThread = 8;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
        backgroundOne = (ImageView) findViewById(R.id.background_one);
        backgroundTwo = (ImageView) findViewById(R.id.background_two);
        chateau = (ImageView) findViewById(R.id.chateau);
        tuyau = (ImageView) findViewById(R.id.tuyau);
        jumper = (ImageView) findViewById(R.id.jumper);
        score = (TextView)findViewById(R.id.points);
        end = (TextView) findViewById(R.id.end);
        endScore = (TextView) findViewById(R.id.endScore);
        endButton = (Button) findViewById(R.id.endButton);
        largeurEcran = backgroundOne.getWidth();
        hauteurEcran = backgroundOne.getHeight();
        largeurJumper = jumper.getWidth();
        hauteurJumper = jumper.getHeight();
        backgroundOne.setTranslationX(0);
        backgroundTwo.setTranslationX(avanceB);
        endButton.setVisibility(endButton.GONE);
        Log.d("LAJ","FJ-onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();

        t = new Tuyau(800, avance);
        j = new Jumper();
        s = new Score();

        ((TextView)findViewById(R.id.textView)).setText("@" + getIntent().getStringExtra("joueur_pseudo"));
        String str = String.valueOf(s.getNbPoint());
        score.setText(str + " points !");

        p = new PrimeRun(143, this);
        new Thread(p).start();

        tuyau.setTranslationX(t.getX());
        tuyau.setTranslationY(t.getY());//premier positionnement du tuyau donc a ce niveau x vaut 0
        jumper.setTranslationX(j.getX());       //fixe, jumper ne bougera jamais
        Log.d("LAJ","FJ-onStart");
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                j.calculCoordonnee();
                ((ImageView)findViewById(R.id.jumper)).setTranslationY(j.getY());
        }
        Log.d("LAJ","FJ-onTouchEvent");
        return false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        s = new Score();
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

    public void updateChateau(){
        chateau.setX(chateau.getX()-avance);
    }

    public void addPoint(){
        s.addPoint();
    }

    public void updatePoint(){
        String str = String.valueOf(s.getNbPoint());
        score.setText(str + " points !");
    }

    public void afficheTextFin(){
        end.setText("Perdu !");
        //endButton.setVisibility(endButton.VISIBLE);
        String str = String.valueOf(s.getNbPoint());
        endScore.setText(str + " points !");
    }

    public void updateAvance(){
        switch(s.getNbPoint()){
            case 2000:
                vitesseThread = 6;
        }
    }

    public boolean verifContact(){
        return false;
    }
}
