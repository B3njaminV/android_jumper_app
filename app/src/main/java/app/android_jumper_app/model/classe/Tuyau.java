package app.android_jumper_app.model.classe;

public class Tuyau {

    private int dist;
    private int x;
    private int y;
    private double dx;

    /**
     * Constructeur d'un tuyau
     * @param x coordonné x pour savoir ou positionner le tuyau
     * @param avance niveau d'avance d'un tuyau
     */
    public Tuyau(int x, float avance){
        this.x = x;
        this.y = 0;
        this.dx = avance;
    }

    /**
     * On remet a zero les coordonnées x du tuyau
     * @param valeur
     */
    public void remisAZero(int valeur){
        this.x = valeur;
    }

    /**
     * On fait avance un tuyau (on décrémente son x)
     */
    public void avance(){
        this.x -= dx;
    }

    /**
     * Permet de récupérer la position d'un tuyau (seulement x)
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * On set le tuyau a un x spécifique (pas nécessaire pour l'instant mais utile si on veut étendre le model)
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * On récupére sa hauteur a partir du sol
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * On set le tuyau a un y spécifique
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }
}
