package com.admob.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.ads.nativetemplates.AdsUtility;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    AdView adView;
    AdLoader adLoader;
    RewardedAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdsUtility.InterstitialAdmob(MainActivity.this,getResources().getString(R.string.interstecial_id), false);


        Button btnShowRewarded = (Button) findViewById(R.id.btnShowRewarded);
        btnShowRewarded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rewardedAdADs();
            }
        });

        Button btnShowInterstitial = (Button) findViewById(R.id.btnShowInterstitial);
        btnShowInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsUtility.showIntestitialAds();
            }
        });

       // initBannerADs();

     //   initUnifiedNativeAdADs();

        rewardedAdADs();

    }




    private void rewardedAdADs()
    {
        if (AdsUtility.isNetworkAvailable(this))
        {
            rewardedAd = new RewardedAd(this, "ca-app-pub-3940256099942544/5224354917");
            AdsUtility.RewardedAdmob(rewardedAd);
        }
    }


    private void initUnifiedNativeAdADs()
    {
        adLoader = new AdLoader.Builder(this, getResources().getString(R.string.native_ads))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {

                        NativeTemplateStyle styles = new NativeTemplateStyle.Builder().build();
                        TemplateView template = findViewById(R.id.my_template);
                        template.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);
                        template.setVisibility(View.VISIBLE);

                    }
                })
                .build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }




    private void initBannerADs() {

        if (AdsUtility.isNetworkAvailable(this)) {
            adView = new AdView(this);
            LinearLayout mAdView = (LinearLayout) findViewById(R.id.adView);
            mAdView.setVisibility(View.VISIBLE);
            AdsUtility.ADMOB_LARGE_BANNER(adView, mAdView, getResources().getString(R.string.banners_id));
        }
    }


    @Override
    protected void onResume()
    {
        if(adView != null)
        {
            adView.resume();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if(adView != null)
        {
            adView.pause();
        }
        if(adView != null)
        {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if(adView != null)
        {
            adView = null;
        }
        if(adLoader != null)
        {
            adLoader = null;
        }
        if(rewardedAd != null)
        {
            rewardedAd = null;
        }
        super.onDestroy();
    }
}
