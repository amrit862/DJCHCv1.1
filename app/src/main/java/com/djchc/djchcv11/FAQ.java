package com.djchc.djchcv11;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        WebView faqHtml;
        faqHtml= (WebView) findViewById(R.id.faqHtml);
        faqHtml.loadUrl("file:///android_asset/FAQ.html");
        faqHtml.getSettings().setJavaScriptEnabled(true);
        faqHtml.getSettings().setDomStorageEnabled(true);
        faqHtml.getSettings().setBuiltInZoomControls(true);
    }
}
