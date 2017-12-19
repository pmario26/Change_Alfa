package com.example.android.changetheworld.Actions;

import android.view.View;

/**
 * Created by pmario on 15/12/17.
 */

public interface OnRecyclerViewSelected {
    void onClick(View view, int position);

    void onLongClick(View view, int adapterPosition);
}
