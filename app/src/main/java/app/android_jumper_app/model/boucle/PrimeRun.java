package app.android_jumper_app.model.boucle;
import android.util.Log;
import android.view.View;

import app.android_jumper_app.model.fenetre.FenetreDeJeu;

public class PrimeRun implements Runnable {
    long minPrime;
    public boolean isPause=false;
    private final FenetreDeJeu fdj;

    public PrimeRun(long minPrime, FenetreDeJeu fdj) {
        this.minPrime = minPrime;
        this.fdj=fdj;
    }

    @Override
    public void run() {
        while(!isPause){
            try {
                if (fdj.millis >= 20 && fdj.millis % 2 == 0 && fdj.j.getY() < 0){
                    fdj.dy += 15;                                                       //on ramène jumper a 0 y en permanence
                }
                fdj.addPoint();
                fdj.updateJumper();
                fdj.updateTuyau();
                fdj.updateBackground();
                fdj.updateChateau();
                fdj.updatePoint();
                fdj.updateAvance();
                if(fdj.verifContact()){
                    Log.d("LAJ","J-CONTACT !!!!!!!!");
                    isPause=true;
                    fdj.afficheTextFin();
                }
                fdj.millis++;
                Thread.sleep(fdj.vitesseThread);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("LAJ","PT-THREAD");
        }
    }
}
