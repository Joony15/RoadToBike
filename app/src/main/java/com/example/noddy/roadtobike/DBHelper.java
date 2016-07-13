package com.example.noddy.roadtobike;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zdh32_000 on 2016-07-05.
 */
public class DBHelper extends SQLiteOpenHelper{

    public SQLiteDatabase msqlite;

    public DBHelper(Context context){
        super(context, "H_Wifi.db", null, 1);
        msqlite = this.getWritableDatabase();

    }


    @Override
    //앱 실행시 DB생성 처음 생성하면 그 뒤로는 기존 테이블에 계속해서 업데이트 되는식.
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE H_Wifi(" +
                "Name TEXT,"+
                "Location TEXT,"+
                "Wi TEXT ,"+
                "Kyung TEXT,"+
                "PRIMARY KEY(Wi,Kyung))");

        db.execSQL("CREATE TABLE H_Bike(" +
                "Name TEXT,"+
                "Location TEXT,"+
                "Wi TEXT ,"+
                "Kyung TEXT,"+
                "PRIMARY KEY(Wi,Kyung))");

        db.execSQL("CREATE TABLE H_Toilet(" +
                "Name TEXT,"+
                "Location TEXT,"+
                "Wi TEXT ,"+
                "Kyung TEXT,"+
                "PRIMARY KEY(Wi,Kyung))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Road");
        onCreate(db);
    }
}