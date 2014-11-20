package com.example.zxn.notreparcvert;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Map;


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
            probleme = bd.getProbleme(donnees.getInt("id"));//receive the "id" of which item we click
            //get all information of the problem
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

    public void start_affichier(EditText et_lat,EditText et_lon){
        Intent intention = new Intent(this, MapActivity.class );
        intention.putExtra("lat", et_lat.getText());
        intention.putExtra("log", et_lon.getText());
        startActivity(intention);
    }

    public void affichier_sur_une_carte(View view) {
       // Uri uri = Uri.parse("geo:38.899533,-77.036476");
       // Intent it = new Intent(Intent.Action_VIEW,uri);
       // startActivity(it);
       /* String sUrl = "https://www.google.fr/maps/place/Université+de+Lille+1,+59650+Villeneuve‐ d'Ascq/@" + probleme.getLatitude() + "," + probleme.getLongitude() + ",20z";
        Intent intent = new Intent();
        intent.setData(Uri.parse(sUrl));
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);*/
        startActivity(new Intent(this, MapActivity.class));
    }
    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
