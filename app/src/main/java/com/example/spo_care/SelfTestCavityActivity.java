package com.example.spo_care;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import static com.example.spo_care.Scene.RadioGridGroup.scoreN1;
import static com.example.spo_care.Scene.RadioGridGroup.scoreN10;

public class SelfTestCavityActivity extends Activity {

    Button btnSelfTestCavityResult;

    RadioGroup radiogroupNumber2, radiogroupNumber3, radiogroupNumber4,
            radiogroupNumber5, radiogroupNumber6, radiogroupNumber7,
            radiogroupNumber8, radiogroupNumber9, radiogroupNumber11, radiogroupNumber12;

    double scoreN2, scoreN3, scoreN4, scoreN5, scoreN6, scoreN7, scoreN8, scoreN9, scoreN11, scoreN12;
    double total;

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
    }

    Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            total = scoreN1 + scoreN2 + scoreN3 + scoreN4 + scoreN5 + scoreN6 + scoreN7 + scoreN8 + scoreN9 + scoreN10 + scoreN11 + scoreN12;
            createDialog();
        }
    };


    public void createDialog() {
        AlertDialog.Builder alertadd = new AlertDialog.Builder(SelfTestCavityActivity.this);
        LayoutInflater facotry = LayoutInflater.from(SelfTestCavityActivity.this);
        final View view = facotry.inflate(R.layout.test, null);
        alertadd.setView(view);
        alertadd.setTitle("결과 확인");
        alertadd.setMessage("당신의 충치 위험도는 1단계인 저위험 단계입니다!!");
        alertadd.setNegativeButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertadd.show();
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
            scoreN2 = 1.2;
        } else{
            scoreN2 = 0;
        }
    }

    //질문 4번
    public void checkN4(int checkedId){
        if(checkedId == R.id.cavity_n4_1){
            scoreN4 = 2.0;
        } else{
            scoreN4 = 0;
        }
    }

    //질문 5번
    public void checkN5(int checkedId){
        if(checkedId == R.id.cavity_n5_1){
            scoreN5 = 2.0;
        } else{
            scoreN5 = 0;
        }
    }

    //질문 6번
    public void checkN6(int checkedId){
        if(checkedId == R.id.cavity_n6_4){
            scoreN6 = 1.2;
        } else{
            scoreN6 = 0;
        }
    }

    //질문 7번
    public void checkN7(int checkedId){
        if(checkedId == R.id.cavity_n7_2){
            scoreN7 = 1.5;
        } else{
            scoreN7 = 0;
        }
    }

    //질문 8번
    public void checkN8(int checkedId){
        if(checkedId == R.id.cavity_n8_1){
            scoreN8 = 1.2;
        } else{
            scoreN8 = 0;
        }
    }

    //질문 9번
    public void checkN9(int checkedId){
        if(checkedId == R.id.cavity_n9_1){
            scoreN9 = 1.2;
        } else{
            scoreN9 = 0;
        }
    }

    //질문 10번
    public void checkN10(int checkedId){
        if(checkedId == R.id.cavity_n10_3 || checkedId == R.id.cavity_n10_4){
            scoreN10 = 1.2;
        } else{
            scoreN10 = 0;
        }
    }

    //질문 11번
    public void checkN11(int checkedId){
        if(checkedId == R.id.cavity_n11_2){
            scoreN11 = 1.2;
        }
    }

    //질문 12번
    public void checkN12(int checkedId){
        if(checkedId == R.id.cavity_n12_4 || checkedId == R.id.cavity_n12_5){
            scoreN12 = 1.2;
        } else{
            scoreN12 = 0;
        }
    }
}
