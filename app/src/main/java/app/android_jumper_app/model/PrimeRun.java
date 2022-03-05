package app.android_jumper_app.model;

import android.graphics.RectF;
import android.util.Log;

class PrimeRun implements Runnable {
    long minPrime;
    private boolean isDead=false;
    private FenetreDeJeu fdj;

    PrimeRun(long minPrime, FenetreDeJeu fdj) {
        this.minPrime = minPrime;
        this.fdj=fdj;
    }

    @Override
    public void run() {
        while(!isDead){
            try {
                fdj.avanceTuyau();
                if(fdj.t.getX() == -1200){
                    fdj.t.remisAZero(200);
                }
                Log.d("LAJ","JE PASSE LA");

                fdj.bottomPipeRect = new RectF(fdj.t.getX(), fdj.t.getBottomY(), fdj.t.getX() + 10, 50);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("LAJ","PT-THREAD");
        }
    }
}
