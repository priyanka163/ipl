package com.example.bridgelabz.newiplproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bridgelabz.newiplproject.Controller.TeamController;
import com.example.bridgelabz.newiplproject.Interface.DemoInterface;
import com.example.bridgelabz.newiplproject.Model.TeamModel;

import java.util.ArrayList;

/**
 * Created by bridgelabz on 2/12/16.
 */

public class DatabaseSql extends SQLiteOpenHelper {
    private static final int DB_Version = 1;
    private static final String DATABASE_Name = "IPL_Data";
    private static final String Key_id = "ID";
    private static final String Table_Name = "LocalData";
    private static final String Key_Name = "LocalData";
    private static final String Key_owener = "LocalData";
    private static final String Key_Teamname = "LocalData";

    SQLiteDatabase sqLiteDatabase;


    public DatabaseSql(Context context) {
        super(context, DATABASE_Name, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CreateTable" + Table_Name + "(" + Key_Name + "text" + Key_owener + "text" + Key_Teamname + "text" + ")";
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table if exists" + Table_Name);

    }

  /*  public void insertData() {
        sqLiteDatabase = getWritableDatabase();
        final ContentValues cv = new ContentValues();
        TeamController cntrl = new TeamController();
        cntrl.getReference(new DemoInterface() {
            @Override
            public void requireData(ArrayList<TeamModel> array) {
                ArrayList<TeamModel> teamModels = array;

                for (int i = 0; i < array.size(); i++) {
                    TeamModel model = teamModels.get(i);


                });

                cv.put(Key_Name, model.get);
                cv.put(Key_owener);
                cv.put(Key_Teamname);
            }
        }*/
}
