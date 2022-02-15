package app.android_jumper_app;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;
public class FenetrePrincipale extends AppCompatActivity {

    public Joueur joueur;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetreprincipale);
        if(savedInstanceState != null){
            ((EditText)findViewById(R.id.editTextTextPersonName)).setText(savedInstanceState.getString("joueur"));

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
        joueur = new Joueur();
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
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LAJ","FP-onDestroy");
    }

    public void click(View view) {
        String nom = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
        if (nom.isEmpty()){
            Snackbar mySnackbar = Snackbar.make(view, "Pseudo Invalide !", 2000);
            mySnackbar.show();
        }else{
            joueur.setPseudo(nom);
            Log.d("LAJ","FP-JOUEUR CREE");
            Intent intent = new Intent(this, FenetreDeJeu.class);
            intent.putExtra("joueur", joueur.getPseudo());
            startActivity(intent);
        }
    }


}