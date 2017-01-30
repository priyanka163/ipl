package com.example.bridgelabz.newiplproject.Controller;

import android.util.Log;

import com.example.bridgelabz.newiplproject.Interface.DemoInterface;
import com.example.bridgelabz.newiplproject.Model.TeamModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 23/11/16.
 */

public class TeamController
{
    // Get a reference to our posts
    FirebaseDatabase database=FirebaseDatabase.getInstance();

    DatabaseReference reference=database.getReference("ipl");

    public DatabaseReference getReference(final DemoInterface demoInterface) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<TeamModel>> ref=new GenericTypeIndicator<ArrayList<TeamModel>>() {
                };
                ArrayList<TeamModel> arrayList=new ArrayList<TeamModel>();
                arrayList.addAll(dataSnapshot.getValue(ref));

                demoInterface.requireData(arrayList);
                for (int i = 0; i < arrayList.size(); i++) {
                    Log.i("hi",arrayList.get(i).getOwner());
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return reference;
    }
}

