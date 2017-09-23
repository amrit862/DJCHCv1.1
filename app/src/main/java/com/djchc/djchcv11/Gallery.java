package com.djchc.djchcv11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        populateGallery();
    }

    private void populateGallery() {
        final WebView galleryPreTxt;
        galleryPreTxt= (WebView) findViewById(R.id.galleryPreTxt);
        galleryPreTxt.loadData("<h5 style=\"text-align:center; font-family: initial;color: #337ab7;\"><i>Please wait... It may take few seconds to load data from server</i></h5>", "text/html", "UTF-8");
        Firebase ref = new Firebase("https://djchc-9997c.firebaseio.com/Gallery");
        // Attach an listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            int count = 0;
            StringBuilder text= new StringBuilder();
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                text.append("<h1 style=\"text-align:center; font-family: initial;color: #337ab7;\">Gallery</h1>");
                text.append("<ol style=\"color:#337ab7;list-style: none;-webkit-padding-start: 0px;\">");
                for (com.firebase.client.DataSnapshot postSnapshot:dataSnapshot.getChildren() ) {
                    Map<String, String> galleryPicInfo = postSnapshot.getValue(Map.class);
                    if(true) {
                        text.append("<h4 style=\"color:#337ab7;text-align:left;padding:3px 0px 3px 5px\"><i>"+galleryPicInfo.get("ImageTitle")+"</i></h4>\n" +
                                "    <img src=\""+galleryPicInfo.get("ImageUrl")+"\"\n" +
                                "         style=\"border-radius:10px;padding:5px;box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);width:250pt;height:150pt\"/>");
                        count++;
                    }
                }
                text.append("</ol>");
                if(count>0)
                {
                    galleryPreTxt.loadData("","text/html", "UTF-8");
                }
                WebView galleryWebView;
                galleryWebView= (WebView) findViewById(R.id.galleryWebView);
                galleryWebView.loadData(text.toString(),"text/html; charset=UTF-8", null);
                galleryWebView.getSettings().setJavaScriptEnabled(true);
                galleryWebView.getSettings().setDomStorageEnabled(true);
                galleryWebView.getSettings().setBuiltInZoomControls(true);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
