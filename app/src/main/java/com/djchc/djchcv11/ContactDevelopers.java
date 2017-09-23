package com.djchc.djchcv11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ContactDevelopers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_developers);

        WebView ContactDevelopers;
        ContactDevelopers= (WebView) findViewById(R.id.webContactDev);
        ContactDevelopers.loadUrl("file:///android_asset/ContactDevelopers.html");
        ContactDevelopers.getSettings().setJavaScriptEnabled(true);
        ContactDevelopers.getSettings().setDomStorageEnabled(true);
        ContactDevelopers.getSettings().setBuiltInZoomControls(true);
    }
}
