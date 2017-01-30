package com.example.bridgelabz.newiplproject.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bridgelabz.newiplproject.Adapters.PlayerAdapter;
import com.example.bridgelabz.newiplproject.Controller.PlayerController;
import com.example.bridgelabz.newiplproject.Interface.ClickListener;
import com.example.bridgelabz.newiplproject.Interface.PlayerInterface;
import com.example.bridgelabz.newiplproject.Model.PlayerModel;
import com.example.bridgelabz.newiplproject.Model.TeamModel;
import com.example.bridgelabz.newiplproject.R;
import com.example.bridgelabz.newiplproject.Utility.RecyclerTouchListener;
import com.example.bridgelabz.newiplproject.fragments.DisplayMemeber;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by bridgelabz on 25/11/16.
 */

public class Player extends Fragment {
    String name;
    ArrayList<PlayerModel> modelArrayList;
  //  private static final String DESCRIBABLE_KEY = "describable_key";
   // private PlayerModel mplayermodel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.player, container, false);

        // get the arguments by bundle from team
        name = this.getArguments().getString("hiii");

        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_player);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        PlayerController playerController = new PlayerController(name);// controller call

        playerController.getPlayerData(new PlayerInterface() {
            @Override
            public void getPlayerInfo(ArrayList<PlayerModel> arrayList) {
                Toast.makeText(getActivity(), "player class", Toast.LENGTH_SHORT).show();

                modelArrayList = arrayList;
                PlayerAdapter adapter = new PlayerAdapter(modelArrayList, getContext());
                recyclerView.setAdapter(adapter);
            }
        });


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                PlayerModel obj = modelArrayList.get(position);
                String player = obj.getPlayer_name();

                //  Bundle bundles = new Bundle();
                //  bundles.putSerializable("aDivision", (Serializable) obj);

                DisplayMemeber p = new DisplayMemeber();
                Fragment fragment = p.newInstance(obj);
                FragmentManager fragmngr = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmngr.beginTransaction();
                transaction.replace(R.id.recyclerviewdata, fragment).addToBackStack(null).commit();

              //   getFragmentManager().beginTransaction().replace(R.id.recyclerviewdata, new DisplayMemeber()).addToBackStack(null).commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

 /*   public void getplayerDisplay(PlayerModel playermodel) {
        Player fragmentplayer = new Player();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESCRIBABLE_KEY, playermodel);
        fragmentplayer.setArguments(bundle);

        // return fragmentplayer;
*/
    }
    //  return view;



