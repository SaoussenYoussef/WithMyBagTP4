package com.example.withmybag.controleur;

import android.content.Context;

import com.example.withmybag.modele.Client;
import com.example.withmybag.outils.Serializer;
import com.example.withmybag.vue.MainActivity;

/**
 * classe permettant de gérer les données et mettre à jour les affichages en
 * fonction des données saises ou récupérées
 * L'instance du controleur doit toujours être unique : Singleton
 */
public final class Controle {

    private static Controle instance = null;
    private static Client client;
    private static String nomFic = "save_client";


    /**
     * Constructuer privé
     */
    private Controle(){

        super();
    }

    public static final Controle getInstance(Context contexte){

        if (Controle.instance == null){
            Controle.instance = new Controle();
            recupSerialize(contexte);
        }
        return Controle.instance;
    }

    /**
     * Création du client
     * @param name nom du client
     * @param email  adresse email du client qui sera son id
     * @param phone  numéro du téléphone physique à partir
     * @param contexte
     */
    public void creerClient(String name, String email, String phone,Context contexte){

        client = new Client(name, email, phone);
        Serializer.serialize(nomFic, client, contexte);
    }


    /**
     *
     * @return le nom du client
     */
    public String getName(){
        if (client == null) return null;
        return client.getName();
    }

    /**
     *
     * @return l'email du client
     */
    public String getEmail(){
        if(client == null) return null;
        return client.getEmail();
    }

    /**
     *
     * @return le numéro de téléphone saisi
     */
    public String getPhone(){
        if(client == null) return null;
        return client.getPhone();
    }

    /**
     * Récupération du message destiné au Client
     * @return message
     */
    public String getMessage(){
        if(client == null) return null;
        return client.getMsg();
    }

    /**
     * Récupération de l'objet sérialisé (Le client)
     * @param contexte permet de récupérer
     * les données serialisées lors de l'inscription
     */
    private static void recupSerialize(Context contexte){

        client = (Client) Serializer.deSerialize(nomFic, contexte);
    }


}
