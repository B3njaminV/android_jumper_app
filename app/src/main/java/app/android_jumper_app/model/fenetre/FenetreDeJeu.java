package app.android_jumper_app.model.fenetre;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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
    private TextView debut;
    private TextView endScore;
    private TextView score;
    public Button endButton;
    public int dy = 0;
    public int millis = 0;
    private final float avance = 10;
    private final int avanceB = 800;
    public int vitesseThread = 8;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
        backgroundOne = findViewById(R.id.background_one);
        backgroundTwo = findViewById(R.id.background_two);
        chateau = findViewById(R.id.chateau);
        tuyau = findViewById(R.id.tuyau);
        jumper = findViewById(R.id.jumper);
        score = findViewById(R.id.points);
        end = findViewById(R.id.end);
        debut = findViewById(R.id.debut);
        endScore = findViewById(R.id.endScore);
        endButton = findViewById(R.id.endButton);
        backgroundOne.setTranslationX(0);
        backgroundTwo.setTranslationX(avanceB);
        endButton.setVisibility(View.GONE);
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
        score.setText(str + " points");
        debut.setText("Tapote pour sauter !");

        p = new PrimeRun(143, this);
        new Thread(p).start();
        j.setY(-400);                   //saut de d??part
        tuyau.setTranslationX(t.getX());
        tuyau.setTranslationY(t.getY());//premier positionnement du tuyau donc a ce niveau x vaut 0
        jumper.setTranslationX(j.getX());       //fixe, jumper ne bougera jamais
        Log.d("LAJ","FJ-onStart");
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(e.getAction() == MotionEvent.ACTION_DOWN && j.getY() >= -500){           //on bloque le saut en hauteur et on v??rifie qu'il y a une action ??cran (click)
                dy = -50;
        }
        Log.d("LAJ","FJ-onTouchEvent");
        return false;
    }

    @Override
    protected void onResume(){
        super.onResume();
        p.isPause = false;
        Log.d("LAJ","FJ-onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        p.isPause = true;
        Log.d("LAJ","FJ-onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LAJ","FJ-onDestroy");
    }

    /**
     * On update la position du joueur (y)
     */
    public void updateJumper(){
        ((ImageView)findViewById(R.id.jumper)).setTranslationY(j.getY());
        j.update(dy);
        if (dy >= 0) {      //on garde jumper toujours au dessus de la terre
            dy = 0;
        }
    }

    /**
     * On update la position du tuyau (x)
     */
    public void updateTuyau(){
        if(t.getX() == -1200){
            t.remisAZero(200);
        }
        t.avance();
        tuyau.setTranslationX(t.getX());
    }

    /**
     * On update le background
     * On fonctionne avec 2 background on fait avancer les 2
     */
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

    /**
     * On update le chateau de d??part
     */
    public void updateChateau(){
        chateau.setX(chateau.getX()-avance);
    }

    /**
     * On ajoute des points a chaque tour de boucle du thread
     */
    public void addPoint(){
        s.addPoint();
    }

    /**
     * On update l'affichage des points
     */
    public void updatePoint(){
        String str = String.valueOf(s.getNbPoint());
        score.setText(str + " points");
    }

    /**
     * Affichage du texte de fin
     */
    public void afficheTextFin(){
        end.setText("Perdu !");
        afficheBoutonDeFin();
        String str = String.valueOf(s.getNbPoint());
        endScore.setText(str + " points");
    }

    /**
     * On g??re la vitesse du thread en fonction du nombre de points
     */
    public void updateAvance(){
        if(s.getNbPoint() == 1000){
            vitesseThread = 7;
        }else if (s.getNbPoint() == 2000){
            vitesseThread = 6;
        }
    }

    /**
     * On v??rifie les contacts entre tuyau et jumper avec leur coordonn??es
     * @return
     */
    public boolean verifContact(){
        if (j.getX() - 480 == t.getX() && j.getY() >= -tuyau.getHeight()){     //si x de jumper vaut x de tuyau et que y de jumper est sup??rieur (ducoup inf??rieur) ?? hauteur de tuyau
            return true;
        }
        return false;
    }

    /**
     * On g??re simplement le textviex de d??part qui explique les consignes de jeu
     */
    public void updateTexteDepart(){
        if(s.getNbPoint() > 100){
            debut.setText("");
        }
    }

    /**
     * On affiche le bouton de fin uniquement si y'a eu contact
     */
    private void afficheBoutonDeFin(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                endButton.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * Si jamais on clique sur le bouton de fin, on reset les param??tres et on restart le thread
     * @param view
     */
    public void onclickButtonDeFin(View view) {
        endButton.setVisibility(View.GONE);
        p.isPause=true;
        end.setText(" ");
        endScore.setText(" ");
        s.resetScore();
        vitesseThread=8;
        p = new PrimeRun(143, this);
        new Thread(p).start();
        j.setY(-400);
    }
}
