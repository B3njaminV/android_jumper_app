package app.android_jumper_app.model;

public class Jumper {

    public int y;
    public boolean estEnTrainDeSauter=false;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZeroY() {
        this.y = 0;
    }

    public void saut() {
        this.y = -500;
    }

    public void calculCoordonnee(){
        if(!estEnTrainDeSauter) {
            saut();
            estEnTrainDeSauter=true;
        }else {
            setZeroY();
            estEnTrainDeSauter=false;
        }
    }
}
