package  app.android_jumper_app.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileSaver implements Sauveur {
    @Override
    public void save(FileOutputStream fichier, Serializable toSave) {
        try (ObjectOutputStream oos = new ObjectOutputStream(fichier)) {
            oos.writeObject(toSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
