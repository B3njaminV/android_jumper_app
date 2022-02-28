package app.android_jumper_app.model;

import java.io.Serializable;

public class Joueur implements Serializable {

    private String pseudo;
    private int highScore;

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
