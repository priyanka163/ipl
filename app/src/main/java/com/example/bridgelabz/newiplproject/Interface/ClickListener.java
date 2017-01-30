package com.example.bridgelabz.newiplproject.Interface;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bridgelabz on 26/11/16.
 */

public interface ClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}

//public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener
