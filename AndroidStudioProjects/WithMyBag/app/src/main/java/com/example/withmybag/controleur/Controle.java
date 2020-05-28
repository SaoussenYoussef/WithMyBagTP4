package com.example.withmybag.controleur;

import com.example.withmybag.modele.Client;

/**
 * classe permettant de gérer les données et les affichages
 * L'instance du controleur doit toujours être unique : Singleton
 */
public final class Controle {

    private static Controle instance = null;
    private Client client;


    /**
     * Constructuer privé
     */
    private Controle(){

        super();
    }

    public static final Controle getInstance(){

        if (Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Création du client
     * @param name nom du client
     * @param email  adresse email du client qui sera son id
     * @param phone  numéro du téléphone physique à partir
     *               duquel le client se connecte
     */
    public void creerClient(String name, String email, String phone){

        client = new Client(name, email, phone);
    }


    /**
     *
     * @return le nom du client
     */
    public String getName(){
        return client.getName();
    }

    /**
     *
     * @return l'emil du client
     */
    public String getEmail(){

        return client.getEmail();
    }

    /**
     *
     * @return le numéro de téléphone saisi
     */
    public String getPhone(){
        return client.getPhone();
    }

    /**
     * Récupération du message destiné au Client
     * @return message
     */
    public String getMessage(){

        return client.getMsg();
    }
}
