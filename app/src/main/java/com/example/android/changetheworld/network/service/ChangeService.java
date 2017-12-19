package com.example.android.changetheworld.network.service;

import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


/**
 * Created by pmario on 13/12/17.
 */

public interface ChangeService {
    @GET("sociais.json")
    Call<ActionsListEntity> getActions(@Header("Authorization") String sessionToken);
}
