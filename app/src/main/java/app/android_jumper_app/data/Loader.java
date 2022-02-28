package  app.android_jumper_app.data;

import java.io.FileInputStream;

public interface Loader {

    Object load(FileInputStream fichier);
}
