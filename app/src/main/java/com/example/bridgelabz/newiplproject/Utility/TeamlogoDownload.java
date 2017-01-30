package com.example.bridgelabz.newiplproject.Utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.bridgelabz.newiplproject.Adapters.TeamAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by bridgelabz on 24/11/16.
 */

public class TeamlogoDownload {
     StorageReference childreference;
    private static final String TAG="Downloadimage";

    public  void getDownloadImage(final String Teamlogos, final TeamAdapter.MyViewHolder holder){
     // ImageUtil   imageUtil = new ImageUtil();
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference=storage.getReference();

         childreference =storageReference.child(Teamlogos);

        final long oneMEGA_BYTE=1024*1024;

         childreference.getBytes(oneMEGA_BYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
             @Override
             public void onSuccess(byte[] bytes) {
                // Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                // Log.e(TAG, "onSuccess: Image downloaded");
                 Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                 Log.i(TAG,"onSucess image download");
                 holder.mImageView.setImageBitmap(bitmap);
             }
         }).addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 Log.e("Download", "onFailure: ",e );
             }
         });
    }

}
