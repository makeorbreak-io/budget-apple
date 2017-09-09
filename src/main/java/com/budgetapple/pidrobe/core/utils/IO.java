package com.budgetapple.pidrobe.core.utils;

import java.io.*;

/**
 * Created by Miguel Cardoso on 08/09/2017.
 */
public class IO {

    public static void writeToBinFile(String fileName, Object object) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(object);
        oos.close();
    }

    public static Object readBinFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectinputstream = null;
        Object object = null;

        try {
            //Get path
            File currDir = new File(fileName);
            String path = currDir.getAbsolutePath();

            FileInputStream streamIn = new FileInputStream(path);
            objectinputstream = new ObjectInputStream(streamIn);
            object = objectinputstream.readObject();
        } finally {
            if (objectinputstream != null) {
                objectinputstream.close();
            }
        }

        return object;
    }
}
