package app.android_jumper_app.model;

public class Tuyau {

    private int largeur;
    private int hauteur;
    private int x;
    protected int y;

    public Tuyau(int x, int y, int larg, int haut){
        this.x = x;
        this.y = y;
        this.largeur = larg;
        this.hauteur = haut;
    }

    /**
     * Remettre position x à 0
     */
    public void remisAZero(int valeur){
        this.x = valeur;
    }

    /**
     * Faire avancer un élément de 5
     */
    public void avance() {
        this.x = this.x-5;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
