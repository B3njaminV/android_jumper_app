package app.android_jumper_app.model.classe;

public class Tuyau {

    private int dist;
    private int x;
    private double dx;
    private int topY, bottomY;

    public Tuyau(int x, float screenWidth, float screenHeight, float avance){
        dist = (int) (screenHeight/1.1);
        bottomY = (int) Math.floor(Math.random() * (screenHeight/2) + .3 * screenHeight);
        topY = bottomY - dist;
        this.x = x;
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

    public int getTopY() {
        return topY;
    }

    public int getBottomY() {
        return bottomY;
    }
}
