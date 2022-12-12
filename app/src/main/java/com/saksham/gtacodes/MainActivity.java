package com.saksham.gtacodes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.saksham.gtacodes.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        //mNavigationView.setItemIconTintList(null);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rate, R.id.nav_mail, R.id.nav_lovecal, R.id.nav_tic)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_settings) {

            buildAlertMessage();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void buildAlertMessage(){
        final  AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("Developed By Saksham Shri").setCancelable(false).setPositiveButton("Visit Instagram", (dialog, which) -> {
            Uri uri = Uri.parse("https://www.instagram.com/_heysaksham/");
            Intent intent =new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }); /* .setNegativeButton("More Apps", (dialog, which) -> {
            dialog.cancel();
            Uri uri = Uri.parse("https://play.google.com/store/apps/developer?id=Ayush+Ojha");
            Intent intent =new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }); */
        final AlertDialog Alert =builder.create();
        Alert.show();
    }
}