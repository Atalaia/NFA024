package com.tp5.nfa024.cnam.carnetadresses;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mariasoage on 28/4/17.
 */

class Personne
{
    private final String nom;
    private final String prenom;
    private final String telephone;
    private final String email;

    public Personne(final String nom,
                    final String prenom,
                    final String telephone,
                    final String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
    }
    public String getNom(){
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString(){
        return this.nom+" "+this.prenom+" : "+this.telephone+" ("+this.email+") ";
    }

}


public class MaBaseDeDonnees extends SQLiteOpenHelper
{
    public static final String DB_NAME = "contact.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "Personnes";

    public MaBaseDeDonnees(final Context act){
        super(act,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE + "(id INTEGER PRIMARY KEY AUTOINCREMENT"
                + ",Nom TEXT NOT NULL"
                +",Prenom TEXT NOT NULL"
                +",Telephone TEXT NOT NULL"
                + ",email TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int current, int old){
        db.execSQL("DROP TABLE " + TABLE + ";");
        this.onCreate(db);
    }

    void enregistrer(final Personne p){
        final SQLiteDatabase db = this.getWritableDatabase();
        final ContentValues content = new ContentValues();
        content.put("Nom", p.getNom());
        content.put("Prenom", p.getPrenom());
        content.put("Telephone", p.getTelephone());
        content.put("Email", p.getEmail());
        db.insertOrThrow(TABLE, null, content);
    }

}
