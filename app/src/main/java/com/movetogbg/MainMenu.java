package com.movetogbg;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainMenu extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    CardView butHealth, butEducation, butSocial, butWork, butExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        Transition.fadeInFromClass(this, (RelativeLayout) findViewById(R.id.relativeLayout));
        initObjects();
        onClickListernersButtons();
    }

    private void onClickListernersButtons(){
        butHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, CategoryHealthcare.class));
            }
        });

        butEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, CategoryEducation.class));
            }
        });

        butSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, CategorySocial.class));
            }
        });

        butWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, CategoryWork.class));
            }
        });
        butExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MapsActivityMap.class));
            }
        });
    }

    private void initObjects(){
        butHealth = findViewById(R.id.buttonCatHealth);
        butEducation = findViewById(R.id.buttonCatEducation);
        butSocial = findViewById(R.id.buttonCatSocial);
        butWork = findViewById(R.id.buttonCatWork);
        butExplore = findViewById(R.id.buttonCatExplore);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webPageDialog();
            }
        });
    }

    private void webPageDialog(){
        MaterialDialog.Builder materialDialog = new MaterialDialog.Builder(this);
        materialDialog.title(getString(R.string.dialogTitle));
        materialDialog.content(getString(R.string.dialogContent));
        materialDialog.positiveText("CHECKLIST");
        materialDialog.negativeText("CANCEL");
        materialDialog.cancelable(false);
        materialDialog.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.movetogothenburg.com/your-personal-guide"));
                startActivity(browserIntent);
            }
        });
        materialDialog.show();
    }

}
