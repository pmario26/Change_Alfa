package com.example.android.changetheworld.SplashScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.changetheworld.Actions.Actions;
import com.example.android.changetheworld.R;

public class SplashScreen extends AppCompatActivity implements SplashScreenView{
    SplashScreenPresenter splashScreenPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreenPresenter = new SplashScreenPresenter(this);
        splashScreenPresenter.loadActions();

    }

    @Override
    public void openActions() {
        Intent actions = new Intent(SplashScreen.this, Actions.class);
        startActivity(actions);
        finish();
    }
}
