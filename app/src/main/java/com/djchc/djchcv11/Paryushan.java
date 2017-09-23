package com.djchc.djchcv11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Paryushan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paryushan);
        populatePage();
    }


    private void populatePage() {
        final WebView preParyushanTxt;
        preParyushanTxt= (WebView) findViewById(R.id.preParyushanTxt);
        preParyushanTxt.loadData("<h5 style=\"text-align:center; font-family: initial;color: #337ab7;\"><i>Please wait... It may take few seconds to load data from server</i></h5>", "text/html", "UTF-8");
        Firebase ref = new Firebase("https://djchc-9997c.firebaseio.com/Paryushan");
        // Attach an listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            int count = 0;
            StringBuilder text= new StringBuilder();
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                for (com.firebase.client.DataSnapshot postSnapshot:dataSnapshot.getChildren() ) {
                    Map<String, String> page = postSnapshot.getValue(Map.class);
                    if(true) {
                        text.append(page.get("Page"));
                        count++;
                    }
                }
                if(count>0)
                {
                    preParyushanTxt.loadData("","text/html", "UTF-8");
                }

                WebView paryushanTxt;
                paryushanTxt= (WebView) findViewById(R.id.paryushanTxt);
                paryushanTxt.loadData(text.toString(),"text/html; charset=UTF-8", null);
                paryushanTxt.getSettings().setJavaScriptEnabled(true);
                paryushanTxt.getSettings().setDomStorageEnabled(true);
                paryushanTxt.getSettings().setBuiltInZoomControls(true);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
