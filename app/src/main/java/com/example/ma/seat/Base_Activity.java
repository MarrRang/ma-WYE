package com.example.ma.seat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Base_Activity extends AppCompatActivity implements View.OnClickListener{

    Button search_intent_Btn;
    Button restaurantA_intent_Btn;
    Button restaurantB_intent_Btn;
    Button personalData_intent_Btn;
    Button uploadRestaurant_intent_Btn;
    Button signup_intent_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);

        search_intent_Btn = (Button)findViewById(R.id.base_Btn_Search);
        restaurantA_intent_Btn = (Button)findViewById(R.id.btn_restaurant_A);
        restaurantB_intent_Btn = (Button)findViewById(R.id.btn_restaurant_B);
        personalData_intent_Btn = (Button)findViewById(R.id.base_Btn_PersonalData);
        uploadRestaurant_intent_Btn = (Button)findViewById(R.id.base_Btn_UploadRestaurant);
        signup_intent_Btn = (Button)findViewById(R.id.base_Btn_SignIn);

        search_intent_Btn.setOnClickListener(this);
        restaurantA_intent_Btn.setOnClickListener(this);
        restaurantB_intent_Btn.setOnClickListener(this);
        personalData_intent_Btn.setOnClickListener(this);
        uploadRestaurant_intent_Btn.setOnClickListener(this);
        signup_intent_Btn.setOnClickListener(this);

    }

        @Override
        public void onClick(View v){

            switch (v.getId()){
                case R.id.btn_restaurant_A : {
                    Intent intent = new Intent(this, Info_restaurantA.class);
                    startActivity(intent);
                    break;
                }
                case R.id.base_Btn_SignIn : {
                    Intent intent = new Intent(this,Signin_NormalUser.class);
                    startActivity(intent);
                    break;
                }
                case R.id.base_Btn_UploadRestaurant : {
                    Intent intent = new Intent(this,register_restaurant.class);
                    startActivity(intent);
                    break;
                }


            }


        }
}
