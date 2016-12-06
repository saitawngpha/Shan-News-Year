package com.saitawngpha.shannewyear;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.annotation.SuppressLint;
import com.saitawngpha.shannewyear.Welcome.WelcomeToActivity;
import com.stephentuso.welcome.WelcomeHelper;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

@SuppressLint("NewApi")
public class ShanNewYear extends Activity implements OnActionClickedListener {

    private static final int REQUEST_WELCOME_SCREEN_RESULT = 13;
    private WelcomeHelper WelcomeToScreen;
    private MediaPlayer mp;
    // welcome
    private Button iab;
    // about Button
    private InterstitialAd interstitial;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shan_new_year);

        // ActionBar Custom Color
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7B1FA2")));

        // ads
        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(ShanNewYear.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId("ca-app-pub-9447884126970962/7298597534");

        //Locate the Banner Ad in activity_main.xml
        AdView adView = (AdView) this.findViewById(R.id.adView);

        // Request for Ads
        AdRequest adRequest = new AdRequest.Builder()

                // Add a test device to show Test Ads
               // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                //.addTestDevice("CC5F2C72DF2B356BBF0DA198")
                .build();
        // Load ads into Banner Ads
        adView.loadAd(adRequest);

        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
               displayInterstitial();
            }
        });

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/PangLong.ttf").setFontAttrId(com.saitawngpha.shannewyear.R.attr.fontPath)
                .build());

        WelcomeToScreen = new WelcomeHelper(this, WelcomeToActivity.class);
        WelcomeToScreen.show(savedInstanceState);
        // To Show Welcome Screen
        WelcomeToScreen.forceShow();


        // audio start
        mp = MediaPlayer.create(this, R.raw.happyrelative);
        // Button ID
        iab = (Button)findViewById(R.id.ab);

        // About Element
        final Element adsElement = new Element();
        adsElement.setTitle("Happy Shan New Year 2111");

        // Media Player Service
        final InteractivePlayerView ipv = (InteractivePlayerView) findViewById(R.id.ipv);
        ipv.setMax(318);
        ipv.setProgress(0);
        ipv.setOnActionClickedListener(this);

        // Control Play & Stop Button
        final ImageView control = (ImageView) findViewById(R.id.control);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ipv.isPlaying()) {
                    ipv.start();
                    mp.start();
                    displayInterstitial();
                   // mp.setLooping(true);
                    control.setBackgroundResource(R.drawable.pause);
                } else {
                    ipv.stop();
                    mp.pause();
                    control.setBackgroundResource(R.drawable.play);
                }
            }
        }); // end audio

        // About Page button
        this.iab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInterstitial();
                View aboutPage = new AboutPage(ShanNewYear.this)
                        .isRTL(false)
                        .setImage(R.drawable.dummy_image)
                        .setDescription(getString(R.string.sny_description))
                        .addItem(new Element().setTitle("Version 1.0"))
                        .addItem(adsElement)
                        .addGroup("Contact Me")
                        .addEmail("tawngpha@gmail.com")
                        .addWebsite("http://panglong-font.appspot.com/")
                        .addFacebook("Sai Tawng Pha")
                        .addTwitter("SaiTawngPha")
                        .addYoutube("UCi8N92tSZlWGJd4vz5yS_YA")
                        .addPlayStore("com.saitawngpha.shannewyear")
                       // .addInstagram("medyo80")
                        //.addGitHub("medyo")
                        .addItem(getCopyRightsElement())
                        .create();

                setContentView(aboutPage);
            }
        }); // end about page

    }

    // welcome
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // This is needed to prevent welcome screens from being
        // automatically shown multiple times

        // This is the only one needed because it is the only one that
        // is shown automatically. The others are only force shown.
        WelcomeToScreen.onSaveInstanceState(outState);
    } // welcome end

    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
    // start audio

    @Override
    public void onActionClicked(int id) {
        switch (id) {
            case 1:
                //Called when 1. action is clicked.
                break;
            case 2:
                //Called when 2. action is clicked.
                break;
            case 3:
                //Called when 3. action is clicked.
                break;
            default:
                break;
        }// end audio
    }
    // Custom font
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    // About Element

    Element getCopyRightsElement() {
        Element copyRightsElement = new Element();
        final String copyrights = String.format(getString(R.string.copy_right), Calendar.getInstance().get(Calendar.YEAR));
        copyRightsElement.setTitle(copyrights);
        copyRightsElement.setIcon(R.drawable.about_icon_copy_right);
        copyRightsElement.setColor(ContextCompat.getColor(this, mehdi.sakout.aboutpage.R.color.about_item_icon_color));
        copyRightsElement.setGravity(Gravity.CENTER);
        copyRightsElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShanNewYear.this, copyrights, Toast.LENGTH_SHORT).show();
            }
        });
        return copyRightsElement;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        displayInterstitial();
        ShanNewYear.this.finish();
        this.mp.stop();
    }
}
