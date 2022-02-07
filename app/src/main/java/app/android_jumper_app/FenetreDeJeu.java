package app.android_jumper_app;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        ((TextView)findViewById(R.id.textView)).setText("Salut " + getIntent().getStringExtra("joueur"));
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
