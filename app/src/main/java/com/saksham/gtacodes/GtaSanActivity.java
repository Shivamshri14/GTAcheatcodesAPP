package com.saksham.gtacodes;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
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

public class GtaSanActivity extends AppCompatActivity {
    private AdView adView;
    private FrameLayout adContainerView;

    ListView list;
    String[] cheats = {
            "Infinite Health", " Infinite Ammo", " Infinite Oxygen", " Chaos Mode", " Elvis has entered the building",
            "Fast Clock", "Faster gameplay", "Slower gameplay", "Giant BMX Hop", "Super Jump", "Beach Rave",
            "Funhouse Theme", "Kinky Theme", "Carnival Theme", "Adrenal Mode", "Riot Mode", "Smash N’ Boom", "Gang Members Everywhere",
            "Armed Peds", "Peds Attack (Rockets)", "Peds Attack Each Other", "Your are Hunted", "Parachute", "" +
            "Muscle Maxed", "Fatty", " Skinny", "Sexiness Maxed", "Slut Magnet", "Respect Maxed", "" +
            "Lung Capacity Maxed", "Vehicle Skills Maxed", "Wanted Level Maxed", " Jetpack", " Suicide",
            "Wanted Level Never Increases", "Wanted Level + 2", "Wanted Level Cleared", "Trucker Theme", "Rural Theme",
            "Ninja Theme", "Eternal Midnight", "00:00 to 12:00", "21:00", "Sandstorm", "Sunny Weather",
            "Super Sunny Weather", "SThunderstorm", "Rainy Weather", "Foggy Weather", "Cloudy Weather",
            "Invisible Car", "Recruit Anyone (9mm)", "Recruit Anyone (Rockets)", "Gangs Rule the Streets",
            "HHealth, Armor, $250K", "Weapons 1, Grunt", " Weapons 2, Surgeon", "Weapons 3, Berserker",
            "Hitman Stat Level", "Awesome Handling", "Aggressive Traffic", "Reduced Traffic",
            "Sweet Ride Car Traffic", "P.O.S. Car Traffic", "Country Traffic", "Pink Traffic", "Black Traffic",
            "Green Light Traffic", " All Cars Nitrous Powered", "loat float away on impact", "Flying Boats", "Flying Cars",
            "C Cars Explode", " Nitrous Taxi’s, L3 Hop", " Spawn Hunter", "Spawn Monster Ride", " Spawn Hydra",
            " Spawn Racecar", " Spawn Dozer", "Spawn Limo", "Spawn Rhino", " Spawn Romero",
            "Spawn Quad", " Spawn Garbage Truck", "Spawn Stunt Plane", "Spawn Cadillac", "Spawn Bloodring Banger",
            "Spawn Rancher", "Spawn Hovercraft", " Spawn Tanker Truck"
    };
    String[] codes = {
            "BAGUVIX", "FULLCLIP", "CVWKXAM", "STATEOFEMERGENCY", "BLUESUEDESHOES", "CJPHONEHOME", "KANGAROO", "CIKGCGX", "YSOHNUl", "SPEEDITUP", "SLOWITDOWN", "PRIEBJ", "BEKKNQV"
            , "CRAZYTOWN", "MUNASEF", "IOJUFZN", " JCNRUAD", "ONLYHOMIESALLOWED", "FOOOXFT", "BGLUAWML", "AJLOJYQY", "BAGOWPG", "AIYPWZQP", "BUFFMEUP", "BTCDBCB", "KVGYZQK", "HELLOLADIES",
            "BEKKNQV", "WORSHIPME", "CVWKXAM", "NATURALTALENT", "BRINGITON", "ROCKETMAN", "GOODBYECRUELWORLD"
            , "AEZAKMI", "OSRBLHH", "ASNAEB", "BMTPWHR", "BMTPWHR", "NINJATOWN", "NIGHTPROWLER", "XJVSNAJ", "OFVIAC", "CWJXUOC", "PLEASANTLYWARM", "TOODAMNHOT", "SCOTTISHSUMMER",
            "AUIFRVOS", "CFVFGMJ", "ALNSFMZ0", "WHEELSONLYPLEASE", "SJMAHPE", "ROCKETMAYHEM", "BIFBUZZ", "HESOYAM", "LXGIWYL", "PROFESSIONALSKIT", "UZUMYMW", "PROFESSIONALKILLER",
            "STICKLIKEGLUE", "YLTEICZ", "GHOSTTOWN", "EVERYONEISRICH", "EVERYONEISPOOR", "FVTMNBZ", "LLQPFBN", "IOWDLAC", "ZEIIVG", "SPEEDFREAK", "BUBBLECARS", "FLYINGFISH", "RIPAZHA", "CPKTNWT",
            "VKYPQCF", "OHDUDE", "MONSTERMASH", "JUMPJET", "VROCKPOKEY", "ITSALLBULL", "CELEBRITYSTATUS", "AIWPRTON", "WHERESTHEFUNERAL", "FOURWHEELFUN", "TRUEGRIME", "FLYINGTOSTUNT",
            "RZHSUEW", "COZIJMB", "JQNTDMH", "KGGGDKP", "AMOMHRER"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gta_san);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Objects.requireNonNull(getSupportActionBar()).setTitle("     Cheat Codes (PC)");


        MyListAdapter adapter=new MyListAdapter(this, cheats,codes);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


        //For ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.gtasan_adContainer);
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