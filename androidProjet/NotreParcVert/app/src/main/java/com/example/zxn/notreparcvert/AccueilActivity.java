package com.example.zxn.notreparcvert;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class AccueilActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // le button
        Button btn_cre = (Button)findViewById(R.id.btn_cre);

        // button click event
        btn_cre.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccueilActivity.this, CreationActivity.class);
                startActivity(intent);
                finish();// stop the activity current
            }
    }
}
