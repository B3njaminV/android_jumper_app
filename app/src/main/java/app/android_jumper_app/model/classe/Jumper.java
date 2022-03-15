package app.android_jumper_app.model.classe;

public class Jumper {

    private int y;
    private int x;

    public Jumper(){

        this.x=0;
    }

    public void update (int dy) {
        this.y += dy;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
}
