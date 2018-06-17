package com.example.ma.seat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Image_Fragment extends Fragment {

    public static Image_Fragment newInstance(int position) {
        
        Bundle args = new Bundle();
        args.putInt("position",position);

        Image_Fragment fragment = new Image_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.info_restaurant_img1,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.info_restaurant_pager_img_1);
        imageView.setImageResource(getArguments().getInt("position"));

        return view;
    }
}
