package com.example.bridgelabz.newiplproject.Utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.example.bridgelabz.newiplproject.Adapters.PlayerAdapter;
import com.example.bridgelabz.newiplproject.Adapters.TeamAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by bridgelabz on 25/11/16.
 */

public class PlayerImage {
   public StorageReference childreference;
    static Bitmap bitmap=null;

    private static final String TAG="Downloadimage";

    public  void getDownloadImage(final String Playerlogo, final PlayerAdapter.MyViewHolder holder){
        // ImageUtil   imageUtil = new ImageUtil();
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference=storage.getReference();

        childreference =storageReference.child(Playerlogo);

        final long oneMEGA_BYTE=1024*1024;

        childreference.getBytes(oneMEGA_BYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                // Log.e(TAG, "onSuccess: Image downloaded");
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                Log.i(TAG,"onSucess image download");
                holder.mImage.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Download", "onFailure: ",e );
            }
        });
    }

    public static void getimageplayer(String url, final ImageView view)
    {
         StorageReference childreference;
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference=storage.getReference();

        childreference =storageReference.child(url);

        final long oneMEGA_BYTE=1024*1024;

        childreference.getBytes(oneMEGA_BYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                // Log.e(TAG, "onSuccess: Image downloaded");
                 bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                view.setImageBitmap(bitmap);

                Log.i(TAG,"onSucess image download");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Download", "onFailure: ",e );
            }
        });


    }
}
