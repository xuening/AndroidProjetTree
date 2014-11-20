package com.example.zxn.notreparcvert;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class CreationActivity extends ActionBarActivity {

    private Probleme probleme;
    private EditText et_lat, et_lon, loca_exa, des;
    private Spinner spinner_type;
    private BD bd;
    private ArrayAdapter adapter2;
    private TextView tv_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        probleme = new Probleme();
        et_lat = (EditText) findViewById(R.id.et_lat);
        et_lon = (EditText) findViewById(R.id.et_lon);
        loca_exa = (EditText) findViewById(R.id.loca_exa);
        des = (EditText) findViewById(R.id.des);

        // spinner
        spinner_type = (Spinner)findViewById(R.id.spinner_type);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        //add adapter2 to spinner
        spinner_type.setAdapter(adapter2);
        //add event listener
        //spinner_type.setOnItemSelectedListener(new SpinnerXMLSelectedListener());

        //set the value init
        spinner_type.setVisibility(View.VISIBLE);
        spinner_type.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        // display the location of problem as soon as turned into this page
        LocationManager locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (loc != null) {
            et_lat.setText(Double.toString(loc.getLatitude()));
            et_lon.setText(Double.toString(loc.getLongitude()));
        }

        bd = new BD(this);



    }
    // event for creer button
    // save the new problem to the BD
    public void save(View view) {

        // get the value of all items
        probleme.setDescription(des.getText().toString());
        probleme.setLatitude(Float.parseFloat(et_lat.getText().toString()));
        probleme.setLongitude(Float.parseFloat(et_lon.getText().toString()));

        probleme.setType(spinner_type.getSelectedItem().toString());

        probleme.setLoc_exacte(loca_exa.getText().toString());

        bd.ajouter(probleme);

        finish();
    }
    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
