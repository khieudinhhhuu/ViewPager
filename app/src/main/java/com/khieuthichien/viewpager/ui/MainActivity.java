package com.khieuthichien.viewpager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.khieuthichien.viewpager.R;

public class MainActivity extends AppCompatActivity {

    private Button contestWelcomeBtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contestWelcomeBtnStart = findViewById(R.id.contest_welcome_btnStart);

        contestWelcomeBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CacdethiActivity.class));
            }
        });



    }
}
