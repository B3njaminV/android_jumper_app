package app.android_jumper_app.model;

public class Tuyau {

    private int x;

    public Tuyau(int x){
        this.x = x;
    }

    public void remisAZero(int valeur){
        this.x = valeur;
    }

    public void avance() {
        this.x = this.x-5;
    }

}
