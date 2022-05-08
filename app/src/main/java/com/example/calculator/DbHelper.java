package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper{

    public DbHelper(Context context) {
        super(context, "calculator", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE history(history_id integer PRIMARY KEY AUTOINCREMENT, history_data text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Calculator");
        onCreate(sqLiteDatabase);
    }

    public int insertHistory(String txt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("history_data", txt);
        long check = db.insert("history", null, cv);
        db.close();
        if(check == -1) return 0;
        else return 1;
    }
    public Cursor getHistory(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM history", null);
        return cursor;
    }
}
