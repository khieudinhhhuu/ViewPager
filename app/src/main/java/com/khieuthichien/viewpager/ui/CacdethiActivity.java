package com.khieuthichien.viewpager.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.adapter.CacdethiAdapter;
import com.khieuthichien.viewpager.model.Cacdethi;

import java.util.ArrayList;
import java.util.List;

public class CacdethiActivity extends AppCompatActivity {

    private RecyclerView recycler;

    private List<Cacdethi> cacdethiList;
    private CacdethiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacdethi);
        recycler = findViewById(R.id.recycler);

        cacdethiList = new ArrayList<>();

        cacdethiList.add(new Cacdethi("Đề số 1", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 2", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 3", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 4", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 5", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 6", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 7", R.drawable.ic_keyboard_arrow_right_black_24dp));
        cacdethiList.add(new Cacdethi("Đề số 8", R.drawable.ic_keyboard_arrow_right_black_24dp));

        adapter = new CacdethiAdapter(cacdethiList, this);
        recycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

    }
}
