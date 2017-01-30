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

import com.example.bridgelabz.newiplproject.Model.TeamModel;
import com.example.bridgelabz.newiplproject.R;
import com.example.bridgelabz.newiplproject.Utility.TeamlogoDownload;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 22/11/16.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    Animation animation;

    public TeamAdapter(ArrayList<TeamModel> mData, Context context) {
        this.mData = mData;
        this.mContext = context;
    }


    private ArrayList<TeamModel> mData;
    private Context mContext;

    @Override
    public TeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(TeamAdapter.MyViewHolder holder, int position) {
        TeamModel teamModel = mData.get(position);
        holder.mTextview.setText(teamModel.getOwner());

        holder.mTextview.setText(teamModel.getTeamname());
        //String logourl=teamModel.getUrl();

       animation= AnimationUtils.loadAnimation(mContext,R.anim.zoom_in);
        holder.relativeLayout.setAnimation(animation);
        holder.relativeLayout.startAnimation(animation);


        TeamlogoDownload logo = new TeamlogoDownload();

        logo.getDownloadImage(teamModel.getUrl(), holder);

//        MyAnimation anim = new MyAnimation(holder.mImageView,2000);
//        anim.setDuration(3000);
//        holder.itemView.startAnimation(anim);

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(mContext, "ONCLICK", Toast.LENGTH_SHORT).show();
//               ((Team)mContext).getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Player()).commit();
                // ((Team)mContext).setFragment();
            }
        });

//

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextview;
        public ImageView mImageView;
        public RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.image);
            mTextview = (TextView) itemView.findViewById(R.id.name);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativ);


        }

    }
}
