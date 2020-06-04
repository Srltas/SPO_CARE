package com.example.spo_care;

import android.app.Activity;
import android.app.DatePickerDialog;

import android.os.Bundle;
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
    private ImageView visitAlarm;
    private TextView dDayCount;
    private com.github.mikephil.charting.charts.BarChart barChart1,barChart2;
    int y = 0, m = 0, d = 0;
    int mYear, mMonth, mDay;

    TextView myPageId;
    TextView myPageName;
    TextView myPagePhoneNumber;

    FirebaseFirestore fireDatabase;
    FirebaseAuth fireAuth;
    FirebaseUser fireUser;


    ArrayList<String> labelsList = new ArrayList<String>();
    ArrayList<Float> valuesList = new ArrayList<Float>();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.my_page);

        visitAlarm = (ImageView) findViewById(R.id.visitAlarm);
        dDayCount = (TextView) findViewById(R.id.dDayCount);
        barChart1 = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.chart1);
        barChart2 = (com.github.mikephil.charting.charts.BarChart) findViewById(R.id.chart2);
        visitAlarm.setOnClickListener(this);

        myPageId = (TextView) findViewById(R.id.myPageId);
        myPageName = (TextView) findViewById(R.id.myPageName);
        myPagePhoneNumber = (TextView) findViewById(R.id.myPagePhoneNumber);

        showUserInfo();

        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        labelsList.add("첫 번째");
        labelsList.add("두 번째");
        labelsList.add("세 번째");
        valuesList.add(10.0f);
        valuesList.add(20.0f);
        valuesList.add(30.0f);

        barChartGraph1(labelsList, valuesList);
        barChartGraph2(labelsList, valuesList);
    }
    //날짜 선택
    void showDate(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
               dDayCount.setText(getDday(year,month,dayOfMonth));
           }
        },mYear,mMonth,mDay);

        datePickerDialog.setMessage("방문 예약하기");
        datePickerDialog.show();
    }
    //Dday 날짜 구하기
    private String getDday(int year, int month, int dayOfMonth){
        final Calendar ddayCalender = Calendar.getInstance();
        ddayCalender.set(year,month,dayOfMonth);

        final long dday = ddayCalender.getTimeInMillis() / ONE_DAY;
        final long today = Calendar.getInstance().getTimeInMillis() / ONE_DAY;
        long result = dday - today;

        String strFormat;
        if(result > 0){
            strFormat = "D-%d";
        } else if(result == 0){
            strFormat = "D-Day";
        } else {
            result *= -1;
            strFormat = "D+%d";
        }

        String strCount = (String.format(strFormat,result));
        return strCount;
    }

    //막대그래프
    private void barChartGraph1(ArrayList<String> labelList, ArrayList<Float> valList){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for(int i = 0; i < valList.size(); i++){
            entries.add(new BarEntry((Float)valList.get(i), i));
        }

        ArrayList<String> labels = new ArrayList<String>();
        for(int i = 0; i < labelList.size(); i++){
            labels.add((String) labelList.get(i));
        }

        BarDataSet depenses = new BarDataSet (entries,"");
        depenses.setAxisDependency(YAxis.AxisDependency.RIGHT);
        barChart1.setDescription(" ");

        BarData data = new BarData(labels, depenses);
        depenses.setColors(ColorTemplate.PASTEL_COLORS);

        barChart1.setData(data);
        barChart1.animateXY(1000,1000);
        barChart1.invalidate();
    }

    private void barChartGraph2(ArrayList<String> labelList, ArrayList<Float> valList){
        ArrayList<BarEntry> entries = new ArrayList<>();
        for(int i = 0; i < valList.size(); i++){
            entries.add(new BarEntry((Float) valList.get(i), i));
        }

        ArrayList<String> labels = new ArrayList<String>();
        for(int i = 0; i < labelList.size(); i++){
            labels.add((String) labelList.get(i));
        }

        BarDataSet depenses = new BarDataSet (entries,null);
        barChart2.setDescription(" ");

        BarData data = new BarData(labels, depenses);
        depenses.setColors(ColorTemplate.COLORFUL_COLORS);

        barChart2.setData(data);
        barChart2.animateXY(5,20);
        barChart2.invalidate();
    }

    private void showUserInfo(){
        fireUser = FirebaseAuth.getInstance().getCurrentUser();
        String email = fireUser.getEmail();
        myPageId.setText(email);

        fireDatabase.collection("Users").whereEqualTo("id", email)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        for (DocumentSnapshot docSnap : querySnapshot.getDocuments()){
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
                        Toast.makeText(MyPageActivity.this,"에러 발생.");
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == visitAlarm) {
            showDate();
        }
    }
}