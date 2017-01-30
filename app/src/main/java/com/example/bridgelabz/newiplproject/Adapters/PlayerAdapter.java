package com.example.bridgelabz.newiplproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bridgelabz.newiplproject.Animationpackage.MyAnimation;
import com.example.bridgelabz.newiplproject.Model.PlayerModel;
import com.example.bridgelabz.newiplproject.Model.TeamModel;
import com.example.bridgelabz.newiplproject.R;
import com.example.bridgelabz.newiplproject.Utility.PlayerImage;

import java.util.ArrayList;

import static android.R.attr.animation;

/**
 * Created by bridgelabz on 25/11/16.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {
Animation animation;
    private ArrayList<PlayerModel> mData;
    private Context mContext;

    public PlayerAdapter(ArrayList<PlayerModel> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customplayer, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlayerModel playerModel = mData.get(position);

        holder.mName.setText(playerModel.getPlayer_name());
       /* holder.mDOB.setText(playerModel.getPlayer_dob());
        holder.mNationality.setText(playerModel.getPlayer_nationality());
        holder.mRole.setText(playerModel.getPlayer_role());
        holder.mBattingStyle.setText(playerModel.getPlayer_batting_style());
        holder.mBollingStyle.setText(playerModel.getPlayer_bowling_style());
*/


        animation= AnimationUtils.loadAnimation(mContext,R.anim.slide_up);
        holder.irelativeLayout.setAnimation(animation);
        holder.irelativeLayout.startAnimation(animation);


       // MyAnimation anim = new MyAnimation(holder.irelativeLayout,2000);
     // anim.setDuration(2000);
     //  holder.itemView.startAnimation(anim);


        PlayerImage players = new PlayerImage();

        players.getDownloadImage(playerModel.getPlayer_img_url(), holder);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mDOB, mBattingStyle, mBollingStyle, mNationality, mRole;
        public ImageView mImage;
        public RelativeLayout irelativeLayout;

        public MyViewHolder(View itemView) {


            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.Playername);

          /*  mBattingStyle = (TextView) itemView.findViewById(R.id.player_batting_style);
            mBollingStyle = (TextView) itemView.findViewById(R.id.player_bowling_style);

            mDOB = (TextView) itemView.findViewById(R.id.dob);
            mNationality = (TextView) itemView.findViewById(R.id.nationality);*/
            mImage = (ImageView) itemView.findViewById(R.id.image);
            /*mRole = (TextView) itemView.findViewById(R.id.role);*/
            irelativeLayout= (RelativeLayout) itemView.findViewById(R.id.relative);
        }
    }
}