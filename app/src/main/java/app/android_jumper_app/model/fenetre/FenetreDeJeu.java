package app.android_jumper_app.model.fenetre;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
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
    private TextView endScore;
    private TextView score;
    private Button endButton;
    private float largeurEcran;
    private float hauteurEcran;
    private float largeurJumper;
    private float hauteurJumper;
    private Bitmap bitmapJumper;
    private Bitmap bitmapTuyau;
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
        bitmapJumper = getViewBitmap(jumper);
        bitmapTuyau = getViewBitmap(tuyau);

        Rect bounds1 = new Rect(j.getX(), j.getY(), j.getX() + bitmapJumper.getWidth(), j.getY() + bitmapJumper.getHeight());
        Rect bounds2 = new Rect(t.getX(), t.getY(), t.getX() + bitmapTuyau.getWidth(), t.getY() + bitmapTuyau.getHeight());

        if (Rect.intersects(bounds1, bounds2)) {
            Rect collisionBounds = getCollisionBounds(bounds1, bounds2);
            for (int i = collisionBounds.left; i < collisionBounds.right; i++) {
                for (int l = collisionBounds.top; l < collisionBounds.bottom; l++) {
                    int bitmap1Pixel = bitmapJumper.getPixel(i - j.getX(), l - j.getY());
                    int bitmap2Pixel = bitmapTuyau.getPixel(i - t.getX(), l - t.getY());
                    if (isFilled(bitmap1Pixel) && isFilled(bitmap2Pixel)) {
                        bitmapJumper.recycle();
                        bitmapJumper = null;
                        bitmapTuyau.recycle();
                        bitmapTuyau = null;
                        return true;
                    }
                }
            }
        }
        bitmapJumper.recycle();
        bitmapJumper = null;
        bitmapTuyau.recycle();
        bitmapTuyau = null;
        return false;
    }

    private static Bitmap getViewBitmap(View v) {
        if (v.getMeasuredHeight() <= 0) {
            int specWidth = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            v.measure(specWidth, specWidth);
            Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(b);
            v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
            v.draw(c);
            return b;
        }
        Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }

    private static Rect getCollisionBounds(Rect rect1, Rect rect2) {
        int left = Math.max(rect1.left, rect2.left);
        int top = Math.max(rect1.top, rect2.top);
        int right = Math.min(rect1.right, rect2.right);
        int bottom = Math.min(rect1.bottom, rect2.bottom);
        return new Rect(left, top, right, bottom);
    }

    private static boolean isFilled(int pixel) {
        return pixel != Color.RED;
    }
}
