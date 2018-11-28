package com.khieuthichien.viewpager.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.adapter.CacdethiAdapter;
import com.khieuthichien.viewpager.database.DatabaseHelper;
import com.khieuthichien.viewpager.model.Cacdethi;
import com.khieuthichien.viewpager.ui.MainActivity;
import com.khieuthichien.viewpager.ui.ScreenSlideActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacdethiActivity extends AppCompatActivity {

    private RecyclerView recycler;

    private List<Cacdethi> cacdethiList;
    private CacdethiAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacdethi);

        recycler = findViewById(R.id.recycler);

        databaseHelper = new DatabaseHelper(this);

        cacdethiList = new ArrayList<>();

        cacdethiList.add(new Cacdethi("Đề 1", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 2", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 3", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 4", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 5", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 6", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 7", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề 8", R.drawable.ic_keyboard_arrow_right_black_24dp));

        adapter = new CacdethiAdapter(cacdethiList, this);
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

    }
}
