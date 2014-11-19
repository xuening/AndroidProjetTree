package com.example.zxn.notreparcvert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.ArrayList;


public class AccueilActivity extends ActionBarActivity {

    private BD bd;
    private ArrayList<Probleme> problemes = new ArrayList<Probleme>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        bd = new BD(this);

       // problemes = bd.getProblems();

    }




    // change current activity to creationActivity
    public void create_new_problem(View view) {
        startActivity(new Intent(this, CreationActivity.class));


    }

}
