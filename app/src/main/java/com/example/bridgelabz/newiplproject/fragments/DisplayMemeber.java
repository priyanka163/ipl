package com.example.bridgelabz.newiplproject.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bridgelabz.newiplproject.Adapters.PlayerAdapter;
import com.example.bridgelabz.newiplproject.Controller.PlayerController;
import com.example.bridgelabz.newiplproject.Interface.PlayerInterface;
import com.example.bridgelabz.newiplproject.Model.PlayerModel;
import com.example.bridgelabz.newiplproject.R;
import com.example.bridgelabz.newiplproject.Utility.PlayerImage;
import com.example.bridgelabz.newiplproject.view.Player;
import com.example.bridgelabz.newiplproject.view.Team;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 3/12/16.
 */

public class DisplayMemeber extends Fragment {
    String name;
     PlayerModel mPlayer;
    private static final String DESCRIBABLE_KEY = "describable_key";
    ArrayList<PlayerModel> modelArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      /*  Bundle bundle = getArguments();
        PlayerModel division= (PlayerModel) bundle.getSerializable("aDivision");
        Log.e("division TEST", "" + division.getPlayer_img_url());
        Log.e("division TEST", "" + division.getPlayer_img_url());
        Log.e("division TEST", "" + division.getPlayer_bowling_style());
        Log.e("division TEST", "" + division.getPlayer_name());

*/
        mPlayer = (PlayerModel) getArguments().getSerializable(
                "key");
        View mview = inflater.inflate(R.layout.singleimage, container, false);
        TextView dabba = (TextView) mview.findViewById(R.id.laxman);
        dabba.setText(mPlayer.getPlayer_bowling_style());
TextView textView= (TextView) mview.findViewById(R.id.texttwo);
        textView.setText(mPlayer.getPlayer_name());
        TextView textViewthree= (TextView) mview.findViewById(R.id.textthree);
        textViewthree.setText(mPlayer.getPlayer_role());
        TextView textViewfour= (TextView) mview.findViewById(R.id.textfour);
        textViewfour.setText(mPlayer.getPlayer_nationality());
        TextView textViewx= (TextView) mview.findViewById(R.id.textfive);
        textViewx.setText(mPlayer.getPlayer_batting_style());
       // TextView textViewy= (TextView) mview.findViewById(R.id.textsix);
        //textViewy.setText(mPlayer.getPlayer_img_url());

        ImageView image= (ImageView) mview.findViewById(R.id.image);

        // PlayerImage pimg=new PlayerImage();
        //players.getDownloadImage(playerModel.getPlayer_img_url(), holder);
       PlayerImage.getimageplayer(mPlayer.getPlayer_img_url(), image);

//image.setImageBitmap();
        return mview;
    }


    public static Fragment newInstance(PlayerModel player) {
        //    Player player1=new Player();
        DisplayMemeber member = new DisplayMemeber();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key", player);
        member.setArguments(bundle);
        return member;
    }

}
