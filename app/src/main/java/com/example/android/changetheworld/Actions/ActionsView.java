package com.example.android.changetheworld.Actions;

import com.example.android.changetheworld.Entity.ActionsEntity;
import com.example.android.changetheworld.Entity.ActionsListEntity;

import java.util.List;

/**
 * Created by pmario on 16/12/17.
 */

public interface ActionsView {
    void updateList(List<ActionsEntity> actionsList);

    void showMessage(String s);

    void saveMoviesInSharedPreferences(String jsonActionsEntity);

    void openActionsOffline();

    String getSavedActions();
}
