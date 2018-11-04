package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CategorySocial extends AppCompatActivity {


    ListView listView;
    ArrayList<String> titles, content;
    String[][] eduInformation;
    String[] eduTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorysocial);
        initObjects();
    }


    private void initObjects(){
        eduInformation = new String[][]{getResources().getStringArray(R.array.language),
                getResources().getStringArray(R.array.accommodation),
                //getResources().getStringArray(R.array.accommodation_singapore),
                getResources().getStringArray(R.array.genderEquality), getResources().getStringArray(R.array.publicTransport), getResources().getStringArray(R.array.workPermit_family_EU)
        };
        eduTitles = new String[]{"English Language", "Accommodation",
               // "Accommodation",
                "Gender Equality", "Public Transport", "Work Permit for the Family"
        };

        titles = new ArrayList<String>();
        content = new ArrayList<String>();

        for(int i = 0; i < eduInformation.length; i++){
            for(String string : eduInformation[i]){
                titles.add(eduTitles[i]);
                content.add(string);
            }
        }


        listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(CategorySocial.this, titles.toArray(new String[0]), content.toArray(new String[0]), R.drawable.icon_social);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }
}
