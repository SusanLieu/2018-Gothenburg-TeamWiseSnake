package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CategoryEducation extends AppCompatActivity {

    ListView listView;
    ArrayList<String> titles, content;
    String[][] eduInformation;
    String[] eduTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryeducation);
        initObjects();
    }

    private void initObjects(){
      eduInformation = new String[][]{getResources().getStringArray(R.array.education_user), getResources().getStringArray(R.array.education_partner), getResources().getStringArray(R.array.education_kid_16_19)};
        eduTitles = new String[]{"Education for yourself", "Education for your partner", "Education for your child"};

      titles = new ArrayList<String>();
      content = new ArrayList<String>();

      for(int i = 0; i < eduInformation.length; i++){
          for(String string : eduInformation[i]){
              titles.add(eduTitles[i]);
              content.add(string);
          }
      }


        listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(CategoryEducation.this, titles.toArray(new String[0]), content.toArray(new String[0]), R.drawable.icon_education);
        listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }
}
