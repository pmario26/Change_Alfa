package com.example.android.changetheworld.ActionsDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.changetheworld.Entity.ActionsDetailsEntity;
import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsDetails extends AppCompatActivity implements ActionsDetailsView{
    @BindView(R.id.image_view_header)
    ImageView  imgHeader;
    @BindView(R.id.text_view_description)
    TextView tvDescription;
    @BindView(R.id.text_view_site)
    TextView tvSite;

    ActionsDetailsPresenter actionsDetailsPresenter;
    ActionsEntity actionsEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions_details);
        ButterKnife.bind(this);
        /*
        Intent intent = getIntent();
        Long id = intent.getLongExtra("id", -1);
        showMessage(id.toString());
        */
        Intent intent = getIntent();
        actionsEntity = (ActionsEntity) intent.getSerializableExtra("acao_social");


        //actionsDetailsPresenter = new ActionsDetailsPresenter();
        //actionsDetailsPresenter.getActionsDetails(id);

        showDetails(actionsEntity);
    }

    @Override
    public void showDetails(ActionsDetailsEntity actionsDetailsEntity) {
        tvDescription.setText(actionsDetailsEntity.getDescription());
        tvSite.setText(actionsDetailsEntity.getSite());
        Picasso.with(this)
                .load(actionsDetailsEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        setTitle(actionsDetailsEntity.getName());
        showMessage("to aqui");
    }


    public void showDetails(ActionsEntity actionsEntity) {
        tvDescription.setText(actionsEntity.getDescription());
        tvSite.setText(actionsEntity.getSite());
        Picasso.with(this)
                .load(actionsEntity.getImage())
                .centerCrop()
                .fit()
                .into(imgHeader);
        setTitle(actionsEntity.getName());
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}
