package iut.paci.classroomcommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextView connexionText;
    Button connexionButton;
    EditText login;
    EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connexionText = (TextView) findViewById(R.id.connexionText);
        connexionText.setText("Veuillez vous connecter");




        connexionButton = (Button) findViewById(R.id.connexionButton);

    }

    public void func(View v){
        Log.i("tag", "Bouton cliqué !!");

        login = (EditText) findViewById(R.id.login) ;
        mdp = (EditText) findViewById(R.id.mdp) ;
        Log.i("login", login.getText().toString());
        Log.i("mdp", mdp.getText().toString());

        Personne.addPersonne();
        ArrayList<Personne> personnes = Personne.getPersonnes();

        for (Personne unePersonne : personnes){

            if(login.getText().toString().equalsIgnoreCase(unePersonne.getLogin()) &&
                    mdp.getText().toString().equalsIgnoreCase(unePersonne.getMdp())){

                Intent intent = new Intent(this, MainActivity.class);
                Bundle paquet = new Bundle();
                paquet.putString("login", login.getText().toString());
                paquet.putString("mdp", mdp.getText().toString());
                intent.putExtras(paquet);

                startActivity(intent);
            }

        }

    }
}
