package com.example.zxn.notreparcvert;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class CreationActivity extends ActionBarActivity {

    private Probleme probleme;
    private EditText et_lat,et_lon,loca_exa,des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

       et_lat =  (EditText) findViewById(R.id.et_lat);
       et_lon =  (EditText) findViewById(R.id.et_lon);
        loca_exa =  (EditText) findViewById(R.id.loca_exa);
        des =  (EditText) findViewById(R.id.des);


    }
<<<<<<< Updated upstream


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.creation, menu);
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

    public void save(View view){

    }
=======
>>>>>>> Stashed changes
}
