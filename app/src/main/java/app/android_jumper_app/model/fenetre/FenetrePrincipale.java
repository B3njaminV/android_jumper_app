package app.android_jumper_app.model.fenetre;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.snackbar.Snackbar;
import java.io.FileNotFoundException;
import app.android_jumper_app.data.FileLoader;
import app.android_jumper_app.data.FileSaver;
import app.android_jumper_app.data.Loader;
import app.android_jumper_app.data.Sauveur;
import app.android_jumper_app.R;
import app.android_jumper_app.model.classe.Joueur;

public class FenetrePrincipale extends AppCompatActivity {

    public Joueur joueur;
    private Sauveur leSauveur = new FileSaver();
    private Loader leLoader;
    public static final String LA_PERSISTANCE = "joueur";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetreprincipale);
        leLoader = new FileLoader();
        try {
            joueur = (Joueur) leLoader.load(openFileInput(LA_PERSISTANCE));
            Log.d("LAJ", "FP-joueur recup");
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "AUCUNE RECUPERATION");
        }
        Log.d("LAJ","FP-onCreate");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        Log.d("LAJ","FP-ONSAVEINSTANCESTATE");
        outState.putString("joueur", joueur.getPseudo());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState){
        Log.d("LAJ","FJ-ONRESTOREINSTANCESTATE");
        joueur.setPseudo(saveInstanceState.getString("joueur"));
        super.onRestoreInstanceState(saveInstanceState);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (joueur != null){
            ((EditText)findViewById(R.id.editTextTextPersonName)).setText(joueur.getPseudo());
        }else{
            joueur = new Joueur();
        }
        Log.d("LAJ","FP-onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LAJ","FP-onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LAJ","FP-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            leSauveur.save(openFileOutput(LA_PERSISTANCE, MODE_PRIVATE), joueur);
            Log.d("LAJ", "FP-joueur sauv");
        } catch (FileNotFoundException e) {
            Log.e(getPackageName(), "SAUVERGARDE IMPOSSIBLE");
        }
        Log.d("LAJ", "FP-onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LAJ","FP-onDestroy");
    }

    public void click(View view) {
        String nom = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
        if (nom.isEmpty()){
            Snackbar mySnackbar = Snackbar.make(view, "Merci d'entrer un pseudo valide !", Snackbar.LENGTH_LONG);
            View v = mySnackbar.getView();
            FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)v.getLayoutParams();
            params.gravity = Gravity.TOP;
            v.setLayoutParams(params);
            mySnackbar.show();
        }else{
            joueur.setPseudo(nom);
            joueur.setHighScore(200);
            Log.d("LAJ","FP-JOUEUR CREE");
            Intent intent = new Intent(this, FenetreDeJeu.class);
            intent.putExtra("joueur_pseudo", joueur.getPseudo());
            intent.putExtra("joueur_score", String.valueOf(joueur.getHighScore()));
            startActivity(intent);
        }
    }
}