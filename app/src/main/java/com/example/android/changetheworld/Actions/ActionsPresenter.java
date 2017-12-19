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
            changeApi.getActions().enqueue(new Callback<ActionsListEntity>() {
                @Override
                public void onResponse(Call<ActionsListEntity> call,Response<ActionsListEntity> response) {
                    if (response.isSuccessful()) {
                        ActionsListEntity actionsListEntity = response.body();
                        actionsView.showMessage("deu certo meu chapa1");
                        if (actionsListEntity != null) {
                            actionsView.updateList(actionsListEntity.getActions());
                            actionsView.showMessage("deu certo meu chapa2");

                        }

                        //Toast.makeText(Actions.this, "DEU CERTO!!!!!!", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        actionsView.showMessage("conecta mas falha");

                    }
                }

                @Override
                public void onFailure(Call<ActionsListEntity> call,Throwable  t) {
                    actionsView.showMessage("nem conecta bixo");

                }
            });

    }
}
