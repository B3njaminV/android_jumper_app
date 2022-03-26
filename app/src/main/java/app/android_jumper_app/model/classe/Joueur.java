package app.android_jumper_app.model.classe;

import java.io.Serializable;

public class Joueur implements Serializable {

    private String pseudo;
    private int highScore;

    /**
     * Permet de récupérer le pseudo du joueur
     * @return String
     */
    public String getPseudo(){
        return this.pseudo;
    }

    /**
     * Permet de setter le pseudo du joueur
     * @param pseudo String
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Permet de récupérer le meilleur score du joueur (seulement quand le jeu est ouvert)
     * @return int
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * Permet de setter le highscore
     * @param highScore int
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
