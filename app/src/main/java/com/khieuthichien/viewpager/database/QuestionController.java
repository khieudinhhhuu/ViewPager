package com.khieuthichien.viewpager.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.khieuthichien.viewpager.question.Question;

import java.util.ArrayList;

public class QuestionController {

    private DatabaseHelper dbHelper;

    public QuestionController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<Question> getQuestion(int num_exam, String subject) {
        ArrayList<Question> lsData = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Dethibanglaixe WHERE num_exam = '" + num_exam + "' AND subject='" + subject + "'", null);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Question item;
            item = new Question(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7), cursor.getString(8), cursor.getString(9), "");
            lsData.add(item);
        }
        return lsData;
    }

}
