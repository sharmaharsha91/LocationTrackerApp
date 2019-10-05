package com.example.locationtrackrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreenActivity extends AppCompatActivity {

    private AppCompatButton btnAllowLocationTracking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        btnAllowLocationTracking = findViewById(R.id.btnAllowLocationTracking);
        btnAllowLocationTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startViewScreenActivity();
            }
        });
    }

    private void startViewScreenActivity(){
        Intent intent = new Intent(this, ViewScreenActivity.class);
        startActivity(intent);
        finish();
    }
}
