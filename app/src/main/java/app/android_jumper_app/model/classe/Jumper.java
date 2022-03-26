package app.android_jumper_app.model.classe;

public class Jumper {

    private int y;
    private int x;

    public Jumper(){

        this.x=0;
    }

    /**
     * Update permet de faire sauter jumper (on update son y)
     * @param dy degré du saut
     */
    public void update (int dy) {
        this.y += dy;
    }

    /**
     * Permet de récupérer son y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Permet de setter le y du jumper (hauteur)
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Permet de récuper le x du jumper (unile seulement quand on lance le jeu pour bien le positionner)
     * @return
     */
    public int getX() {
        return x;
    }
}
