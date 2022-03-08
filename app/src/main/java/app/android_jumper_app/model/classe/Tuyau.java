package app.android_jumper_app.model.classe;

public class Tuyau {

    private int dist;
    private int x;
    private int y;
    private double dx;

    public Tuyau(int x, float avance){
        this.x = x;
        this.y = 0;
        this.dx = avance;
    }

    public void remisAZero(int valeur){
        this.x = valeur;
    }

    public void avance(){
        this.x -= dx;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
