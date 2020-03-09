package com.tp5.nfa024.cnam.carnetadresses;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mariasoage on 28/4/17.
 */

public class CreationActivity extends Activity {

    MaBaseDeDonnees data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.creation);
        this.data = new MaBaseDeDonnees(this);
    }

    public void enregistrer(final View v){
        Toast.makeText(this, R.string.toast_enregistrer_txt, Toast.LENGTH_SHORT).show();
        final EditText nom = (EditText)this.findViewById(R.id.creation_nom_et);
        final EditText prenom = (EditText)this.findViewById(R.id.creation_prenom_et);
        final EditText telephone = (EditText)this.findViewById(R.id.creation_telephone_et);
        final EditText email = (EditText)this.findViewById(R.id.creation_email_et);

        Personne p = new Personne(
                nom.getText().toString(),
                prenom.getText().toString(),
                telephone.getText().toString(),
                email.getText().toString()
        );
        this.data.enregistrer(p);
        Toast.makeText(this, p.toString(),Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
