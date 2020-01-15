package com.example.E_learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slide_Adapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public Slide_Adapter(Context context){
        this.context = context;
    }

    //Array
    public int[] slide_images={
            R.drawable.step1,
            R.drawable.step2,
            R.drawable.step3
    };

    public String[] slide_heading = {
            "Passion",
            "Teamwork",
            "Dream"
    };

    public String[] slide_desc ={
            "Develop a passion for learning.",
            "Working together is success.",
            "Education is the key to success."
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImage = (ImageView) view.findViewById(R.id.slide_images);
        TextView slideHeading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slideDesc = (TextView)view.findViewById(R.id.slide_desc);

        slideImage.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}
