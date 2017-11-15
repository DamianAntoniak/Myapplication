package com.example.damia.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by damia on 07/07/2017.
 */

public class DatebaseHelper extends SQLiteOpenHelper {

    public static final String database_name = "Kalkulator";
    public static final String database_table = "Historia";


    public DatebaseHelper(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + database_table + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Zlitry DOUBLE, Pkm DOUBLE, Cena DOUBLE, Cenal DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + database_table);
        onCreate(db);
    }

    public void setInsert(double zlitry, double pkm, double cena, double cenal)
    {
        Log.i("f", "dodajemy");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Zlitry", zlitry);
        cv.put("Pkm", pkm);
        cv.put("Cena", cena);
        cv.put("Cenal", cenal);
        db.insert(database_table, null, cv);
    }

    public SQLiteCursor getDate()
    {
        SQLiteDatabase db = this. getWritableDatabase();
        SQLiteCursor cursor = (SQLiteCursor) db.rawQuery("SELECT * FROM " + database_table, null);
        return cursor;
    }
}
