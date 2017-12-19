package com.example.android.changetheworld.ActionsDetails;

import com.example.android.changetheworld.Entity.ActionsDetailsEntity;
import com.example.android.changetheworld.network.api.ChangeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pmario on 19/12/17.
 */

public class ActionsDetailsPresenter {

    ActionsDetailsView actionsDetailsView;
    private ActionsDetailsEntity actionsDetailsEntity;

    public void getActionsDetails(Long id) {
        final ChangeApi changeApi = ChangeApi.getInstance();
        changeApi.getActionsDetail(id).enqueue(new Callback<ActionsDetailsEntity>() {
            @Override
            public void onResponse(Call<ActionsDetailsEntity> call, Response<ActionsDetailsEntity> response) {
                actionsDetailsEntity = response.body();
                if (actionsDetailsEntity != null) {
                    actionsDetailsView.showDetails(actionsDetailsEntity);
                }
                else {
                    actionsDetailsView.showMessage("Falha ao carregar informações");
                }
            }

            @Override
            public void onFailure(Call<ActionsDetailsEntity> call, Throwable t) {
                actionsDetailsView.showMessage("Falha de acesso ao servidor");

            }
        });
    }
}
