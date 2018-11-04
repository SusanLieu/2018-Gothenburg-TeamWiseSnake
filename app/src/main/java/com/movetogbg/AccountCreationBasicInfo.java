package com.movetogbg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AccountCreationBasicInfo extends AppCompatActivity {

    TextView tvTitle, tvContent;
    Spinner spinnerGender;
    Button continue_button;

    EditText inputName, inputAge;

    String UserGender = null;

    boolean inTransition = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount_basicinfo);
        fadeInClass();
        initObjects();
        setSpinnerObjects();
    }

    private void validateInput(){
        if(inputName.getText().toString().length() > 0 && inputAge.getText().toString().length() > 0 && UserGender != null && !inTransition){
            Account.setUserName(inputName.getText().toString());
            Account.setUserAge(inputAge.getText().toString());
            Account.setUserGender(UserGender);
            Transition.fadeOutToClass(this, (RelativeLayout) findViewById(R.id.relativeLayout), AccountCreationFamilyInfo.class);
            inTransition = true;
        }
    }

    private void setSpinnerObjects(){
        spinnerGender = findViewById(R.id.spinnerGender);

        final String[] genders = {"Select your sex", "Male","Female"};

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.spinner_textview, genders);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGender.setAdapter(adapter);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    UserGender = genders[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initObjects(){
        tvTitle = findViewById(R.id.tvWelcomeTitle);
        tvContent = findViewById(R.id.tvWelcomeContent);
        continue_button = findViewById(R.id.button_continue);

        inputName = findViewById(R.id.editTextName);
        inputAge = findViewById(R.id.editTextAge);

        String[] titleText = getResources().getStringArray(R.array.UserInfoPage1);

        tvTitle.setText(titleText[0]);
        tvContent.setText(titleText[1]);
        continue_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });

    }

    private void fadeInClass(){
        Transition.fadeInFromClass(this, (RelativeLayout) findViewById(R.id.relativeLayout));
    }
}
