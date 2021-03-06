package com.example.withmybag.outils;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe qui permet de serialiser et deserialiser des Objets
 *
 */
public abstract class Serializer {

    /**
     * Serialisation d'un objet : mémoriser un objet dans un fichier binaire
     * @param filename: dans  ce fichier on serilaise l'objet "object"
     * @param object  : l'objet à sérilaiser
     * @param context : il s'agit de  l'activity en cours
     */
    public static void serialize(String filename, Object object, Context context){

        try {

            FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos;

            try {
                oos = new ObjectOutputStream(file);
                oos.writeObject(object);
                oos.flush();
                oos.close();
            } catch (IOException e) {

                // erreur de serialisation

                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {

            // Fichier non trouvé

            e.printStackTrace();
        }


    }

    /**
     * Permet de récupérer un Objet à partir d'un fichier binaire
     * précedemment sérilaisé
     * @param filename
     * @param context
     * @return
     */
    public static Object deSerialize(String filename, Context context){


        try {
            FileInputStream file = context.openFileInput(filename);
            ObjectInputStream ois;

            try {
                ois = new ObjectInputStream(file);

                try {
                    Object object = ois.readObject();
                    ois.close();
                    return object;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

}
