package com.example.zxn.notreparcvert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class AccueilActivity extends ActionBarActivity {

    private BD bd;
    private ArrayList<Probleme> problemes = new ArrayList<Probleme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        bd = new BD(this);

        
    }


        // le button
        Button btn_cre = (Button)findViewById(R.id.btn_cre);
        
        // button click event
        btn_cre.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccueilActivity.this, CreationActivity.class);
                startActivity(intent);
                finish();// stop the activity current
            }
    }
}
