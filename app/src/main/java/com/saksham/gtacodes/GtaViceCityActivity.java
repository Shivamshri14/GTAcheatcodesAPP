package com.saksham.gtacodes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GtaViceCityActivity extends AppCompatActivity {
    private AdView adView;
    private FrameLayout adContainerView;

    ListView gtavc_cheats_list;
    String[] Cheats = {"Weapon set #1","Weapon set #2","Weapon set #3","Restore health","Gain/restore armor",
    "Kill self","Increase Wanted Level","Decrease Wanted Level","Female actors follow player","Tommy smokes a cigarette",
    " Player model changed to fat","Player model changed to skinny","Player model changed randomly","Player model is Ricardo Diaz",
    "Player model is Lance Vance","Player model is Ken Rosenberg","Player model is Hilary King","Player model is Love Fist rocker #1",
    "Player model is Love Fist rocker #2","Player model is Phil Cassidy","Player model is Sonny Forelli","Player model is Mercedes",
    "Spawns a Rhino Tank","Spawns a Bloodring Banger","Spawns a Bloodring Banger 2","Spawns a Sabre Turbo",
    "Spawns a Hotring Racer","Spawns a Hotring Racer 2","Spawns a Romero’s Hearse",
    "Spawns a Love Fist Stretch/Limo","Spawns a Trashmaster","Spawns a Golf Caddie","Explodes nearby cars",
    "Aggressive AI driving on","All cars become pink","All cars become black","Flying cars cheat",
    "Vehicle handling improved","All traffic signals green","Cars hover over water","Only car wheels visible","Some cars have big wheels",
    "Actors get into player’s current car","Sunny weather","Overcast weather"," Weather very overcast","Weather foggy",
    "Stormy Weather"," Time compression (speeds up game time)"," Shows Media Level","Actors all attack","Actors attack player",
    "Female actors armed","All actors armed","Show media level"};

    String[] Codes = {"THUGSTOOLS","PROFESSIONALTOOLS","NUTTERTOOLS","ASPIRINE","PRECIOUSPROTECTION",
            "ICANTTAKEITANYMORE","YOUWONTTAKEMEALIVE","LEAVEMEALONE","FANNYMAGNET","CERTAINDEATH ",
            "DEEPFRIEDMARSBARS","PROGRAMMER","STILLLIKEDRESSINGUP","CHEATSHAVEBEENCRACKED",
            "LOOKLIKELANCE","MYSONISALAWYER","LOOKLIKEHILARY","ROCKANDROLLMAN ",
            "WELOVEOURDICK","ONEARMEDBANDIT","IDONTHAVETHEMONEYSONNY","FOXYLITTLETHING",
            "PANZER","TRAVELINSTYLE","GETTHEREQUICKLY","GETTHEREFAST",
            "GETTHEREVERYFASTINDEED","GETTHEREAMAZINGLYFAST","THELASTRIDE",
            "ROCKANDROLLCAR","RUBBISHCAR","BETTERTHANWALKING","BIGBANG",
            "MIAMITRAFFIC","AHAIRDRESSERSCAR","IWANTITPAINTEDBLACK","COMEFLYWITHME ",
            "GRIPISEVERYTHING","GREENLIGHT","SEAWAYS ","WHEELSAREALLINEED ","LOADSOFLITTLETHINGS ",
            "HOPINGIRL","ALOVELYDAY","APLEASANTDAY","ABITDRIEG","CANTSEEATHING",
            "CATSANDDOGS","LIFEISPASSINGMEBY","CHASESTAT","FIGHTFIGHTFIGHT","NOBODYLIKESME",
            "CHICKSWITHGUNS","OURGODGIVENRIGHTTOBEARARMS","CHASESTAT"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gta_vicecity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        Objects.requireNonNull(getSupportActionBar()).setTitle("     Cheat Codes (PC)");


        MyListAdapter adapter=new MyListAdapter(this, Cheats,Codes);
        ListView listView = findViewById(R.id.gtavc_cheats_list);
        listView.setAdapter(adapter);
        //For ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        adContainerView = findViewById(R.id.gtavc_adContainer);
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
