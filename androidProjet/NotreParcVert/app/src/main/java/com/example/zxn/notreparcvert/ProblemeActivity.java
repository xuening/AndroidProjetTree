package com.example.zxn.notreparcvert;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ProblemeActivity extends ActionBarActivity {

    private Probleme probleme;
    private BD bd;
    private EditText et_type,et_lat,et_lon,et_loca_exa,et_des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probleme);

        et_type = (EditText) findViewById(R.id.et_type);
        et_lat = (EditText) findViewById(R.id.et_lat);
        et_lon = (EditText) findViewById(R.id.et_lon);
        et_loca_exa = (EditText) findViewById(R.id.et_loca_exa);
        et_des = (EditText) findViewById(R.id.et_des);

        probleme = new Probleme();
        bd = new BD(this);

    }

    public void onStart(){
        super.onStart();
        Bundle donnees = getIntent().getExtras();
        if(donnees!= null){
            probleme = bd.getProbleme(donnees.getInt("id"));
            et_type.setText(probleme.getType());
            et_lat.setText(Float.toString(probleme.getLatitude()));
            et_lon.setText(Float.toString(probleme.getLongitude()));
            et_loca_exa.setText(probleme.getLoc_exacte());
            et_des.setText(probleme.getDescription());

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.probleme, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void supprimer(View vue) {
        // version 1 : sans DAO
        bd.supprimer(probleme.getId());
        // version 2 : avec DAO
        //bd.supprimer(personne);

        finish();
    }
    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
