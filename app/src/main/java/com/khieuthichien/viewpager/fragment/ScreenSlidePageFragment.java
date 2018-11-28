package com.khieuthichien.viewpager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.question.Dethi;
import com.khieuthichien.viewpager.ui.ScreenSlideActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment {

    List<Dethi> dethiList;
    public static final String ARG_PAGE = "page";
    public int mPageNumber; //vi tri trang hien tai

    TextView tvNum;
    TextView tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imgIcon;

    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        imgIcon = rootView.findViewById(R.id.imgIcon);
        radioGroup = rootView.findViewById(R.id.radGroup);
        radA = rootView.findViewById(R.id.radA);
        radB = rootView.findViewById(R.id.radB);
        radC = rootView.findViewById(R.id.radC);
        radD = rootView.findViewById(R.id.radD);

        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lay data ben activity
        dethiList = new ArrayList<Dethi>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        dethiList = screenSlideActivity.getData();

        mPageNumber = getArguments().getInt(ARG_PAGE);

    }

    public static ScreenSlidePageFragment create(int pageNumber){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvNum.setText("Câu " + (mPageNumber + 1));
//        tvQuestion.setText(dethiList.get(mPageNumber).getQuestion2());
//        radA.setText(dethiList.get(mPageNumber).getAnswer_a());
//        radA.setText(dethiList.get(mPageNumber).getAnswer_b());
//        radA.setText(dethiList.get(mPageNumber).getAnswer_c());
//        radA.setText(dethiList.get(mPageNumber).getAnswer_d());

    }
}
