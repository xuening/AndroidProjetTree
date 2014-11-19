package com.example.zxn.notreparcvert;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class CreationActivity extends ActionBarActivity {

    private Probleme probleme;
    private EditText et_lat, et_lon, loca_exa, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        et_lat = (EditText) findViewById(R.id.et_lat);
        et_lon = (EditText) findViewById(R.id.et_lon);
        loca_exa = (EditText) findViewById(R.id.loca_exa);
        des = (EditText) findViewById(R.id.des);


    }

    public void save(View view) {
        
    }

}
