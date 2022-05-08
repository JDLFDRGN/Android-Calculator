package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CalcHistory extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_history);
        DbHelper dbHelper = new DbHelper(this);
        Cursor cursor = dbHelper.getHistory();
        cursor.moveToFirst();

        listView = (ListView)findViewById(R.id.historyList);
        ArrayList arrayList = new ArrayList();
        while(cursor.moveToNext()){
            arrayList.add(cursor.getString(1));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
}