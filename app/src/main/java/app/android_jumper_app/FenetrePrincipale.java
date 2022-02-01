package app.android_jumper_app;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;


public class FenetrePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fenetreprincipale);
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
        Intent intent = new Intent(this, FenetreDeJeu.class);
        startActivity(intent);
    }


}