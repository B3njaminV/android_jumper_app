package app.android_jumper_app;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FenetreDeJeu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetredejeu);
    }

    @Override
    protected void onStart(){
        super.onStart();
        //String nom = ((TextView)findViewById(R.id.textView)).setText());

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        Log.d("LOGAPPJUMPER","ONSAVEINSTANCESTATE");
        //outState.putString("joueur", joueur.getPseudo());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState){
        Log.d("LOGAPPJUMPER","ONRESTOREINSTANCESTATE");
        //joueur.setPseudo(saveInstanceState.getString("joueur"));
        super.onRestoreInstanceState(saveInstanceState);
    }

}
