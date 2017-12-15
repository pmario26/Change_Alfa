package com.example.android.changetheworld.Actions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.view.View;


import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;
import com.example.android.changetheworld.R;
import com.example.android.changetheworld.network.api.ChangeApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Actions extends AppCompatActivity {

    @BindView(R.id.rv_actions)
    RecyclerView rvActions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);
        //dothething();
        Toast.makeText(Actions.this, "OLA VOCE", Toast.LENGTH_SHORT).show();

    }
    void dothething(){
        final ChangeApi changeApi = ChangeApi.getInstance();
        changeApi.getActions().enqueue(new Callback<ActionsListEntity>() {
            @Override
            public void onResponse(Call<ActionsListEntity> call, Response<ActionsListEntity> response) {
                if (response.isSuccessful()) {
                    ActionsListEntity actionsListEntity = response.body();
                    Toast.makeText(Actions.this, "DEU CERTO!!!!!!", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(Actions.this, "NOPE, N FUNFOU", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ActionsListEntity> call, Throwable t) {
                Toast.makeText(Actions.this, "Voce n ta com sorte mesmo", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void updateList(final List<ActionsEntity> actionsList) {
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(Actions.this, "Clique Rápido", Toast.LENGTH_SHORT).show();
            }
        } );

        rvActions.setAdapter(actionsAdapter);
        // criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvActions.setLayoutManager(layoutManager);
    }

}



