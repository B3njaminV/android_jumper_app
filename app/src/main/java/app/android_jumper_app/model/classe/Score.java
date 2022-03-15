package app.android_jumper_app.model.classe;

import java.io.Serializable;

public class Score implements Serializable {

    private int nbPoints;

    /**
     * On retourne le nombre de points
     */
    public int getNbPoint(){
        return this.nbPoints;
    }

    /**
     * On ajoute un point au score
     */
    public void addPoint(){
        this.nbPoints++;
    }

}
