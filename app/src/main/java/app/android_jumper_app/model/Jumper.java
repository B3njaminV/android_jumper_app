package app.android_jumper_app.model;

import android.util.Log;

public class Jumper {

    private int y;
    private int x;
    private int largeur;
    private int hauteur;

    public Jumper(float larg, float hat){
        this.x=0;
        this.largeur=(int)larg;
        this.hauteur=(int)hat;
    }
    public boolean estEnTrainDeSauter=false;

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

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
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

    public boolean contactTuyau(Tuyau t){
        if(this.getX() + this.getLargeur() < t.getX() || this.getX() + this.getLargeur() > t.getX() + 21.50)
        {
            return false;
        }
        else return true;
    }
}
