package com.appbusters.robinkamboj.jijin;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Boolean FabClosed=true;
    private Animation rotate_forward, rotate_backward, fab_open, fab_close;
    private FloatingActionButton fab, fabL, fabR, fabL2, fabR2;
    private TextView textView, textView2;
    LinearLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (LinearLayout) findViewById(R.id.activity_main);

        textView= (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        fab= (FloatingActionButton) findViewById(R.id.fab);
        fabL= (FloatingActionButton) findViewById(R.id.fabL);
        fabR= (FloatingActionButton) findViewById(R.id.fabR);
        fabL2= (FloatingActionButton) findViewById(R.id.fabL2);
        fabR2= (FloatingActionButton) findViewById(R.id.fabR2);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_backward= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        rotate_forward= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        Animation fab_close_initial= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close_initial);
        fabL.setAnimation(fab_close_initial);
        fabR.setAnimation(fab_close_initial);
        fabL2.setAnimation(fab_close_initial);
        fabR2.setAnimation(fab_close_initial);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatefab();
            }
        });
    }

    public void buttonOnClick(View v) {


        Context context= getApplicationContext();

        switch (v.getId()) {
            case R.id.fabL2:
            {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.color1));
                break;
            }
            case R.id.fabL:
            {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.color2));
                break;
            }
            case R.id.fabR:
            {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 65);
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.color3));
                break;
            }
            case R.id.fabR2:
            {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 95);
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.color4));
                break;
            }
        }
    }

    private void animatefab() {

        if (FabClosed) {
            fab.startAnimation(rotate_forward);
            fabL.startAnimation(fab_open);
            fabR.startAnimation(fab_open);
            fabL2.setAnimation(fab_open);
            fabR2.setAnimation(fab_open);
            FabClosed = false;
        } else {
            fab.startAnimation(rotate_backward);
            fabL.startAnimation(fab_close);
            fabR.startAnimation(fab_close);
            fabL2.setAnimation(fab_close);
            fabR2.setAnimation(fab_close);
            FabClosed = true;
        }
    }
}
