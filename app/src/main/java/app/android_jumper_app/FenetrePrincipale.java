package app.android_jumper_app;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


public class FenetrePrincipale extends AppCompatActivity {

    public Joueur joueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetreprincipale);
        joueur = new Joueur();
        if(savedInstanceState != null){
            ((EditText)findViewById(R.id.editTextTextPersonName)).setText(savedInstanceState.getString("joueur"));
            Log.d("LOGAPPJUMPER","JOUEUR BIEN RECUPERE");
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LOGAPPJUMPER","onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LOGAPPJUMPER","onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LOGAPPJUMPER","onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LOGAPPJUMPER","onDestroy");
    }

    public void click(View view) {
        String nom = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
        joueur.setPseudo(nom);
        Log.d("LOGAPPJUMPER","JOUEUR CREE");
        Intent intent = new Intent(this, FenetreDeJeu.class);
        startActivity(intent);
    }


}