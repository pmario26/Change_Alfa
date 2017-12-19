package com.example.android.changetheworld.network.api;

import com.example.android.changetheworld.Entity.ActionsDetailsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;
import com.example.android.changetheworld.network.service.ChangeService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pmario on 13/12/17.
 */

public class ChangeApi {
    private static ChangeApi instance;
    private  String sessionToken;
    private ChangeService changeService;

    public static ChangeApi getInstance() {
        if (instance == null){
            instance = new ChangeApi();
        }
        return instance;
    }

    private ChangeApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dl.dropboxusercontent.com/s/50vmlj7dhfaibpj/")
                .addConverterFactory(defaultConvertFactory())
                .build();
        this.changeService = retrofit.create(ChangeService.class);
    }

    private Converter.Factory defaultConvertFactory() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return GsonConverterFactory.create(gson);
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public Call<ActionsListEntity> getActions(){
        return changeService.getActions(getSessionToken());
    }

    public Call<ActionsDetailsEntity> getActionsDetail(long id) {
        return changeService.getActionsDetail(sessionToken,id);
    }
}
