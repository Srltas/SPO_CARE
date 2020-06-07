package com.example.spo_care;

import android.app.Activity;
import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyPageActivity extends Activity implements View.OnClickListener {
    private final int ONE_DAY = 24 * 60 * 60 * 1000;
    private ImageView visitAlarm, teethCare;
    private TextView dDayCount;
    private com.github.mikephil.charting.charts.BarChart barChart1, barChart2;
    int y = 0, m = 0, d = 0;
    int mYear, mMonth, mDay;

    String TAG2 = "AAAAAAAAAAAAAAA";
    String TAG3 = "BBBBBBBBBBBBBBB";

    TextView myPageId;
    TextView myPageName;
    TextView myPagePhoneNumber;

    FirebaseFirestore fireDatabase;
    FirebaseAuth fireAuth;
    FirebaseUser fireUser;

    //그래프를 그리기 위한 데이터
    ArrayList<String> cavityLabelsList = new ArrayList<String>();
    ArrayList<Float> cavityValuesList = new ArrayList<Float>();
    ArrayList<String> periodontalLabelsList = new ArrayList<String>();
    ArrayList<Float> periodontalValuesList = new ArrayList<Float>();
    TestData testData = new TestData();

    //유저 테스트 점수 순서 정렬을 위한 변수
    String[] dateTempArray = new String[3];
    float[] scoreTempArray = new float[3];

    private static final String TAG = "MyPageActivity";

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.my_page);

        visitAlarm = (ImageView) findViewById(R.id.visitAlarm);
        teethCare = findViewById(R.id.teethCare);
        dDayCount = (TextView) findViewById(R.id.dDayCount);
        barChart1 = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.chart1);
        barChart2 = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.chart2);
        visitAlarm.setOnClickListener(this);
        teethCare.setOnClickListener(this);

        myPageId = (TextView) findViewById(R.id.myPageId);
        myPageName = (TextView) findViewById(R.id.myPageName);
        myPagePhoneNumber = (TextView) findViewById(R.id.myPagePhoneNumber);

        showUserInfo();

        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        getCaTestScore();
        getPdTestScore();

        barChartGraph1(cavityLabelsList, cavityValuesList);
        barChartGraph2(periodontalLabelsList, periodontalValuesList);
    }

    //유저 테스트 점수 가져오기
    void getPdTestScore() {
        dateTempArray[0] = testData.getPDdate1();
        dateTempArray[1] = testData.getPDdate2();
        dateTempArray[2] = testData.getPDdate3();

        scoreTempArray[0] = testData.getPDscore1();
        scoreTempArray[1] = testData.getPDscore2();
        scoreTempArray[2] = testData.getPDscore3();

       /* periodontalLabelsList.add(testData.getPDdate1());
        periodontalLabelsList.add(testData.getPDdate2());
        periodontalLabelsList.add(testData.getPDdate3());
        periodontalValuesList.add(testData.getPDscore1());
        periodontalValuesList.add(testData.getPDscore2());
        periodontalValuesList.add(testData.getPDscore3());*/

        for (int i = 2; i >= 0; i--) {
            if(dateTempArray[i] == null)
                continue;
            cavityLabelsList.add(dateTempArray[i]);
            cavityValuesList.add(scoreTempArray[i]);
        }
    }

    //유저 테스트 점수 가져오기
    void getCaTestScore() {
        dateTempArray[0] = testData.getCAdate1();
        Log.d(TAG3,testData.getCAdate1()+"1");
        dateTempArray[1] = testData.getCAdate2();
        Log.d(TAG3,testData.getCAdate2()+"2");
        dateTempArray[2] = testData.getCAdate3();
        Log.d(TAG3,testData.getCAdate3()+"3");

        scoreTempArray[0] = testData.getCAscore1();
        scoreTempArray[1] = testData.getCAscore2();
        scoreTempArray[2] = testData.getCAscore3();

        for (int i = 2; i >= 0; i--) {
            Log.d(TAG2,dateTempArray[i]+ "" + i + "" + scoreTempArray[i]);
            if(dateTempArray[i] == null)
                continue;
            cavityLabelsList.add(dateTempArray[i]);
            cavityValuesList.add(scoreTempArray[i]);
        }


       /* cavityLabelsList.add(testData.getCAdate1());
        cavityLabelsList.add(testData.getCAdate2());
        cavityLabelsList.add(testData.getCAdate3());
        cavityValuesList.add(testData.getCAscore1());
        cavityValuesList.add(testData.getCAscore2());
        cavityValuesList.add(testData.getCAscore3());*/
    }

    //날짜 선택
    void showDate() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dDayCount.setText(getDday(year, month, dayOfMonth));
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    //Dday 날짜 구하기
    private String getDday(int year, int month, int dayOfMonth) {
        final Calendar ddayCalender = Calendar.getInstance();
        ddayCalender.set(year, month, dayOfMonth);

        final long dday = ddayCalender.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        String strFormat;
        if (result > 0) {
            strFormat = "D-%d";
        } else if (result == 0) {
            strFormat = "D-Day";
        } else {
            result *= -1;
            strFormat = "D+%d";
        }

        String strCount = (String.format(strFormat, result));
        return strCount;
    }

    //막대그래프
    private void barChartGraph1(ArrayList<String> labelList, ArrayList<Float> valList) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valList.size(); i++) {
            entries.add(new BarEntry((Float) valList.get(i), i));
        }

        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < labelList.size(); i++) {
            labels.add((String) labelList.get(i));
        }

        BarDataSet depenses = new BarDataSet(entries, "");
        depenses.setAxisDependency(YAxis.AxisDependency.RIGHT);
        barChart1.setDescription(" ");

        BarData data = new BarData(labels, depenses);
        depenses.setColors(ColorTemplate.PASTEL_COLORS);

        barChart1.setData(data);
        barChart1.animateXY(1000, 1000);
        barChart1.invalidate();
    }

    private void barChartGraph2(ArrayList<String> labelList, ArrayList<Float> valList) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < valList.size(); i++) {
            entries.add(new BarEntry((Float) valList.get(i), i));
        }

        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < labelList.size(); i++) {
            labels.add((String) labelList.get(i));
        }

        BarDataSet depenses = new BarDataSet(entries, null);
        barChart2.setDescription(" ");

        BarData data = new BarData(labels, depenses);
        depenses.setColors(ColorTemplate.COLORFUL_COLORS);

        barChart2.setData(data);
        barChart2.animateXY(5, 20);
        barChart2.invalidate();
    }

    private void showUserInfo() {
        fireUser = fireAuth.getInstance().getCurrentUser();
        String email = fireUser.getEmail();
        myPageId.setText(email);
        Log.d(TAG, "email = " + email);

        fireDatabase.getInstance().collection("Users").whereEqualTo("id", email)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        for (DocumentSnapshot docSnap : querySnapshot.getDocuments()) {
                            String name = docSnap.get("name").toString();
                            myPageName.setText(name);

                            String phoneNumber = docSnap.get("phoneNumber").toString();
                            myPagePhoneNumber.setText(phoneNumber);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MyPageActivity.this, "에러 발생.", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == visitAlarm) {
            showDate();
        } else if (view == teethCare) {
            Intent teethCareIntent = new Intent(getApplicationContext(), TeethCareActivity.class);
            startActivity(teethCareIntent);
        }
    }
}