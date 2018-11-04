package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryWork extends AppCompatActivity {


    ListView listView;
    ArrayList<String> titles, content;
    String[][] eduInformation;
    String[] eduTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorywork);
        initObjects();
    }

    private void initObjects(){
        eduInformation = new String[][]{getResources().getStringArray(R.array.jobSecurity), getResources().getStringArray(R.array.employeesRights), getResources().getStringArray(R.array.annual_leave), getResources().getStringArray(R.array.pension)};
        eduTitles = new String[]{"Job Security", "Employees Rights", "Annual Leave", "Pension"};


        titles = new ArrayList<String>();
        content = new ArrayList<String>();

        for(int i = 0; i < eduInformation.length; i++){
            for(String string : eduInformation[i]){
                titles.add(eduTitles[i]);
                content.add(string);
            }
        }


        listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(CategoryWork.this, titles.toArray(new String[0]), content.toArray(new String[0]), R.drawable.icon_work);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }
}
