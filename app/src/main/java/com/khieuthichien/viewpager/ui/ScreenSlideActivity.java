package com.khieuthichien.viewpager.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.adapter.CheckAnswerAdapter;
import com.khieuthichien.viewpager.database.DatabaseHelper;
import com.khieuthichien.viewpager.fragment.ScreenSlidePageFragment;
import com.khieuthichien.viewpager.question.Dethi;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlideActivity extends FragmentActivity {

    private static final int NUM_PAGES = 20;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    //csdl
    DatabaseHelper databaseHelper;
    List<Dethi> dethiList;

    int num_exam;
    String test="";

    private TextView tvKiemTra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        mPager = findViewById(R.id.pager);

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Intent intent = getIntent();
        num_exam = intent.getIntExtra("num_exam", 0);
        test= intent.getStringExtra("test");

        databaseHelper = new DatabaseHelper(this);
        dethiList = new ArrayList<Dethi>();
        dethiList = databaseHelper.getAllDethi();

        tvKiemTra = findViewById(R.id.tvKiemTra);
        tvKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer();
            }
        });

    }


    public List<Dethi> getData() {
        return dethiList;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment().create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }

    public void CheckAnswer(){

        AlertDialog.Builder builder = new AlertDialog.Builder(ScreenSlideActivity.this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View dialogView = inflater.inflate(R.layout.dialog_check_answer, null);
        builder.setView(dialogView);
        builder.setTitle("Danh sách câu trả lời!");
        final Dialog dialog = builder.show();

        CheckAnswerAdapter checkAnswerAdapter = new CheckAnswerAdapter(dethiList, this);

        GridView gvQuestion;
        Button btnCancle;
        Button btnFinish;

        gvQuestion = dialogView.findViewById(R.id.gvQuestion);
        btnCancle = dialogView.findViewById(R.id.btnCancle);
        btnFinish = dialogView.findViewById(R.id.btnFinish);

        gvQuestion.setAdapter(checkAnswerAdapter);

        gvQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialog.show();

    }


}