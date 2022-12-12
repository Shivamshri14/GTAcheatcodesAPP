package com.saksham.gtacodes;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class gta4Activity extends AppCompatActivity {

    private AdView adView;
    private FrameLayout adContainerView;


    String[] Cheats = {"Get max health & armour",
            "Get max health, Armour and ammo","Weapons 1","Weapons 2","Remove wanted level","Increase wanted level","Change weather","Spawn Annihilator helicopter",
            "Spawn Banshee","Spawn Cognoscenti supercar","Spawn Comet sports car","Spawn Buffalo vehicle","Spawn Jetmax","Spawn NRG-90",
            "Spawn Sanchez","Spawn SuperGT sports car","Spawn Turismo sports car"};

    String[] Codes = {"362-555-0100","482-555-0100","486-555-0150","486-555-0100","267-555-0100",
            "267-555-0150","468-555-0100","359-555-0100","265-555-2423","227-555-0142","227-555-0171","227-555-0100","938-555-0100",
            "625-555-0100","625-555-0150","227-555-0168","227-555-0147"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gta4);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Objects.requireNonNull(getSupportActionBar()).setTitle("     Cheat Codes (PC)");


        MyListAdapter adapter=new MyListAdapter(this, Cheats,Codes);
        ListView listView = findViewById(R.id.gta4list);
        listView.setAdapter(adapter);


        //For ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.gta4_adContainer);
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

    }

    private AdSize getAdSize() {

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
    private void loadBanner() {

        AdSize adSize = getAdSize();

        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }

}