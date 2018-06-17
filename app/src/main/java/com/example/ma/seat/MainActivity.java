package com.example.ma.seat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_toBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_toBase = (Button)findViewById(R.id.btn_toBase);

        btn_toBase.setOnClickListener(this);

    }

    public void onClick(View v){
        if(v==btn_toBase){
            Intent intent = new Intent(this,Base_Activity.class);
            startActivity(intent);
        }
    }
}
