package com.example.zxn.notreparcvert;

/**
 * Created by xuening on 14/11/19.
 */
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {
    private SQLiteDatabase bd;

    public BD(Context ctx) {
        super(ctx, "Problemels.bd", null, 1);
        bd = getWritableDatabase();
    }

    // � garder pour les deux versions
    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // ces deux fonctions (onCreate et onUpgrade) sont � garder absolument ici
    // (h�ritage de SQLiteOpenHelper)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Problemes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "type TEXT NOT NULL,"
                + "latitude FLOAT NOT NULL"
                + "longitude FLOAT NOT NULL"
                + "loc_exacte TEXT NOT NULL,"
                + "description TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ancienneVersion,
                          int nouvelleVersion) {
        db.execSQL("DROP TABLE Problemes;");
        onCreate(db);
    }

    // Version 1 : sans DAO
    // Ce code deviendra inutile quand on le d�placera dans BD_DAO (pour la
    // version 2)
    //

    public void fermeture() {
        bd.close();
    }

    public long ajouter(Probleme Probleme) {

        ContentValues valeurs = new ContentValues();

        valeurs.put("type", Probleme.getType());
        valeurs.put("latitude", Probleme.getLatitude());
        valeurs.put("longitude", Probleme.getLongitude());
        valeurs.put("loc_exacte", Probleme.getLoc_exacte());
        valeurs.put("description", Probleme.getDescription());

        return bd.insert("Problemes", null, valeurs);
    }

    public int supprimer(int id) {
        return bd.delete("Problemes", "id = " + id, null);
    }

    public Probleme getProbleme(int id) {

        Cursor curseur = bd.query("Problemes", null, "id = " + id, null, null,	null, null);

        if (curseur.getCount() == 0)
            return null;

        // th�roriquement, il n'y a qu'un seul enregistrement (au plus) qui
        // r�pond � la requ�te...
        // donc pas besoin de parcourir le r�sultat de la requ�te
        curseur.moveToFirst();

        return curseurToProbleme(curseur);
    }

    public ArrayList<Probleme> getProblemesDeType1() {

        ArrayList<Probleme> liste_type1 = new ArrayList<Probleme>();
        String[] type1 = new String[]{"Arbre a tailler"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemes", null, "type=?", type1, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type1;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type1.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type1;
    }
    public ArrayList<Probleme> getProblemesDeType2() {

        ArrayList<Probleme> liste_type2 = new ArrayList<Probleme>();
        String[] type2 = new String[]{"Arbre a abattre"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemes", null, "type=?", type2, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type2;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type2.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type2;
    }

    public ArrayList<Probleme> getProblemesDeType3() {

        ArrayList<Probleme> liste_type3 = new ArrayList<Probleme>();
        String[] type3 = new String[]{"Detritus"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemels", null, "type=?", type3, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type3;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type3.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type3;
    }

    public ArrayList<Probleme> getProblemesDeType4() {

        ArrayList<Probleme> liste_type4 = new ArrayList<Probleme>();
        String[] type4 = new String[]{"Haie a tailler"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemels", null, "type=?", type4, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type4;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type4.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type4;
    }

    public ArrayList<Probleme> getProblemesDeType5() {

        ArrayList<Probleme> liste_type5 = new ArrayList<Probleme>();
        String[] type5 = new String[]{"Mauvaise herbe"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemels", null, "type=?", type5, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type5;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type5.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type5;
    }

    public ArrayList<Probleme> getProblemesDeType6() {

        ArrayList<Probleme> liste_type6 = new ArrayList<Probleme>();
        String[] type6 = new String[]{"Autre"};
        // on renvoie toute la table "Problemels", tri�e par nom+pr�nom
        Cursor curseur = bd.query("Problemels", null, "type=?", type6, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_type6;

        // on parcourt le r�sultat de la requ�te et on le transforme en un
        // tableau qu'on renvoie � la ListeView
        curseur.moveToFirst();
        do {
            liste_type6.add(curseurToProbleme(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_type6;
    }
    private Probleme curseurToProbleme(Cursor curseur) {

        Probleme Probleme = new Probleme();

        Probleme.setId(curseur.getInt(0));
        Probleme.setType(curseur.getString(1));
        Probleme.setLatitude(curseur.getFloat(2));
        Probleme.setLongitude(curseur.getFloat(3));
        Probleme.setLoc_exacte(curseur.getString(4));
        Probleme.setDescription(curseur.getString(5));

        return Probleme;
    }

}
