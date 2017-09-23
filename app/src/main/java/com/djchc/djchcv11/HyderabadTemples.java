package com.djchc.djchcv11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class HyderabadTemples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyderabad_temples);
        WebView temples;
        temples= (WebView) findViewById(R.id.temples);
        temples.loadUrl("file:///android_asset/TempleList.html");
        temples.getSettings().setJavaScriptEnabled(true);
        temples.getSettings().setDomStorageEnabled(true);
        temples.getSettings().setBuiltInZoomControls(true);

    }
}
