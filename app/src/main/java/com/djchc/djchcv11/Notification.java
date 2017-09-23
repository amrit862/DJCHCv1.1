package com.djchc.djchcv11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        populateNews();
    }

    private void populateNews() {
        final WebView preNotificationTxt;
        preNotificationTxt= (WebView) findViewById(R.id.preNotificationTxt);
        preNotificationTxt.loadData("<h5 style=\"text-align:center; font-family: initial;color: #337ab7;\"><i>Please wait... It may take few seconds to load data from server</i></h5>", "text/html", "UTF-8");
        Firebase ref = new Firebase("https://djchc-9997c.firebaseio.com/News");
        // Attach an listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            int count = 0;
            StringBuilder text= new StringBuilder();
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
            text.append("<h1 style=\"text-align:center; font-family: initial;color: #337ab7;\">Notifications</h1>");
            text.append("<ol style=\"color:#337ab7;list-style: none;-webkit-padding-start: 0px;\">");
                for (com.firebase.client.DataSnapshot postSnapshot:dataSnapshot.getChildren() ) {
                    Map<String, String> news = postSnapshot.getValue(Map.class);
                    if(true) {
                        text.append("<li>\n" +
                                "        <p style=\"border:1px solid;border-color: #d6e9c6;padding: 24px;\n" +
                                "  border-radius: 6px;font-size:15px;\"><b>" + news.get("Title") + "</b></br>" + news.get("Description") + "</p>\n" +
                                "    </li>");
                        count++;
                    }
                }
                text.append("</ol>");
                if(count>0)
                {
                    preNotificationTxt.loadData("","text/html", "UTF-8");
                }
                WebView eventTxt;
                eventTxt= (WebView) findViewById(R.id.eventTxt);
                eventTxt.loadData(text.toString(),"text/html; charset=UTF-8", null);
                eventTxt.getSettings().setJavaScriptEnabled(true);
                eventTxt.getSettings().setDomStorageEnabled(true);
                eventTxt.getSettings().setBuiltInZoomControls(true);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
