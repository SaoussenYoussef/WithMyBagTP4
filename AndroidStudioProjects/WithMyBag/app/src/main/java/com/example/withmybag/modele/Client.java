package com.example.withmybag.modele;

import android.media.Image;

public class Client {

    // propriétés
    private String name; // nom du client
    private String email; // emal du client
    private String phone; // numero de telephone

    private String msg; // message de retour pour dire Bienvenue ou,
                            // il faut s'inscrire


    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.affichMessage();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMsg() {
        return msg;
    }

    private void affichMessage(){

        if (name.equals("Eric") || (name.equals("Ahmed"))){

            msg = "Bonjour, ";
        } else{
            msg = "Veuillez vous inscrire, " ;
        }
    }
}
