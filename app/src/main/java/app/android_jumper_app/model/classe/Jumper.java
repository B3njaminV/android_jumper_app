package app.android_jumper_app.model.classe;

public class Jumper {

    private int y;
    private int x;
    public boolean estEnTrainDeSauter=false;
    private int velocityY;

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

    public void setZeroY() {
        this.y = 0;
    }

    public void sauter() {
        this.y = -500;
    }

    public void setEstEnTrainDeSauter(boolean estEnTrainDeSauter) {
        this.estEnTrainDeSauter = estEnTrainDeSauter;
    }

    public boolean isEstEnTrainDeSauter() {
        return estEnTrainDeSauter;
    }

    public void saut() {
        if(!isEstEnTrainDeSauter()) {
            sauter();
            setEstEnTrainDeSauter(true);
        }else {
            setZeroY();
            setEstEnTrainDeSauter(false);
        }
    }
}
