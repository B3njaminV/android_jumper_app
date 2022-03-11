package app.android_jumper_app.model.classe;

public class Jumper {

    private int y;
    private int x;
    public boolean estEnTrainDeSauter=false;

    public Jumper(){

        this.x=0;
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
