package com.example.android.changetheworld.ActionsDetails;

import com.example.android.changetheworld.Entity.ActionsDetailsEntity;

/**
 * Created by pmario on 19/12/17.
 */

public interface ActionsDetailsView {
    void showDetails(ActionsDetailsEntity actionsDetailsEntity);

    void showMessage(String s);
}
