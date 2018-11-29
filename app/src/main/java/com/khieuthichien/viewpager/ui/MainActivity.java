package com.khieuthichien.viewpager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.database.DatabaseHelper;

import java.io.IOException;

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

        DatabaseHelper db = new DatabaseHelper(this);
        db.deleteDataBase();
        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        try {
            db.createDataBase();
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
