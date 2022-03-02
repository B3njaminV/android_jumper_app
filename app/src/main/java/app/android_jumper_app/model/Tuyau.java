package app.android_jumper_app.model;

public class Tuyau {

    private int x;
    private double dx;

    public Tuyau(int x, float screenWidth){
        this.x = x;
        this.dx = .014 * screenWidth;
    }

    public void remisAZero(int valeur){
        this.x = valeur;
    }

    public void avance(){ this.x -= dx;}
}
