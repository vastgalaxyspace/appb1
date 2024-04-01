package com.example.bloodunityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CardView cardView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.main);
        navigationView=findViewById(R.id.navigation);
        cardView=findViewById(R.id.donate_cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, DontateActivity.class);
                startActivity(intent);
                finish();
            }
        });
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(menuItem -> {
            System.out.println("clickk-------------------------");
            int id=menuItem.getItemId();
            if(id == R.id.nav_home){
                Intent intent= new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }else if(id == R.id.nav_profile){
                Intent intent= new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();

            }else if(id == R.id.nav_about_us){
                Intent intent= new Intent(MainActivity.this, AboutUs.class);
                startActivity(intent);
                finish();

            }
            drawerLayout.closeDrawer(GravityCompat.START);

            return true;
        });

        final OnBackPressedDispatcher dispatcher = getOnBackPressedDispatcher();
        dispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    setEnabled(false);
                    dispatcher.onBackPressed();
                }
            }
        });
    }

}