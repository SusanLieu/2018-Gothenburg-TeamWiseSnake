package com.movetogbg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity {

    private TextView titleText, contentText, touchText;
    private boolean reactToTouch = false;
    private boolean moveToNextActivity = false;
    private boolean inTransition = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
        setActivityFullscreen();
        setTextForTextviews();
        startAnimation();
    }

    private void goToNextActivity(){
        if(!inTransition){
            Transition.fadeOutToClass(this, (RelativeLayout) findViewById(R.id.relativeLayout), AccountCreationBasicInfo.class);
            inTransition = true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    if(reactToTouch && !moveToNextActivity && !inTransition){
            reactToTouch = false;
            final Animation fadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_transition_activity_fadein);
            final Animation fadeout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_transition_activity_fadeout);
            final Animation fadeout_nolistener = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_transition_activity_fadeout);
            final String[] welcomeScreenTextArrayPage2 = getResources().getStringArray(R.array.WelcomePage2);

            fadeout.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    titleText.startAnimation(fadein);
                    contentText.startAnimation(fadein);
                    touchText.startAnimation(fadein);
                    moveToNextActivity = true;

                    titleText.setText(welcomeScreenTextArrayPage2[0]);
                    contentText.setText(welcomeScreenTextArrayPage2[1]);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            titleText.startAnimation(fadeout);
            contentText.startAnimation(fadeout_nolistener);
            touchText.startAnimation(fadeout_nolistener);

        }else if(moveToNextActivity){
            goToNextActivity();
        }
        return true;
    }

    private void setTextForTextviews(){
        titleText = findViewById(R.id.tvWelcomeTitle);
        contentText = findViewById(R.id.tvWelcomeContent);
        touchText = findViewById(R.id.tvTouchToContinue);

        String[] welcomeScreenTextArray = getResources().getStringArray(R.array.WelcomePage1);
        String touchToContinue = getString(R.string.welcomeScreenTouchToContinue);

        titleText.setText(welcomeScreenTextArray[0]);
        contentText.setText(welcomeScreenTextArray[1]);
        touchText.setText(touchToContinue);
    }

    private void startAnimation(){
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slideinfade);
        final Animation contentAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slideinfade);
        final Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_fadein);
        animation.setRepeatCount(0);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    contentText.startAnimation(contentAnimation);
                    contentText.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        contentAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                touchText.startAnimation(fadeInAnimation);
                touchText.setVisibility(View.VISIBLE);
                reactToTouch = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        titleText.startAnimation(animation);
        titleText.setVisibility(View.VISIBLE);
    }

    private void setActivityFullscreen(){
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
