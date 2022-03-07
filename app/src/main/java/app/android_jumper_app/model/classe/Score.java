package app.android_jumper_app.model.classe;

import java.io.Serializable;

public class Score implements Serializable {

    private int nbPoints;

    /**
     * Un score est définit seulement par un nombre de points
     */
    public Score(){}

    /**
     * On retourne le nombre de points
     */
    public int getNbPoint(){
        return this.nbPoints;
    }

    /**
     * On définit le nombre de points
     */
    public void setNbPoint(int nb){
        this.nbPoints=nb;
    }

    /**
     * On ajoute des points de 1 en 1 (pour le score dans la boucle du jeu)
     */
    public void addPoint(){
        this.nbPoints++;
    }

    /**
     * On remet à 0 le score (quand on relance une partie)
     */
    public void remisAZreo(){
        this.nbPoints=0;
    }

}
