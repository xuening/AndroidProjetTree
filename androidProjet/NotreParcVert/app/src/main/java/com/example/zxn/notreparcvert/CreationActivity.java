package com.example.zxn.notreparcvert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Location;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.renderscript.Script;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class CreationActivity extends ActionBarActivity {

    private Probleme probleme;
    private EditText et_lat, et_lon, loca_exa, des;
    private Spinner spinner_type;
    private BD bd;
    private ArrayAdapter adapter2;


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

        //get location exact by the latitude and longitude
        Geocoder gc = new Geocoder(this.getApplicationContext(), Locale.FRANCE);
        try {
            List<Address> locations_exacte = gc.getFromLocation(loc.getLatitude(), loc.getLongitude(), 5);
            //Address[addressLines=[0:"8B Rue Faidherbe",1:"59260 Lezennes",2:"France"],feature=,admin=null,sub-admin=null,locality=Lezennes,thoroughfare=Rue Faidherbe,postalCode=59260,countryCode=FR,countryName=France,hasLatitude=true,latitude=50.6150342,hasLongitude=true,longitude=3.1145944,phone=null,url=null,extras=null]
            String location_exa = locations_exacte.get(0).getAddressLine(0) + ", " + locations_exacte.get(0).getAddressLine(1) +", " + locations_exacte.get(0).getAddressLine(2);
            loca_exa.setText(location_exa);
            //System.out.println(locations_exacte.get(0).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        bd = new BD(this);



    }
    // event for creer button
    // save the new problem to the BD
    public void save(View view) {

        // get the value of all items
        // make sure that the description has been written
        if(des.getText().toString().length()==0){
            // alert un dialog of error
            new AlertDialog.Builder(CreationActivity.this).setTitle("Info:").setMessage("Il faut ajouter la description").setPositiveButton("Quitter",null).show();
        }
        else {
            probleme.setDescription(des.getText().toString());
            probleme.setLatitude(Float.parseFloat(et_lat.getText().toString()));
            probleme.setLongitude(Float.parseFloat(et_lon.getText().toString()));

            probleme.setType(spinner_type.getSelectedItem().toString());

            probleme.setLoc_exacte(loca_exa.getText().toString());

            bd.ajouter(probleme);

            finish();
        }
    }
    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
