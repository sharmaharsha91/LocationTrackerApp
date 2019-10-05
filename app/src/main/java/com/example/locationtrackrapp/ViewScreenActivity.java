package com.example.locationtrackrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ViewScreenActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton btnViewLocation, btnStopLocationTracking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_screen);
        initView();
    }

    private void initView() {
        btnViewLocation = findViewById(R.id.btnViewLocation);
        btnStopLocationTracking = findViewById(R.id.btnStopLocationTracking);

        btnViewLocation.setOnClickListener(this);
        btnStopLocationTracking.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnViewLocation) {
            Intent intent = new Intent(this, com.example.locationtrackrapp.locationTracker.MapsActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
