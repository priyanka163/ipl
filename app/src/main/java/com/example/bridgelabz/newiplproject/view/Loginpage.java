package com.example.bridgelabz.newiplproject.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bridgelabz.newiplproject.R;

public class Loginpage extends AppCompatActivity {
    EditText mUsername,mPassword;
    Button mClick;
    String mData_username="";
    String mData_password="";
    String name;
    String pswrd;
     ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        mUsername= (EditText) findViewById(R.id.edit_email);
        mPassword= (EditText) findViewById(R.id.edit_password);
        mClick= (Button) findViewById(R.id.btn_signup);

        mClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=mUsername.getText().toString();
                pswrd=mPassword.getText().toString();

                if ((name.equals(mData_username))&& (pswrd.equals(mData_password))){

                    mUsername.setText("");
                    mPassword.setText("");
                    Toast.makeText(Loginpage.this, "Login Success", Toast.LENGTH_SHORT).show();


                   /* mProgressDialog=new ProgressDialog(Loginpage.this);
                    mProgressDialog.setMessage("Progressing....");
                    mProgressDialog.show();*/


              //     Team team = new Team(mProgressDialog);

                   Intent i=new Intent(Loginpage.this,Team.class);
                    startActivity(i);
                  //  getSupportFragmentManager().beginTransaction().replace(R.id.activity_loginpage,new ()).commit();

                    Loginpage.this.finish();


                }


                else {
                    Toast.makeText(Loginpage.this, " Incorrect username and password ", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}
