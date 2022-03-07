package app.android_jumper_app.model.classe;

public class Jumper {

    private int y;
    private int x;
    private int largeur;
    private int hauteur;
    private boolean EntrainDeSauter;
    private boolean hauteurMax = false;
    private boolean hauteurMin = false;

    public Jumper(float larg, float hat){
        this.x=0;
        this.largeur=(int)larg;
        this.hauteur=(int)hat;
        this.EntrainDeSauter =false;
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

    public boolean isHauteurMax() {
        return hauteurMax;
    }

    public void setHauteurMax(boolean hauteurMax) {
        this.hauteurMax = hauteurMax;
    }

    public boolean isHauteurMin() {
        return hauteurMin;
    }

    public void setHauteurMin(boolean hauteurMin) {
        this.hauteurMin = hauteurMin;
    }

    public void setEntrainDeSauter(boolean entrainDeSauter) {
        this.EntrainDeSauter = entrainDeSauter;
    }

    public boolean isEntrainDeSauter() {
        return EntrainDeSauter;
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
        if(this.getX() == t.getX())
        {
            return true;
        }
        else return false;
    }
}
