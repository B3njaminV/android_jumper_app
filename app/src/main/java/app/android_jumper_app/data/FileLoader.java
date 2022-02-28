package  app.android_jumper_app.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FileLoader implements Loader {
    @Nullable
    @Override
    public Serializable load(@NonNull FileInputStream fichier) {
        Serializable retour = null;
        try (ObjectInputStream ois = new ObjectInputStream(fichier)) {
            retour  = (Serializable) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retour;
    }
}
