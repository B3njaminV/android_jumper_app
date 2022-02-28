package  app.android_jumper_app.data;

import java.io.FileOutputStream;
import java.io.Serializable;

public interface Sauveur {

    void save(FileOutputStream fichier, Serializable toSave);
}
