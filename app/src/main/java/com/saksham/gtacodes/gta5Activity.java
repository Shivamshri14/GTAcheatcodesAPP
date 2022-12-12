package com.saksham.gtacodes;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class gta5Activity extends AppCompatActivity {

    private AdView adView;
    private FrameLayout adContainerView;


    String[] Cheats = {"Become invincible for five minutes","Get all weapons","Full health and armour","Recharge special ability","Run faster","Swim faster",
    "Jump higher","Raise wanted level","Reduce wanted level","Aim better","Exploding punch","Exploding bullets","Flaming bullets","Make your character inebriated",
    "Get a parachute","Fall from sky with no parachute","Change the weather","Ensure traffic chaos thanks to slippery cars","Get inside a vehicle to activate low gravity"
    ,"Play the game in slow motion","Play as any NPC in GTA 5","Spawn a garbage truck","Spawn a stunt plane","Spawn a BMX bicycle","Spawn an armed helicopter"
    ,"Spawn a crop duster plane","Spawn a golf cart","Spawn a sports car","Spawn a different sports car","Spawn a limousine","Spawn a motorcycle"
    ,"Spawn a dirt bike"};

    String[] Codes = {"PAINKILLER","TOOLUP","TURTLE","POWERUP","CATCHME","GOTGILLS","HOPTOIT","FUGITIVE","LAWYERUP","DEADEYE","HOTHANDS","HIGHEX",
    "INCENDIARY","LIQUOR","SKYDIVE","SKYFALL","MAKEITRAIN","SNOWDAY","FLOATER","SLOWMO","JRTALENT","TRASHED","BARNSTORM","BANDIT","BUZZOFF","FLYSPRAY",
    "HOLEIN1","COMET","RAPIDGT","VINEWOOD","ROCKET","OFFROAD"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gta5);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Objects.requireNonNull(getSupportActionBar()).setTitle("     Cheat Codes (PC)");


        MyListAdapter adapter=new MyListAdapter(this, Cheats,Codes);
        ListView listView = findViewById(R.id.gta5_cheats_list);
        listView.setAdapter(adapter);


        //For ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.gta5_adContainer);
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