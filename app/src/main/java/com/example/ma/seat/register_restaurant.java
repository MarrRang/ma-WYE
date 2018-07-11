package com.example.ma.seat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class register_restaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_restaurant);
    }


    public void onClick(View view){
        Intent intent = new Intent(this, view_map.class);
        startActivity(intent);
    }
}
