package com.example.spo_care;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper  extends SQLiteOpenHelper {

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CA_TEST_RESULT (counter INTEGER PRIMARY KEY, date TEXT not null, score REAL)");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(1, 2020-00, 0)");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(2, 2020-00, 0)");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(3, 2020-00, 0)");

        db.execSQL("CREATE TABLE PD_TEST_RESULT (counter INTEGER PRIMARY KEY, date TEXT not null, score REAL)");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(1, 2020-00, 0)");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(2, 2020-00, 0)");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(3, 2020-00, 0)");
        printResult();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insertCA(String date, double score) {
        if (!checkCA().equals(date)){
            updateCA();
        }
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE CA_TEST_RESULT SET date='"+date+"', score="+score+" WHERE counter=1");
    }

    private void updateCA(){
        SQLiteDatabase dbRead = getReadableDatabase();
        SQLiteDatabase dbWrite = getWritableDatabase();

        String date1 = null, date2 = null;
        double score1 = 0 , score2= 0 ;

        //dbRead.execSQL("SELECT date, score FROM CA_TEST_RESULT WHERE counter = 1");

        Cursor cursor1 = dbRead.rawQuery("SELECT date, score FROM CA_TEST_RESULT WHERE counter = 1", null);
        while (cursor1.isFirst()){
          date1 = cursor1.getString(0);
          score1 = cursor1.getDouble(1);
        }

        Cursor cursor2 = dbRead.rawQuery("SELECT date, score FROM CA_TEST_RESULT WHERE counter = 2", null);
        while (cursor2.isFirst()){
            date2 = cursor2.getString(0);
            score2 = cursor2.getDouble(1);
        }

        dbWrite.execSQL("UPDATE CA_TEST_RESULT SET date='" + date1 + "', score=" + score1 + " WHERE COUNTER=2");
        dbWrite.execSQL("UPDATE CA_TEST_RESULT SET date='" + date2 + "', score=" + score2 + " WHERE COUNTER=3");
    }

    public String checkCA() {
        SQLiteDatabase dbRead = getReadableDatabase();
        String checkDate = null;

        Cursor cursor = dbRead.rawQuery("SELECT DATE FROM CA_TEST_RESULT WHERE counter = 1",null);
        while (cursor.moveToNext()){
            checkDate = cursor.getString(0);
        }
        return checkDate;
    }



    public void insertPD(String date, double score) {
        if (!checkDP().equals(date)){
            updatePD();
        }

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE PD_TEST_RESULT SET date='"+date+"', score="+score+" WHERE counter=1");
    }

    private void updatePD(){
        SQLiteDatabase dbRead = getReadableDatabase();
        SQLiteDatabase dbWrite = getWritableDatabase();

        String date1 = null, date2 = null;
        double score1 = 0 , score2= 0 ;

        dbRead.execSQL("SELECT date, score FROM PD_TEST_RESULT WHERE counter = 1");

        Cursor cursor1 = dbRead.rawQuery("SELECT date, score FROM PD_TEST_RESULT WHERE counter = 1", null);
        while (cursor1.isFirst()){
            date1 = cursor1.getString(0);
            score1 = cursor1.getDouble(1);
        }

        Cursor cursor2 = dbRead.rawQuery("SELECT date, score FROM PD_TEST_RESULT WHERE counter = 2", null);
        while (cursor2.isFirst()){
            date2 = cursor2.getString(0);
            score2 = cursor2.getDouble(1);
        }

        dbWrite.execSQL("UPDATE PD_TEST_RESULT SET date='" + date1 + "', score=" + score1 + " WHERE COUNTER=2");
        dbWrite.execSQL("UPDATE PD_TEST_RESULT SET date='" + date2 + "', score=" + score2 + " WHERE COUNTER=3");
    }

    public String checkDP() {
        SQLiteDatabase dbRead = getReadableDatabase();
        String checkDate = null;

        Cursor cursor = dbRead.rawQuery("SELECT DATE FROM DP_TEST_RESULT WHERE counter = 1",null);
        while (cursor.moveToNext()){
            checkDate = cursor.getString(0);
        }
        return checkDate;
    }

    public TestData printResult() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor, cursor1;

        TestData testData = new TestData();
        int i = 1;
        int j = 2;

        cursor = db.rawQuery("SELECT counter, date, score FROM CA_TEST_RESULT", null);
        while (cursor.moveToNext()) {
            if (i == 1){
                testData.setCAcounter1(cursor.getInt(0));
                testData.setCAdate1(cursor.getString(1));
                testData.setCAscore1(cursor.getFloat(2));
                i++;
            } else if (i == 2){
                testData.setCAcounter2(cursor.getInt(0));
                testData.setCAdate2(cursor.getString(1));
                testData.setCAscore2(cursor.getFloat(2));
                i++;
            } else if (i == 3){
                testData.setCAcounter3(cursor.getInt(0));
                testData.setCAdate3(cursor.getString(1));
                testData.setCAscore3(cursor.getFloat(2));
                i++;
            } else {

            }
        }

        cursor1 = db.rawQuery("SELECT counter, date, score FROM PD_TEST_RESULT", null);
        while (cursor1.moveToNext()){
            if (i == 1){
                testData.setPDcounter1(cursor.getInt(0));
                testData.setPDdate1(cursor.getString(1));
                testData.setPDscore1(cursor.getFloat(2));
                i++;
            } else if (i == 2){
                testData.setPDcounter2(cursor.getInt(0));
                testData.setPDdate2(cursor.getString(1));
                testData.setPDscore2(cursor.getFloat(2));
                i++;
            } else if (i == 3){
                testData.setPDcounter3(cursor.getInt(0));
                testData.setPDdate3(cursor.getString(1));
                testData.setPDscore3(cursor.getFloat(2));
                i++;
            }
        }
        return testData;
    }
}


