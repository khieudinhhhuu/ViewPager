package com.khieuthichien.viewpager.database;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.khieuthichien.viewpager.question.Dethi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dethi_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_DETHI = "dethi";

    public static final String COLUMN_ID_DETHI = "id";
    public static final String COLUMN_QUESTION_DETHI = "question";
    public static final String COLUMN_ANSWER_A_DETHI = "answer_a";
    public static final String COLUMN_ANSWER_B_DETHI = "answer_b";
    public static final String COLUMN_ANSWER_C_DETHI = "answer_c";
    public static final String COLUMN_ANSWER_D_DETHI = "answer_d";
    public static final String COLUMN_RESULT_DETHI = "result";
    public static final String COLUMN_NUMEXAM_DETHI = "numexam";
    public static final String COLUMN_IMAGE_DETHI = "image";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_DETHI + "(" +
                "" + COLUMN_ID_DETHI + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "" + COLUMN_QUESTION_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_ANSWER_A_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_ANSWER_B_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_ANSWER_C_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_ANSWER_D_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_RESULT_DETHI + " TEXT NOT NULL, " +
                "" + COLUMN_NUMEXAM_DETHI + " INTEGER NOT NULL, " +
                "" + COLUMN_IMAGE_DETHI + " TEXT NOT NULL " +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_DETHI);
        onCreate(db);
    }

    public void insertDethi(Dethi dethi){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_ID_DETHI, dethi.get_id());
        values.put(COLUMN_QUESTION_DETHI, dethi.getQuestion2());
        values.put(COLUMN_ANSWER_A_DETHI, dethi.getAnswer_a());
        values.put(COLUMN_ANSWER_B_DETHI, dethi.getAnswer_b());
        values.put(COLUMN_ANSWER_C_DETHI, dethi.getAnswer_c());
        values.put(COLUMN_ANSWER_D_DETHI, dethi.getAnswer_c());
        values.put(COLUMN_RESULT_DETHI, dethi.getResult());
        values.put(COLUMN_NUMEXAM_DETHI, dethi.getNum_exam());
        values.put(COLUMN_IMAGE_DETHI, dethi.getImage());

        db.insert(TABLE_DETHI, null, values);
        db.close();
    }

    public Dethi getDethi(String dethi){
        Dethi dethi1 = null;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_DETHI ,
                new String[]{COLUMN_ID_DETHI, COLUMN_QUESTION_DETHI, COLUMN_ANSWER_A_DETHI, COLUMN_ANSWER_B_DETHI, COLUMN_ANSWER_C_DETHI, COLUMN_ANSWER_D_DETHI, COLUMN_RESULT_DETHI, COLUMN_NUMEXAM_DETHI, COLUMN_IMAGE_DETHI},
                COLUMN_ID_DETHI + "=?",
                new String[]{String.valueOf(dethi)},
                null, null, null );

        if (cursor != null && cursor.moveToFirst()){

            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_DETHI));

            String question = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION_DETHI));

            String answer_a = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_A_DETHI));

            String answer_b = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_B_DETHI));

            String answer_c = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_C_DETHI));

            String answer_d = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_D_DETHI));

            String result = cursor.getString(cursor.getColumnIndex(COLUMN_RESULT_DETHI));

            int num_exam = cursor.getInt(cursor.getColumnIndex(COLUMN_NUMEXAM_DETHI));

            String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_DETHI));

            dethi1 = new Dethi(id, question, answer_a, answer_b, answer_c, answer_d, result, num_exam, image, "");
        }
        cursor.close();
        return dethi1;
    }

    public List<Dethi> getAllDethi(){

        List<Dethi> dethiList = new ArrayList<>();

        String SECLECT_ALL_DETHI = " SELECT * FROM " + TABLE_DETHI;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(SECLECT_ALL_DETHI , null);

        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID_DETHI));

                String question = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION_DETHI));

                String answer_a = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_A_DETHI));

                String answer_b = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_B_DETHI));

                String answer_c = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_C_DETHI));

                String answer_d = cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_D_DETHI));

                String result = cursor.getString(cursor.getColumnIndex(COLUMN_RESULT_DETHI));

                int num_exam = cursor.getInt(cursor.getColumnIndex(COLUMN_NUMEXAM_DETHI));

                String image = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_DETHI));

                Dethi dethi = new Dethi();
                dethi.set_id(id);
                dethi.setQuestion2(question);
                dethi.setAnswer_a(answer_a);
                dethi.setAnswer_b(answer_b);
                dethi.setAnswer_c(answer_c);
                dethi.setAnswer_d(answer_d);
                dethi.setResult(result);
                dethi.setNum_exam(num_exam);
                dethi.setImage(image);

                dethiList.add(dethi);

            }while (cursor.moveToNext());
        }

        cursor.close();

        db.close();

        return dethiList;
    }

    public int updateDethi(int id,Dethi dethi){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_QUESTION_DETHI, dethi.getQuestion2());
        values.put(COLUMN_ANSWER_A_DETHI, dethi.getAnswer_a());
        values.put(COLUMN_ANSWER_B_DETHI, dethi.getAnswer_b());
        values.put(COLUMN_ANSWER_C_DETHI, dethi.getAnswer_c());
        values.put(COLUMN_ANSWER_D_DETHI, dethi.getAnswer_c());
        values.put(COLUMN_RESULT_DETHI, dethi.getResult());
        values.put(COLUMN_NUMEXAM_DETHI, dethi.getNum_exam());
        values.put(COLUMN_IMAGE_DETHI, dethi.getImage());

        return db.update(TABLE_DETHI, values, COLUMN_ID_DETHI + "=?", new String[]{String.valueOf(id)});

    }

    public void deleteDethi(int iddethi){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DETHI, COLUMN_ID_DETHI + "=?", new String[]{String.valueOf(iddethi)});
        db.close();
    }
}
