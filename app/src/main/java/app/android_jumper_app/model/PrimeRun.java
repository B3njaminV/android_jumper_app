package app.android_jumper_app.model;

import android.util.Log;

class PrimeRun implements Runnable {
    long minPrime;
    PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        Log.d("LAJ","PT-THREAD");
    }
}
