package com.example.E_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class cover extends AppCompatActivity {

    private ViewPager editpager;
    private LinearLayout editlayout;
    private Button create_account,login;
    private Slide_Adapter slide_adapter;
    private TextView[] mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        editpager = (ViewPager)findViewById(R.id.slider);
        editlayout = (LinearLayout)findViewById(R.id.dots);
        create_account = (Button)findViewById(R.id.button2);
        login = (Button)findViewById(R.id.button1);

        slide_adapter =  new Slide_Adapter(cover.this);
        editpager.setAdapter(slide_adapter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });

        addDotsIndicator(0);
        editpager.addOnPageChangeListener(viewListener);
    }


    private void create() {
        Intent intent = new Intent(this,create.class);
        startActivity(intent);
    }
    private void login() {
        Intent intent = new Intent(cover.this,login.class);
        startActivity(intent);
    }

    public void addDotsIndicator( int position){

        mDots = new TextView[3];
        editlayout.removeAllViews();

        for (int i=0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.dots));
            editlayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
