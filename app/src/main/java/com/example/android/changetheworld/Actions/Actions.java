package com.example.android.changetheworld.Actions;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;


import com.example.android.changetheworld.ActionsDetails.ActionsDetails;
import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;
import com.example.android.changetheworld.R;
import com.example.android.changetheworld.network.api.ChangeApi;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Actions extends AppCompatActivity implements ActionsView{

    @BindView(R.id.rv_actions)
    RecyclerView rvActions;
    ActionsPresenter actionsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        ButterKnife.bind(this);
        actionsPresenter = new ActionsPresenter(this);
        actionsPresenter.updateList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_download, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_download:
                actionsPresenter.saveMovies();
            default:
                return super.onOptionsItemSelected(item);
        }


    }


    public void updateList(final List<ActionsEntity> actionsList) {
        ActionsAdapter actionsAdapter = new ActionsAdapter(actionsList, this);
        actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                /*
                Intent intent = new Intent(Actions.this, ActionsDetails.class);
                intent.putExtra("id", actionsList.get(position).getId());
                startActivity(intent);
                */
                Intent intent = new Intent(Actions.this, ActionsDetails.class);
                intent.putExtra("acao_social", (Serializable) actionsList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int adapterPosition) {

            }
        } );

        rvActions.setAdapter(actionsAdapter);
        // criação do gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvActions.setLayoutManager(layoutManager);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveMoviesInSharedPreferences(String jsonActionsEntity) {
        SharedPreferences.Editor editor = getSharedPreferences("acoes_sociais", MODE_PRIVATE).edit();
        editor.putString("acoes_sociais_json",jsonActionsEntity);
        editor.apply();
        showMessage("Informações salvas!");
    }

    @Override
    public void openActionsOffline() {
        SharedPreferences preferences =
                getSharedPreferences("acoes_sociais",
                        MODE_PRIVATE);
        String jsonActions =
                preferences.getString("acoes_sociais_json",
                        null);
    }

    @Override
    public String getSavedActions() {
        SharedPreferences preferences =
                getSharedPreferences("acoes_sociais",
                        MODE_PRIVATE);
        String jsonActions =
                preferences.getString("acoes_sociais_json",
                        null);
        showMessage("mandando string");
        return jsonActions;

    }


}



