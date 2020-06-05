package com.example.spo_care;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import java.util.GregorianCalendar;

import static com.example.spo_care.Scene.RadioGridGroup.scoreN1;
import static com.example.spo_care.Scene.RadioGridGroup.scoreN10;


public class SelfTestCavityActivity extends Activity {

    Button btnSelfTestCavityResult;

    RadioGroup radiogroupNumber2, radiogroupNumber3, radiogroupNumber4,
            radiogroupNumber5, radiogroupNumber6, radiogroupNumber7,
            radiogroupNumber8, radiogroupNumber9, radiogroupNumber11, radiogroupNumber12;

    float scoreN2, scoreN3, scoreN4, scoreN5, scoreN6, scoreN7, scoreN8, scoreN9, scoreN11, scoreN12;
    float total;
    int year, month;

    SQLiteHelper sqLite;

    String email;
    String value;
    Integer testCounter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.selftest_cavity);

        btnSelfTestCavityResult = findViewById(R.id.btnSelfTestCavityResult);
        radiogroupNumber2 = findViewById(R.id.cavity_n2);
        radiogroupNumber3 = findViewById(R.id.cavity_n3);
        radiogroupNumber4 = findViewById(R.id.cavity_n4);
        radiogroupNumber5 = findViewById(R.id.cavity_n5);
        radiogroupNumber6 = findViewById(R.id.cavity_n6);
        radiogroupNumber7 = findViewById(R.id.cavity_n7);
        radiogroupNumber8 = findViewById(R.id.cavity_n8);
        radiogroupNumber9 = findViewById(R.id.cavity_n9);
        radiogroupNumber11 = findViewById(R.id.cavity_n11);
        radiogroupNumber12 = findViewById(R.id.cavity_n12);

        btnSelfTestCavityResult.setOnClickListener(listener);
        radiogroupNumber2.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber3.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber4.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber5.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber6.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber7.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber8.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber9.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber11.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber12.setOnCheckedChangeListener(checkRadioGroup);

        sqLite = new SQLiteHelper(getApplicationContext(), "TestResult.db", null, 1);

    }

    Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            total = (float) (scoreN1 + scoreN2 + scoreN3 + scoreN4 + scoreN5 + scoreN6 + scoreN7 + scoreN8 + scoreN9 + scoreN10 + scoreN11 + scoreN12);
            createDialog();
        }
    };


    public void createDialog() {
        AlertDialog.Builder alertadd = new AlertDialog.Builder(SelfTestCavityActivity.this);
        alertadd.setView(selectResult(total));
        getDate();
        alertadd.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String date = year + "-" + month;
                sqLite.insertCA(date, total);
            }
        });
        alertadd.show();
    }

    public View selectResult(float score){
        View view;
        LayoutInflater facotry = LayoutInflater.from(SelfTestCavityActivity.this);
        if(score >= 11){
            view = facotry.inflate(R.layout.selftest_result_4,null);
        }else if(score >= 7){
            view = facotry.inflate(R.layout.selftest_result_3,null);
        }else if(score >= 5){
            view = facotry.inflate(R.layout.selftest_result_2,null);
        }else {
            view = facotry.inflate(R.layout.selftest_result_1,null);
        }
        return view;
    }

    public void getDate(){
        GregorianCalendar today = new GregorianCalendar();

        year = today.get(today.YEAR);
        month = today.get(today.MONTH) + 1;
    }

    RadioGroup.OnCheckedChangeListener checkRadioGroup = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch(radioGroup.getId()){
                case R.id.cavity_n2:
                    checkN2(checkedId);
                    break;
                case R.id.cavity_n4:
                    checkN4(checkedId);
                    break;
                case R.id.cavity_n5:
                    checkN5(checkedId);
                    break;
                case R.id.cavity_n6:
                    checkN6(checkedId);
                    break;
                case R.id.cavity_n7:
                    checkN7(checkedId);
                    break;
                case R.id.cavity_n8:
                    checkN8(checkedId);
                    break;
                case R.id.cavity_n9:
                    checkN9(checkedId);
                    break;
                case R.id.cavity_n11:
                    checkN11(checkedId);
                    break;
                case R.id.cavity_n12:
                    checkN12(checkedId);
                    break;
            }
        }
    };

    //질문 2번
    public void checkN2(int checkedId){
        if(checkedId == R.id.cavity_n2_1 || checkedId == R.id.cavity_n2_2){
            scoreN2 = 1.2f;
        } else{
            scoreN2 = 0;
        }
    }

    //질문 4번
    public void checkN4(int checkedId){
        if(checkedId == R.id.cavity_n4_1){
            scoreN4 = 2.0f;
        } else{
            scoreN4 = 0;
        }
    }

    //질문 5번
    public void checkN5(int checkedId){
        if(checkedId == R.id.cavity_n5_1){
            scoreN5 = 2.0f;
        } else{
            scoreN5 = 0;
        }
    }

    //질문 6번
    public void checkN6(int checkedId){
        if(checkedId == R.id.cavity_n6_4){
            scoreN6 = 1.2f;
        } else{
            scoreN6 = 0;
        }
    }

    //질문 7번
    public void checkN7(int checkedId){
        if(checkedId == R.id.cavity_n7_2){
            scoreN7 = 1.5f;
        } else{
            scoreN7 = 0;
        }
    }

    //질문 8번
    public void checkN8(int checkedId){
        if(checkedId == R.id.cavity_n8_1){
            scoreN8 = 1.2f;
        } else{
            scoreN8 = 0;
        }
    }

    //질문 9번
    public void checkN9(int checkedId){
        if(checkedId == R.id.cavity_n9_1){
            scoreN9 = 1.2f;
        } else{
            scoreN9 = 0;
        }
    }

    //질문 10번
    public void checkN10(int checkedId){
        if(checkedId == R.id.cavity_n10_3 || checkedId == R.id.cavity_n10_4){
            scoreN10 = 1.2f;
        } else{
            scoreN10 = 0;
        }
    }

    //질문 11번
    public void checkN11(int checkedId){
        if(checkedId == R.id.cavity_n11_2){
            scoreN11 = 1.2f;
        }
    }

    //질문 12번
    public void checkN12(int checkedId){
        if(checkedId == R.id.cavity_n12_4 || checkedId == R.id.cavity_n12_5){
            scoreN12 = 1.2f;
        } else{
            scoreN12 = 0;
        }
    }
}
