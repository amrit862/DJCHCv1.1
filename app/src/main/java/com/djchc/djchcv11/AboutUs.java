package com.djchc.djchcv11;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        WebView aboutus;
        aboutus= (WebView) findViewById(R.id.aboutus);
        aboutus.loadUrl("file:///android_asset/AboutUs.html");
        aboutus.getSettings().setJavaScriptEnabled(true);
        aboutus.getSettings().setDomStorageEnabled(true);
        aboutus.getSettings().setBuiltInZoomControls(true);
    }
}
