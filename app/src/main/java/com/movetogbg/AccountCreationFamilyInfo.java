package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AccountCreationFamilyInfo extends AppCompatActivity {

    TextView tvTitle, tvContent;
    Spinner spinnerPartner;
    CheckBox checkbox, kidsAge6, kidsAge18, kidsAge21, kidsAge21Above;

    Button btn_continue;

    LinearLayout linearLayout_partnerKid, linearLayout_kidsAge;

    CheckBox[] checkBoxeKids;

    Boolean inTransition = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount_familyinfo);
        fadeInClass();
        initObjects();
        setSpinnerObjects();
        checkBoxHandler();
    }

    private void checkBoxHandler(){
        linearLayout_partnerKid = findViewById(R.id.layout_partnerkids);
        linearLayout_kidsAge = findViewById(R.id.layout_kidsage);

        linearLayout_partnerKid.setVisibility(View.GONE);
        linearLayout_kidsAge.setVisibility(View.GONE);

        checkbox = findViewById(R.id.checkBox);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    linearLayout_partnerKid.setVisibility(View.VISIBLE);
                }else{
                    linearLayout_partnerKid.setVisibility(View.GONE);
                    linearLayout_kidsAge.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setSpinnerObjects(){
        spinnerPartner = findViewById(R.id.spinnerPartner);

        final String[] kidsQuestion = getResources().getStringArray(R.array.kidsQuestion);

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.spinner_textview, kidsQuestion);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPartner.setAdapter(adapter);
        spinnerPartner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 1){
                    linearLayout_kidsAge.setVisibility(View.VISIBLE);
                }else{
                    linearLayout_kidsAge.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initObjects(){
        String[] kidsAge = getResources().getStringArray(R.array.kidsAgeBracket);

        tvTitle = findViewById(R.id.tvWelcomeTitle);
        tvContent = findViewById(R.id.tvWelcomeContent);
        btn_continue = findViewById(R.id.button_continue);

        String[] titleText = getResources().getStringArray(R.array.UserInfoPage2);

        tvTitle.setText(titleText[0]);
        tvContent.setText(titleText[1]);


        kidsAge6 = findViewById(R.id.checkBoxTo6);
        kidsAge18 = findViewById(R.id.checkBoxTo18);
        kidsAge21 = findViewById(R.id.checkBoxTo21);
        kidsAge21Above = findViewById(R.id.checkBoxTo21Plus);

        kidsAge6.setText(kidsAge[0]);
        kidsAge18.setText(kidsAge[1]);
        kidsAge21.setText(kidsAge[2]);
        kidsAge21Above.setText(kidsAge[3]);

        checkBoxeKids = new CheckBox[]{kidsAge6, kidsAge18, kidsAge21, kidsAge21Above};

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition.hideKeyboard(AccountCreationFamilyInfo.this);
                if(!inTransition) {
                    inTransition = true;
                    Transition.fadeOutToClass(AccountCreationFamilyInfo.this, (RelativeLayout) findViewById(R.id.relativeLayout), MainMenu.class);
                }
            }
        });
    }

    private void fadeInClass(){
        Transition.fadeInFromClass(this, (RelativeLayout) findViewById(R.id.relativeLayout));
    }
}
