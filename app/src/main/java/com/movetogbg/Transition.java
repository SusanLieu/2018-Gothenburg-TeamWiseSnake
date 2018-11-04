package com.movetogbg;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;

public class Transition {

    private static void changeVisibilityOfChildren(RelativeLayout relativeLayout, int VISIBILITY){
        int childs = relativeLayout.getChildCount();
        for(int i = 0; i < childs; i++){
            relativeLayout.getChildAt(i).setVisibility(VISIBILITY);
        }
    }

    public static void fadeInFromClass(final Activity activity, RelativeLayout layout){
        changeVisibilityOfChildren(layout, View.INVISIBLE);

        final Animation fadeIn = AnimationUtils.loadAnimation(activity, R.anim.anim_transition_activity_fadein);


        int childs = layout.getChildCount();
        for(int i = 0; i < childs; i++){
                layout.getChildAt(i).startAnimation(fadeIn);
        }
        changeVisibilityOfChildren(layout, View.VISIBLE);

    }

    public static void fadeOutToClass(final Activity activity, final RelativeLayout layout, final Class toClass){
        final Animation fadeout = AnimationUtils.loadAnimation(activity, R.anim.anim_transition_activity_fadeout);
        final Animation fadeout_listener = AnimationUtils.loadAnimation(activity, R.anim.anim_transition_activity_fadeout);
        fadeout_listener.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changeVisibilityOfChildren(layout, View.INVISIBLE);
                activity.startActivity(new Intent(activity, toClass));
                activity.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        int childs = layout.getChildCount();
        for(int i = 0; i < childs; i++){
            if(i == 0){
                layout.getChildAt(i).startAnimation(fadeout_listener);
            }else{
                layout.getChildAt(i).startAnimation(fadeout);
            }

        }

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
