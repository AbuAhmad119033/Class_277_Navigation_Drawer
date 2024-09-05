package com.example.class_277_navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ClipData;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    NavigationView navigationView;
    TextView headerTitle;
    View headerView;
    ImageView imgHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        navigationView = findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        headerTitle = headerView.findViewById(R.id.headerTitle);
        imgHeader = headerView.findViewById(R.id.imgHeader);
        headerTitle.setText("Stoke Market App");
        //imgHeader.getDrawable();

        FragmentManager fManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, new firstFragment());
        fragmentTransaction.commit();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);


//------------------------------------------------------------
        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId() == R.id.share){
                    Toast.makeText(MainActivity.this, "This is Share Item", Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.search){
                    Toast.makeText(MainActivity.this, "This is search Item", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

// -------------------------------------------------------------------------
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.dse){
                    //Toast.makeText(MainActivity.this, "This is Home", Toast.LENGTH_SHORT).show();

                    firstFragment.WEB_URL = "https://www.dsebd.org/";

                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new firstFragment());
                    fragmentTransaction.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                else if(item.getItemId() == R.id.cse){
                    //Toast.makeText(MainActivity.this, "This is Profile", Toast.LENGTH_SHORT).show();

                    firstFragment.WEB_URL = "https://thecse.com/";

                    FragmentManager fManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new firstFragment());
                    fragmentTransaction.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                else if(item.getItemId() == R.id.notification){
                    //Toast.makeText(MainActivity.this, "This is Notification", Toast.LENGTH_SHORT).show();

//                    FragmentManager fManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
//                    fragmentTransaction.add(R.id.frameLayout, new thirdFragment());
//                    fragmentTransaction.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                else if(item.getItemId() == R.id.settings){
                    //Toast.makeText(MainActivity.this, "This is Settings", Toast.LENGTH_SHORT).show();

//                    FragmentManager fManager = getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fManager.beginTransaction();
//                    fragmentTransaction.add(R.id.frameLayout, new firstFragment());
//                    fragmentTransaction.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });

    }

//        ------------------------------------------------oncreate ENDS


}