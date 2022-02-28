package app.android_jumper_app.model;

import java.io.Serializable;

public class Joueur implements Serializable {

    private String pseudo;

    public String getPseudo(){
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
