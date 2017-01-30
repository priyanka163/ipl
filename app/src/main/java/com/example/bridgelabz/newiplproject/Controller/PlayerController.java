package com.example.bridgelabz.newiplproject.Controller;

import android.util.Log;

import com.example.bridgelabz.newiplproject.Interface.PlayerInterface;
import com.example.bridgelabz.newiplproject.Model.PlayerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 25/11/16.
 */

public class PlayerController {
    String teamname;
    DatabaseReference reference;

    //to initialize teamvariable taken constructor
    public PlayerController(String teamname) {
        this.teamname = teamname;
        passData();
    }



    public PlayerController() {
    }

private void passData(){
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    reference=firebaseDatabase.getReference(teamname);//teamname is passed from team class
    Log.i("image",teamname);

}
    public  void  getPlayerData(final PlayerInterface playerInterface){


        Log.i("hello",teamname);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<PlayerModel>> array= new GenericTypeIndicator<ArrayList<PlayerModel>>() {

                };
                ArrayList<PlayerModel> playerdatas = new ArrayList<PlayerModel>();

                playerdatas.addAll(dataSnapshot.getValue(array));
                // data sent to d adapters through interfcae
                playerInterface.getPlayerInfo(playerdatas);

                /*for (int i = 0; i < playerdatas.size(); i++) {
                    Log.i("priiiii",playerdatas.get(i).getPlayer_name());
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
