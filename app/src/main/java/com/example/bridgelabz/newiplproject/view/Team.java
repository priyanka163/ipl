package com.example.bridgelabz.newiplproject.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.bridgelabz.newiplproject.Adapters.TeamAdapter;
import com.example.bridgelabz.newiplproject.Controller.TeamController;
import com.example.bridgelabz.newiplproject.Interface.ClickListener;
import com.example.bridgelabz.newiplproject.Interface.DemoInterface;
import com.example.bridgelabz.newiplproject.Model.TeamModel;
import com.example.bridgelabz.newiplproject.R;
import com.example.bridgelabz.newiplproject.Utility.RecyclerTouchListener;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 23/11/16.
 */
public class Team extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    RecyclerView mRecyclerView;
    private Context mContext;
    ArrayList<TeamModel> data;

    public Team() {
    }

    public Team(ProgressDialog mProgressDialog) {
        Log.i("cons","hiiiii");
        this.mProgressDialog = mProgressDialog;
    }

    public  void callProgress(){
        mProgressDialog=new ProgressDialog(Team.this);
        mProgressDialog.setMessage("Progressing....");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);


        callProgress();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewone);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        TeamController controller=new TeamController();//call to interface
        //interface method is implemented here
        controller.getReference(new DemoInterface() {
            @Override
            public void requireData(ArrayList<TeamModel> array) {

                data =array;
                mProgressDialog.dismiss();

                TeamAdapter adapter=new TeamAdapter(data, Team.this);
                mRecyclerView.setAdapter(adapter);
               // mProgressDialog.dismiss();

            }
        });


//on click process to move from one fragment to another
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TeamModel teamModel=data.get(position);
                String name=teamModel.getTeamname();

               // Toast.makeText(Team.this, "on clickkkk", Toast.LENGTH_SHORT).show();
                //pass the teamname through bundle to player frag
              Bundle bundle=new Bundle();
                bundle.putString("hiii",name);
                Player player=new Player();
                player.setArguments(bundle);

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_team, player).addToBackStack(null).commit();

            }

            @Override
            public void onLongClick(View view, int position) {

            }


        }));



    }

   /* public void setFragment(){
                      ((Team)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Player()).commit();

    }*/
}