package com.google.android.ads.nativetemplates;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class AdsUtility {

    public static InterstitialAd mInterstitialAd;

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // 320 * 50
    public static void ADMOB_BANNER(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.BANNER);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }

    // 350 * 50
    public static void ADMOB_SMART_BANNER(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.SMART_BANNER);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }

    // 320 * 100
    public static void ADMOB_LARGE_BANNER(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.LARGE_BANNER);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }

    // 320 * 250
    public static void ADMOB_MEDIUM_RECTANGLE(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.MEDIUM_RECTANGLE);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }

    // 320 * 50
    public static void ADMOB_FULL_BANNER(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.FULL_BANNER);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }


    // NOT LOADED
    public static void ADMOB_LEADERBOARD(AdView adView, LinearLayout linerlayout, String admBanner) {
        adView.setAdUnitId(admBanner);
        adView.setAdSize(AdSize.LEADERBOARD);
        AdRequest.Builder builder = new AdRequest.Builder();
        adView.loadAd(builder.build());
        linerlayout.addView(adView);

    }

    public static void InterstitialAdmob(final InterstitialAd mInterstitialAd, String Interstitial) {
        mInterstitialAd.setAdUnitId(Interstitial);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

            }
        });
    }

    protected static void requestNewInterstitial(InterstitialAd mInterstitialAd) {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    public static void showIntestitialAds(InterstitialAd mInterstitialAd) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


    public static void RewardedAdmob(RewardedAd rewardedAd) {
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                Log.d("AdsUtilityLogs", "onRewardedAdLoaded");
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                Log.d("AdsUtilityLogs", "onRewardedAdFailedToLoad : " + errorCode);
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }
}



