package com.djchc.djchcv11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        WebView contact;
        contact= (WebView) findViewById(R.id.contact);
        contact.loadUrl("file:///android_asset/ContactUs.html");
        contact.getSettings().setJavaScriptEnabled(true);
        contact.getSettings().setDomStorageEnabled(true);
        contact.getSettings().setBuiltInZoomControls(true);
    }
}
