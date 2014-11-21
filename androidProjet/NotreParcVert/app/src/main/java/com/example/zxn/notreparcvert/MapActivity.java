package com.example.zxn.notreparcvert;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MapActivity extends ActionBarActivity {
    private WebView webView;
    private String lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        webView = (WebView) findViewById(R.id.webView);
    }

    protected void onStart() {
        super.onStart();

        // get value of lati and longi
        Bundle donnees = getIntent().getExtras();

        if (donnees != null) {
            lat = donnees.getString("lat");
            lon = donnees.getString("lon");
        }


        String sUrl = "http://maps.google.com/maps?q=" + lat + "," + lon;


        webView.getSettings().setJavaScriptEnabled(true);//setting for js
        webView.getSettings().setBuiltInZoomControls(true);//setting for supporting zoom
        // webView.getSettings().setDefaultFontSize(5);

        webView.loadUrl(sUrl);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);//
                return true;//true means this event is done here
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
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
}
