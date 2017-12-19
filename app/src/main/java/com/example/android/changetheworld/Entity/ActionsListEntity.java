package com.example.android.changetheworld.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pmario on 13/12/17.
 */

public class ActionsListEntity {
    @SerializedName("acoes_sociais")
    @Expose
    private List<ActionsEntity> actions;

    public List<ActionsEntity> getActions() {
        return actions;
    }
}
