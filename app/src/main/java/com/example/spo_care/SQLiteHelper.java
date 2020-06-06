package com.example.spo_care;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteHelper  extends SQLiteOpenHelper {

    private static final String TAG = "SQLiteHelper";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CA_TEST_RESULT (counter INTEGER PRIMARY KEY, date TEXT, score REAL);");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(1, '2020-00', 0);");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(2, '2020-00', 0);");
        db.execSQL("INSERT INTO CA_TEST_RESULT VALUES(3, '2020-00', 0);");

        db.execSQL("CREATE TABLE PD_TEST_RESULT (counter INTEGER PRIMARY KEY, date TEXT, score REAL);");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(1, '2020-00', 0);");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(2, '2020-00', 0);");
        db.execSQL("INSERT INTO PD_TEST_RESULT VALUES(3, '2020-00', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insertCA(String date, double score) {
        if (!checkCA().equals(date)){
            updateCA();
        }
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE CA_TEST_RESULT SET date='"+date+"', score="+score+" WHERE counter=1;");
    }

    private void updateCA(){
        SQLiteDatabase dbRead = getReadableDatabase();
        SQLiteDatabase dbWrite = getWritableDatabase();

        String date1, date2;
        double score1, score2;

        Cursor cursor1 = dbRead.rawQuery("SELECT date, score FROM CA_TEST_RESULT WHERE counter = 1;", null);
        cursor1.moveToFirst();

        date1 = cursor1.getString(0);
        score1 = cursor1.getFloat(1);

        Log.d(TAG,"updateCA 1 date = "+date1);

        Cursor cursor2 = dbRead.rawQuery("SELECT date, score FROM CA_TEST_RESULT WHERE counter = 2;", null);
        cursor2.moveToFirst();

        date2 = cursor2.getString(0);
        score2 = cursor2.getFloat(1);

        Log.d(TAG,"updateCA 2 date = "+date2);

        dbWrite.execSQL("UPDATE CA_TEST_RESULT SET date='" + date1 + "', score=" + score1 + " WHERE COUNTER=2;");
        dbWrite.execSQL("UPDATE CA_TEST_RESULT SET date='" + date2 + "', score=" + score2 + " WHERE COUNTER=3;");
    }

    public String checkCA() {
        SQLiteDatabase dbRead = getReadableDatabase();
        String checkDate = null;

        Cursor cursor = dbRead.rawQuery("SELECT DATE FROM CA_TEST_RESULT WHERE counter = 1;",null);
        while (cursor.moveToNext()){
            checkDate = cursor.getString(0);
        }
        return checkDate;
    }



    public void insertPD(String date, double score) {
        if (!checkPD().equals(date)){
            updatePD();
        }

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE PD_TEST_RESULT SET date='"+date+"', score="+score+" WHERE counter=1;");
    }

    private void updatePD(){
        SQLiteDatabase dbRead = getReadableDatabase();
        SQLiteDatabase dbWrite = getWritableDatabase();

        String date1, date2;
        double score1, score2;

        Cursor cursor1 = dbRead.rawQuery("SELECT date, score FROM PD_TEST_RESULT WHERE counter = 1;", null);

        date1 = cursor1.getString(0);
        score1 = cursor1.getFloat(1);

        Log.d(TAG,"updatePD 1 date = "+date1);

        Cursor cursor2 = dbRead.rawQuery("SELECT date, score FROM PD_TEST_RESULT WHERE counter = 2;", null);

        date2 = cursor2.getString(0);
        score2 = cursor2.getFloat(1);

        Log.d(TAG,"updatePD 2 date = "+date2);

        dbWrite.execSQL("UPDATE PD_TEST_RESULT SET date='" + date1 + "', score=" + score1 + " WHERE COUNTER=2;");
        dbWrite.execSQL("UPDATE PD_TEST_RESULT SET date='" + date2 + "', score=" + score2 + " WHERE COUNTER=3;");
    }

    public String checkPD() {
        SQLiteDatabase dbRead = getReadableDatabase();
        String checkDate = null;

        Cursor cursor = dbRead.rawQuery("SELECT DATE FROM PD_TEST_RESULT WHERE counter = 1;",null);
        while (cursor.moveToNext()){
            checkDate = cursor.getString(0);
        }
        return checkDate;
    }

    public TestData printResult() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor, cursor1;

        String CA1;
        String CA2;
        String CA3;

        String PD1;
        String PD2;
        String PD3;

        TestData testData = new TestData();
        int i = 0;
        int j = 0;

        cursor = db.rawQuery("SELECT * FROM CA_TEST_RESULT;", null);



        while (cursor.moveToNext()) {
            if (i == 0) {
                cursor.moveToFirst();
                testData.setCAcounter1(cursor.getInt(0));
                testData.setCAdate1(cursor.getString(1));
                testData.setCAscore1(cursor.getFloat(2));
                CA1 = cursor.getInt(0) + " " + cursor.getString(1) + " " + cursor.getFloat(2);
                Log.d(TAG, "db log ca1 = " + CA1);
                i++;
            } else if (i == 1) {
                testData.setCAcounter2(cursor.getInt(0));
                testData.setCAdate2(cursor.getString(1));
                testData.setCAscore2(cursor.getFloat(2));
                CA2 = cursor.getInt(0) + " " + cursor.getString(1) + " " + cursor.getFloat(2);
                Log.d(TAG, "db log ca2 = " + CA2);
                i++;
            } else if (i == 2) {
                testData.setCAcounter3(cursor.getInt(0));
                testData.setCAdate3(cursor.getString(1));
                testData.setCAscore3(cursor.getFloat(2));
                CA3 = cursor.getInt(0) + " " + cursor.getString(1) + " " + cursor.getFloat(2);
                Log.d(TAG, "db log ca3 = " + CA3);
            }
        }

        cursor1 = db.rawQuery("SELECT * FROM PD_TEST_RESULT;", null);



        while (cursor1.moveToNext()){
            if (j == 0){
                cursor1.moveToFirst();
                testData.setPDcounter1(cursor1.getInt(0));
                testData.setPDdate1(cursor1.getString(1));
                testData.setPDscore1(cursor1.getFloat(2));
                PD1 = cursor1.getInt(0)+" "+cursor1.getString(1)+" "+cursor1.getFloat(2);
                Log.d(TAG, "db log pd1 = "+PD1);
                j++;
            } else if (j == 1){
                testData.setPDcounter2(cursor1.getInt(0));
                testData.setPDdate2(cursor1.getString(1));
                testData.setPDscore2(cursor1.getFloat(2));
                PD2 = cursor1.getInt(0)+" "+cursor1.getString(1)+" "+cursor1.getFloat(2);
                Log.d(TAG, "db log pd2 = "+PD2);
                j++;
            } else if (j == 2){
                testData.setPDcounter3(cursor1.getInt(0));
                testData.setPDdate3(cursor1.getString(1));
                testData.setPDscore3(cursor1.getFloat(2));
                PD3 = cursor1.getInt(0)+" "+cursor1.getString(1)+" "+cursor1.getFloat(2);
                Log.d(TAG, "db log pd3 = " + PD3);
            }
        }
        return testData;
    }
}


