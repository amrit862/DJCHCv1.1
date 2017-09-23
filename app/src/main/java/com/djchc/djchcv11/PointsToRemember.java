package com.djchc.djchcv11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PointsToRemember extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_to_remember);
        WebView temples;
        temples= (WebView) findViewById(R.id.ptr);
        temples.loadUrl("file:///android_asset/PointsToRemember.html");
        temples.getSettings().setJavaScriptEnabled(true);;
        temples.getSettings().setDomStorageEnabled(true);;
        temples.getSettings().setBuiltInZoomControls(true);
    }
}
