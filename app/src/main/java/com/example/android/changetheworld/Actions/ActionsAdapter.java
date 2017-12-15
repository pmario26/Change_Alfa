package com.example.android.changetheworld.Actions;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.ViewHolder;


import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pmario on 15/12/17.
 */

public class ActionsAdapter extends RecyclerView.Adapter<ActionsAdapter.ViewHolder>{
    private List<ActionsEntity> actionsList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;


    public ActionsAdapter(List<ActionsEntity> actionsList, Context context) {
        this.actionsList = actionsList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.action_name)
        TextView action_name;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.actions_list_item, parent, false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        ActionsEntity actionsEntity = actionsList.get(position);
        //holder.imgBackgroud.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return actionsList.size();
    }



    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }



}
