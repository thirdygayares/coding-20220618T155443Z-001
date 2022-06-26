package com.example.diary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //table
    public static final String DIARYTABLE = "DIARYTABLE";
    public static final String DIARYID = "DIARYID";
    public static final String TITLE = "TITLE";
    public static final String NOTES = "NOTES";
    public static final String MONTH = "MONTH";
    public static final String DAY = "DAY";
    public static final String WHOLEDAY = "WHOLEDAY";
    public static final String TIMESTAMP = "TIMESTAMP";


    public DatabaseHelper(@Nullable Context context) { super(context, "diary.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String diarytable = " CREATE TABLE " + DIARYTABLE + "(" + DIARYID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  TITLE + " STRING, " +  NOTES + " STRING, " +  MONTH + " STRING, " +  DAY + " STRING, " +  WHOLEDAY + " STRING, " +  TIMESTAMP + " DEFAULT (STRFTIME('%Y-%m-%d %H:%M:%f', 'NOW')) ) ";
        db.execSQL(diarytable);


        //for testing kung pumapasok
//        String x = "INSERT INTO DIARYTABLE(TITLE,NOTES,MONTH,DAY,WHOLEDAY ) VALUES('sample', 'sample', 'sample', 'sample', 'sample');";
//        db.execSQL(x);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DIARYTABLE);
        onCreate(db);
    }

    public boolean addOne(DiaryModel diaryModel){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TITLE, diaryModel.getTitle());
        cv.put(NOTES, diaryModel.getContext());
        cv.put(MONTH, diaryModel.getDateMonth());
        cv.put(DAY, diaryModel.getDateday());
        cv.put(WHOLEDAY, diaryModel.getWholeDay());

        long insert = db.insert(DIARYTABLE, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getDiaryNotes(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor diaryData = db.rawQuery("SELECT * FROM " + DIARYTABLE + " ORDER BY " + TIMESTAMP + " DESC", null);
        return diaryData;
    }


    public  Cursor findDiaries(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor findData = db.rawQuery("SELECT * FROM " + DIARYTABLE + " where DIARYID = ? " , new String [] {id});
        return findData;
    }


}
