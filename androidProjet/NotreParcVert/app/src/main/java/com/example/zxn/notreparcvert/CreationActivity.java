package com.example.zxn.notreparcvert;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class CreationActivity extends ActionBarActivity {

    private Probleme probleme;
    private EditText et_lat, et_lon, loca_exa, des;
    private Spinner spinner1;
    private BD bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        probleme = new Probleme();
        et_lat = (EditText) findViewById(R.id.et_lat);
        et_lon = (EditText) findViewById(R.id.et_lon);
        loca_exa = (EditText) findViewById(R.id.loca_exa);
        des = (EditText) findViewById(R.id.des);


        LocationManager locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc != null) {
            et_lat.setText(Double.toString(loc.getLatitude()));
            et_lon.setText(Double.toString(loc.getLongitude()));
        }

        bd = new BD(this);



    }

    public void save(View view) {

        /*
        personne.setNom(nom.getText().toString());
        personne.setPrenom(prenom.getText().toString());
        personne.setAge(Integer.parseInt(age.getText().toString()));*/


        probleme.setDescription(des.getText().toString());
        probleme.setLatitude(Float.parseFloat(et_lat.getText().toString()));
        probleme.setLongitude(Float.parseFloat(et_lon.getText().toString()));
        probleme.setType(spinner1.getSelectedItem().toString());
        probleme.setLoc_exacte(loca_exa.getText().toString());

        bd.ajouter(probleme);

        finish();
    }
    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
