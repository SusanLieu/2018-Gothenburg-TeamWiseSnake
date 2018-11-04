package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryHealthcare extends AppCompatActivity {


    ListView listView;
    ArrayList<String> titles, content;
    String[][] eduInformation;
    String[] eduTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryhealthcare);
        initObjects();
    }

    private void initObjects(){
        eduInformation = new String[][]{getResources().getStringArray(R.array.healthCare), getResources().getStringArray(R.array.dentalCare_over25),
                getResources().getStringArray(R.array.dentalCare_under25)};
        eduTitles = new String[]{"General Health Care", "Dental Care for Over 25", "Dental Care for Under 25"};

        titles = new ArrayList<String>();
        content = new ArrayList<String>();

        for(int i = 0; i < eduInformation.length; i++){
            for(String string : eduInformation[i]){
                titles.add(eduTitles[i]);
                content.add(string);
            }
        }


        listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(CategoryHealthcare.this, titles.toArray(new String[0]), content.toArray(new String[0]), R.drawable.icon_healthcare);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }
}
