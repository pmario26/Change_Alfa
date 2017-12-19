package com.example.android.changetheworld.SplashScreen;

import android.os.Handler;

import com.example.android.changetheworld.network.api.ChangeApi;

/**
 * Created by pmario on 19/12/17.
 */

public class SplashScreenPresenter {
    SplashScreenView splashScreenView;

    public SplashScreenPresenter(SplashScreenView splashScreenView) {
        this.splashScreenView = splashScreenView;
    }

    public void loadActions(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                final ChangeApi changeApi = ChangeApi.getInstance();

                splashScreenView.openActions();
            }
        },2000);
    }
}
