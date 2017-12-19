package com.example.android.changetheworld.network.service;

import com.example.android.changetheworld.Entity.ActionsDetailsEntity;
import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


/**
 * Created by pmario on 13/12/17.
 */

public interface ChangeService {
    @GET("sociais.json")
    Call<ActionsListEntity> getActions(@Header("Authorization") String sessionToken);
    @GET("sociais.json")
    Call<ActionsDetailsEntity> getActionsDetail(@Header("Authorization") String sessionToken,
                                                @Query("id") long id) ;
}
