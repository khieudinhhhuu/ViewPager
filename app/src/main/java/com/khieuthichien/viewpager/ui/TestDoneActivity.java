package com.khieuthichien.viewpager.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.khieuthichien.viewpager.R;
import com.khieuthichien.viewpager.question.Question;

import java.util.ArrayList;
import java.util.Queue;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin = new ArrayList<Question>();

    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;
    int totalScore = 0;

    private TextView tvTrue;
    private TextView tvFalse;
    private TextView tvNotAns;
    private TextView tvTotalPoint;
    private Button btnAgain;
    private Button btnExit;
    private Button btnSaveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        begin();

        Intent intent = getIntent();
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");

        checkResult();
        tvNotAns.setText(""+numNoAns);
        tvFalse.setText(""+numFalse);
        tvTrue.setText(""+numTrue);
        tvTotalPoint.setText(""+numTrue*1+"/20");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.ic_error_outline_black_24dp);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //to do
                    }
                });

                builder.show();

            }
        });

    }

    private void begin() {
        tvTrue = findViewById(R.id.tvTrue);
        tvFalse = findViewById(R.id.tvFalse);
        tvNotAns = findViewById(R.id.tvNotAns);
        tvTotalPoint = findViewById(R.id.tvTotalPoint);
        btnAgain = findViewById(R.id.btnAgain);
        btnExit = findViewById(R.id.btnExit);
        btnSaveScore = findViewById(R.id.btnSaveScore);
    }

    //Phương thức Check kết quả
    public void checkResult(){
        for (int i = 0; i < arr_QuesBegin.size(); i++) {
            if (arr_QuesBegin.get(i).getTraloi().equals("") == true){
                numNoAns++;
            }else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi()) == true){
                numTrue++;
            }else {
                numFalse++;
            }
        }
    }




}