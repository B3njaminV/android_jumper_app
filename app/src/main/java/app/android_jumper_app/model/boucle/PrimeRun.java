package app.android_jumper_app.model.boucle;
import android.util.Log;

import app.android_jumper_app.model.fenetre.FenetreDeJeu;

public class PrimeRun implements Runnable {
    long minPrime;
    private boolean isDead=false;
    private final FenetreDeJeu fdj;

    public PrimeRun(long minPrime, FenetreDeJeu fdj) {
        this.minPrime = minPrime;
        this.fdj=fdj;
    }

    @Override
    public void run() {
        while(!isDead){
            try {
                fdj.updateAvance();
                fdj.addPoint();
                fdj.updateTuyau();
                fdj.updateBackground();
                fdj.updateChateau();
                fdj.updatePoint();
                if(fdj.verifContact()){
                    Log.d("LAJ","J-CONTACT !!!!!!!!");
                    isDead=true;
                    fdj.afficheTextFin();
                }
                Thread.sleep(fdj.vitesseThread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("LAJ","PT-THREAD");
        }
    }
}
