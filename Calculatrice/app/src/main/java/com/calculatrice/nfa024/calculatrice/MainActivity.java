package com.calculatrice.nfa024.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plus(View v){
        EditText nb1=(EditText)this.findViewById(R.id.main_entree1_et);
        EditText nb2=(EditText)this.findViewById(R.id.main_entree2_et);
        String n1= nb1.getText().toString();
        String n2= nb2.getText().toString();

        double a= Double.parseDouble(n1);
        double b= Double.parseDouble(n2);

        double res = a+b;

        ((TextView)this.findViewById(R.id.main_resultat_tv)).setText("Resultat = " + res);
    }

    public void moins(View v){
        EditText nb1=(EditText)this.findViewById(R.id.main_entree1_et);
        EditText nb2=(EditText)this.findViewById(R.id.main_entree2_et);
        String n1= nb1.getText().toString();
        String n2= nb2.getText().toString();

        double a= Double.parseDouble(n1);
        double b= Double.parseDouble(n2);

        double res = a-b;

        ((TextView)this.findViewById(R.id.main_resultat_tv)).setText("Resultat = " + res);
    }

    public void mult(View v){
        EditText nb1=(EditText)this.findViewById(R.id.main_entree1_et);
        EditText nb2=(EditText)this.findViewById(R.id.main_entree2_et);
        String n1= nb1.getText().toString();
        String n2= nb2.getText().toString();

        double a= Double.parseDouble(n1);
        double b= Double.parseDouble(n2);

        double res = a*b;

        ((TextView)this.findViewById(R.id.main_resultat_tv)).setText("Resultat = " + res);
    }

    public void div(View v){
        EditText nb1=(EditText)this.findViewById(R.id.main_entree1_et);
        EditText nb2=(EditText)this.findViewById(R.id.main_entree2_et);
        String n1= nb1.getText().toString();
        String n2= nb2.getText().toString();

        double a= Double.parseDouble(n1);
        double b= Double.parseDouble(n2);

        double res = a/b;

        ((TextView)this.findViewById(R.id.main_resultat_tv)).setText("Resultat = " + res);
    }

    public void reset(View v){
        EditText nb1=(EditText)this.findViewById(R.id.main_entree1_et);
        EditText nb2=(EditText)this.findViewById(R.id.main_entree2_et);
        nb1.setText("");
        nb2.setText("");
    }
}
