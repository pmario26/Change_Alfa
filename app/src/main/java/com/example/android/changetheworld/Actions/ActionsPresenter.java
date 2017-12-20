package com.example.android.changetheworld.Actions;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;
import com.example.android.changetheworld.network.api.ChangeApi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pmario on 16/12/17.
 */

public class ActionsPresenter {
    private ActionsView actionsView;
    private List<ActionsEntity> actionsList = new ArrayList<>();
    ActionsListEntity actionsListEntity;

    public ActionsPresenter(ActionsView actionsView) {
        this.actionsView = actionsView;
    }

    void updateList(){
            final ChangeApi changeApi = ChangeApi.getInstance();
            actionsView.showLoading();
            changeApi.getActions().enqueue(new Callback<ActionsListEntity>() {
                @Override
                public void onResponse(Call<ActionsListEntity> call,Response<ActionsListEntity> response) {
                    if (response.isSuccessful()) {
                        ActionsListEntity actionsListEntity = response.body();
                        if (actionsListEntity != null) {
                            actionsView.updateList(actionsListEntity.getActions());

                        }

                        //Toast.makeText(Actions.this, "DEU CERTO!!!!!!", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        actionsView.showMessage("Falha após a conexão");

                    }
                    actionsView.hideLoading();
                }

                @Override
                public void onFailure(Call<ActionsListEntity> call,Throwable  t) {
                    actionsView.showMessage("Falha na conexão com o servidor");
                    /*
                    String jsonActions = actionsView.getSavedActions();
                    actionsView.showMessage("pegando string");
                    ActionsListEntity actionsListEntity = new Gson().fromJson(jsonActions, ActionsListEntity.class);
                    if (actionsListEntity != null) {
                        actionsView.updateList(actionsListEntity.getActions());
                        actionsView.showMessage("deu certo meu chapa2");

                    }
                    */
                    actionsView.hideLoading();
                }
            });

    }

    public void saveMovies() {
        String jsonActionsEntity = new Gson().toJson(actionsListEntity);
        actionsView.saveMoviesInSharedPreferences(jsonActionsEntity);
    }
}
