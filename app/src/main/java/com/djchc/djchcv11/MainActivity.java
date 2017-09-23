package com.djchc.djchcv11;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetNotification();
            }
        });*/



        // Write a message to the database
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("message");

        myRef.setValue("Hello, World!");
        Firebase ref = new Firebase("https://djchc-9997c.firebaseio.com/");
        Firebase postRef = ref.child("News");

        Map<String, String> news1 = new HashMap<String, String>();
        news1.put("Title", "Parvadhiraj Paryushan 2016 Starting");
        news1.put("Description", "Paryushan parv starting from 6th Aug to 15th Aug, 2016. We as DJCHC family invites you all to get punya labh");
        postRef.push().setValue(news1);

        Map<String, String> news2 = new HashMap<String, String>();
        news2.put("Title", "Hyderabad jain temples visit.");
        news2.put("Description", "Hyderabad jain temples visit is scheduled during paryushan parv, it scheduled on 10th of August. Please contact Amrit jain for more details on 7702451345.");
        postRef.push().setValue(news2);*/

        // Read from the database
        /*myRef.addValueEventListener(new ValueEventListener() {
            public static final String TAG = "" ;

            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }


        });*/


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Paryushan.class);
                startActivity(intent);
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void GetNotification() {
        // this will create new notification.
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_menu_camera)
                        .setContentTitle("Notification Heading")
                        .setContentText("Notification Description");

        // this will tell where to redirect after click of notification.
        Intent resultIntent = new Intent(getApplicationContext(), Notification.class);


        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        resultIntent,
                        PendingIntent.FLAG_ONE_SHOT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        int mNotificationId = 001;
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.contactus) {
            Intent intent = new Intent(this, ContactUs.class);
            startActivity(intent);
        } else if (id == R.id.aboutus) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);
        } else if (id == R.id.faq) {
            Intent intent = new Intent(this, FAQ.class);
            startActivity(intent);
        } else if (id == R.id.pointsToRemember) {
            Intent intent = new Intent(this, PointsToRemember.class);
            startActivity(intent);
        } else if (id == R.id.paryushan) {
            Intent intent = new Intent(this, Paryushan.class);
            startActivity(intent);
        }else if (id == R.id.Notification) {
            Intent intent = new Intent(this, Notification.class);
            startActivity(intent);
        }else if (id == R.id.HydTemples) {
            Intent intent = new Intent(this, HyderabadTemples.class);
            startActivity(intent);
        } else if (id == R.id.contactDevelopers) {
            Intent intent = new Intent(this, ContactDevelopers.class);
            startActivity(intent);
        }else if (id == R.id.gallery) {
            Intent intent = new Intent(this, Gallery.class);
            startActivity(intent);
        }

        //actualCode
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
