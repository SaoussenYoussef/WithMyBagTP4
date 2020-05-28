package com.example.withmybag.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withmybag.R;
import com.example.withmybag.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    //propriétés
    private EditText edTxtName;
    private EditText edTxtEmail;
    private EditText edTxtPhone;

    private TextView txtViewWelcomeTxt;
    private ImageView imgSmiley;

    private Controle controle;

    /*String name = ""; // nom du client
    String email = ""; // emal du client
    String phone =""; // numero de telephone*/

    /**
     * Initialisation des liens avec les objets graphiques
     */
    private void init(){

        edTxtName = findViewById(R.id.edTxtName);
        edTxtEmail = findViewById(R.id.edTxtEmail) ;
        edTxtPhone = findViewById(R.id.edTxtPhone);

        txtViewWelcomeTxt = findViewById(R.id.txtViewWelcomeTxt);
        imgSmiley = findViewById(R.id.imgSmiley);
        this.controle = Controle.getInstance();
        ecouteConnexion();

    }

    /**
     * Ecoute évènement sur Bouton Connexion/Inscription
     */
    private void ecouteConnexion(){

        findViewById(R.id.BtnConnexion).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
                Log.d("mesage", "clic OK sur le bouton Connexion ********************");

                String name = ""; // nom du client
                String email = ""; // emal du client
                String phone = ""; // numero de telephone

                Log.d("mesage", "Initialisation des varaibles ********************");

                /**
                 * Eviter un arrêt brutal du programme
                 */
                try {
                    name = edTxtName.getText().toString();
                    email = edTxtEmail.getText().toString();
                    phone = edTxtPhone.getText().toString();

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Saisie incorrecte", Toast.LENGTH_SHORT).show();

                }

                // Message affiché si saisie incorrecte

                if ( name == "" || email == "" || phone == "") {
                    Toast.makeText(MainActivity.this, "saisie incorrecte", Toast.LENGTH_SHORT).show();}
                else {

                    Log.d("mesage", "Affichage des variables ********************");
                    afficheInfosClient(name, email, phone);

                }


            }
        });
    }

    /**
     * Affichage des informations du client/ou utilisateur qui vient de se connecter
     * et du message correspondant : Client reconnu ou non
     * @param name nome du client
     * @param email adresse mail du client
     * @param phone numéro de téléphone sur lequel l'application est téléchargée
     */
    private void afficheInfosClient(String name, String email, String phone){

        // création du client  potenteil et récupération des
        // informations qu'il vient de saisir
        this.controle.creerClient(name, email, phone);

        name = this.controle.getName();
        email = this.controle.getEmail();
        phone = this.controle.getPhone();
        String message = this.controle.getMessage();
        // affichage du message
        if (message.equals("Bonjour, ") ){

                imgSmiley.setImageResource(R.drawable.bravo_dejainscrit);
                txtViewWelcomeTxt.setText(message + " " + name);}
        else{
                imgSmiley.setImageResource(R.drawable.erreurinconnu);
                txtViewWelcomeTxt.setText(message + "" + name);
        }

    }

}
