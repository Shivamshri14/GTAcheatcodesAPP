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

public class gta3Activity extends AppCompatActivity {

    private AdView adView;
    private FrameLayout adContainerView;


    String[] Cheats = {"All Weapons","Change Costumes","Clear Weather SKINCANCERFORME","Cloudy Weather" ,"Destroy All Cars" ,"Fast Motion",
            "Flying Vehicle","Foggy Weather ","Full Armour","Full Health ","Improve Driving Skill","Increased Gore","Lower Wanted Level",
            "Money Cheat","Pedestrians Fight Each Other","Pedestrians Fight Each Other with Weapons","Pedestrians Hate You","Rainy Weather",
            "Raise Wanted Level","Slow Motion","Spawn Rhino Tank ","Speed Up Time","Turn Vehicle Invisible"};

    String[] Codes = {"GUNSGUNSGUNS","ILIKEDRESSINGUP","SKINCANCERFORME","ILIKESCOTLAND"," BANGBANGBANG","TIMEFLIESWHENYOU","CHITTYCHITTYBB",
            "PEASOUP","TORTOISE or TURTOISE","GESUNDHEIT","CORNERSLIKEMAD","NASTYLIMBSCHEAT","NOPOLICEPLEASE","IFIWEREARICHMAN","ITSALLGOINGMAAAD",
            "WEAPONSFORALL","NOBODYLIKESME","ILOVESCOTLAND","MOREPOLICEPLEASE","BOOOOORING","GIVEUSATANK","MADWEATHER","ANICESETOFWHEELS"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gta3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Objects.requireNonNull(getSupportActionBar()).setTitle("     Cheat Codes (PC)");


        MyListAdapter adapter=new MyListAdapter(this, Cheats,Codes);
        ListView listView = findViewById(R.id.gta3list);
        listView.setAdapter(adapter);


        //For ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.gta3_adContainer);
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