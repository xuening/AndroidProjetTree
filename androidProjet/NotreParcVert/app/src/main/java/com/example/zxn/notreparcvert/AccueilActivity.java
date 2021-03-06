package com.example.zxn.notreparcvert;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AccueilActivity extends ActionBarActivity {

    private BD bd;
    private ArrayList<Probleme> problemes = new ArrayList<Probleme>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);


        bd = new BD(this);

        listView = (ListView)findViewById(R.id.listView1);

    }

    protected void onStart(){
        super.onStart();
        problemes = bd.getProblems();

        final ArrayList<String> list = new ArrayList<String>();
        for(Probleme per : problemes){
            list.add(per.getDescription());// the problem list is displayed by description.
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        //listener for listView click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Probleme probleme = problemes.get(position);
                start_probleme_activity(probleme);

            }

        });
    }

    // send the arg "id" of problem to problemeActivity
    public void start_probleme_activity(Probleme probleme){
        Intent intention = new Intent(this,ProblemeActivity.class );
        intention.putExtra("id", probleme.getId());
        startActivity(intention);
    }

    // when click button creer_un_nouveau_probleme change to new Activity
    public void create_new_problem(View view) {
        startActivity(new Intent(this, CreationActivity.class));


    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
