package app.android_jumper_app.model;

import android.util.Log;

class PrimeRun implements Runnable {
    long minPrime;
    private boolean isDead=false;

    PrimeRun(long minPrime, Tuyau t) {
        this.minPrime = minPrime;
    }

    public void run() {
        while(!false){
            try {
                //t.avance();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("LAJ","PT-THREAD");
        }
    }
}
