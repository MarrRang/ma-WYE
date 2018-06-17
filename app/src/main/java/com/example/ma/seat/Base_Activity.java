package com.example.ma.seat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Base_Activity extends AppCompatActivity implements View.OnClickListener{

    Button searchBtn;
    Button restaurantA_intent_Btn;
    Button restaurantB_intent_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);

        restaurantA_intent_Btn = (Button)findViewById(R.id.btn_restaurant_A);
        restaurantB_intent_Btn = (Button)findViewById(R.id.btn_restaurant_B);

        restaurantA_intent_Btn.setOnClickListener(this);
        restaurantB_intent_Btn.setOnClickListener(this);
    }

        @Override
        public void onClick(View v){
            if(v==restaurantA_intent_Btn) {
                Intent intent = new Intent(this, Info_restaurantA.class);
                startActivity(intent);
            }
        }
}
