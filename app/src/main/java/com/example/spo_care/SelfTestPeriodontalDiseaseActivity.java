package com.example.spo_care;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import static com.example.spo_care.Scene.RadioGridGroup.scoreN1;
import static com.example.spo_care.Scene.RadioGridGroup.scoreN10;
import static com.example.spo_care.Scene.RadioGridGroup.scoreS1;
import static com.example.spo_care.Scene.RadioGridGroup.scoreS10;
import static com.example.spo_care.Scene.RadioGridGroup.scoreS8;

public class SelfTestPeriodontalDiseaseActivity extends Activity {
    Button btnSelfTestPeriodontlResult;

    RadioGroup radiogroupNumber2, radiogroupNumber3, radiogroupNumber4,
            radiogroupNumber5, radiogroupNumber6, radiogroupNumber7,
            radiogroupNumber9, radiogroupNumber11, radiogroupNumber12;

    double scoreS2, scoreS3, scoreS4, scoreS5, scoreS6, scoreS7, scoreS9, scoreS11, scoreS12;
    double total;

    FirebaseAuth fbAuth;
    FirebaseUser fbUser;
    FirebaseFirestore db;

    String email;
    String value;
    Integer testCounter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.selftest_periodontl_disease);

        btnSelfTestPeriodontlResult = findViewById(R.id.btnSelfTestPeriodontlResult);
        radiogroupNumber2 = findViewById(R.id.periodontal_n2);
        radiogroupNumber3 = findViewById(R.id.periodontal_n3);
        radiogroupNumber4 = findViewById(R.id.periodontal_n4);
        radiogroupNumber5 = findViewById(R.id.periodontal_n5);
        radiogroupNumber6 = findViewById(R.id.periodontal_n6);
        radiogroupNumber7 = findViewById(R.id.periodontal_n7);
        radiogroupNumber9 = findViewById(R.id.periodontal_n9);
        radiogroupNumber11 = findViewById(R.id.periodontal_n11);
        radiogroupNumber12 = findViewById(R.id.periodontal_n12);

        btnSelfTestPeriodontlResult.setOnClickListener(listener);
        radiogroupNumber2.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber3.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber4.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber5.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber6.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber7.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber9.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber11.setOnCheckedChangeListener(checkRadioGroup);
        radiogroupNumber12.setOnCheckedChangeListener(checkRadioGroup);

        fbUser = fbAuth.getInstance().getCurrentUser();
        if (fbUser != null) {
            email = fbUser.getEmail();
        }
    }

    //TODO 결과값을 저장하면서 카운트 하는 부분을 만들어야됨

    private void getTextResultCounter() {
        db = FirebaseFirestore.getInstance();
        db.collection("Users").whereEqualTo("email", email)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot docSnap : queryDocumentSnapshots.getDocuments()){
                            value = docSnap.get("testCounter").toString();
                            testCounter = Integer.parseInt(value);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SelfTestPeriodontalDiseaseActivity.this,"유효한 탐색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveTestResult() {
        getTextResultCounter();
        testCounter = testCounter % 5;
        Map<String, Double> data = new HashMap<>();
        data.put("scorePD"+testCounter, total);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(email).set(data, SetOptions.merge());
    }

    Button.OnClickListener listener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            total = scoreS1 + scoreS2 + scoreS3 + scoreS4 + scoreS5 + scoreS6 + scoreS7 + scoreS8 + scoreS9 + scoreS10 + scoreS11 + scoreS12;

            AlertDialog.Builder dlg = new AlertDialog.Builder(SelfTestPeriodontalDiseaseActivity.this);
            dlg.setTitle("결과입니다.");
            dlg.setMessage("총합은" + Double.toString(total) + "입니다.");
            dlg.setIcon(R.mipmap.ic_launcher);
            dlg.show();
        }
    };

    RadioGroup.OnCheckedChangeListener checkRadioGroup = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch(radioGroup.getId()){
                case R.id.periodontal_n2:
                    checkN2(checkedId);
                    break;
                case R.id.periodontal_n4:
                    checkN4(checkedId);
                    break;
                case R.id.periodontal_n5:
                    checkN5(checkedId);
                    break;
                case R.id.periodontal_n6:
                    checkN6(checkedId);
                    break;
                case R.id.periodontal_n7:
                    checkN7(checkedId);
                    break;
                case R.id.periodontal_n9:
                    checkN9(checkedId);
                    break;
                case R.id.periodontal_n11:
                    checkN11(checkedId);
                    break;
                case R.id.periodontal_n12:
                    checkN12(checkedId);
                    break;
            }
        }
    };

    //질문 2번
    public void checkN2(int checkedId){
        if(checkedId == R.id.periodontl_disease_n2_1){
            scoreS2 = 1.5;
        } else if(checkedId == R.id.periodontl_disease_n2_2){
            scoreS2 = 1.2;
        } else {
            scoreS2 = 0;
        }
    }

    //질문 4번
    public void checkN4(int checkedId){
        if(checkedId == R.id.periodontl_disease_n4_1){
            scoreS4 = 1.2;
        } else{
            scoreS4 = 0;
        }
    }

    //질문 5번
    public void checkN5(int checkedId){
        if(checkedId == R.id.periodontl_disease_n5_1){
            scoreS5 = 2.0;
        } else{
            scoreS5 = 0;
        }
    }

    //질문 6번
    public void checkN6(int checkedId){
        if(checkedId == R.id.periodontl_disease_n6_4){
            scoreS6 = 2.0;
        } else{
            scoreS6 = 0;
        }
    }

    //질문 7번
    public void checkN7(int checkedId){
        if(checkedId == R.id.periodontl_disease_n7_2){
            scoreS7 = 1.3;
        } else{
            scoreS7 = 0;
        }
    }

    //질문 8번
    public void checkN8(int checkedId){
        if(checkedId == R.id.periodontl_disease_n8_2){
            scoreS8 = 2.0;
        } else{
            scoreS8 = 0;
        }
    }

    //질문 9번
    public void checkN9(int checkedId){
        if(checkedId == R.id.periodontl_disease_n9_1){
            scoreS9 = 2.0;
        } else{
            scoreS9 = 0;
        }
    }

    //질문 10번
    public void checkN10(int checkedId){
        if(checkedId == R.id.periodontl_disease_n10_3 || checkedId == R.id.periodontl_disease_n10_4){
            scoreS10 = 1.2;
        } else{
            scoreS10 = 0;
        }
    }

    //질문 11번
    public void checkN11(int checkedId){
        if(checkedId == R.id.periodontl_disease_n11_2){
            scoreS11 = 1.5;
        }
    }

    //질문 12번
    public void checkN12(int checkedId){
        if(checkedId == R.id.periodontl_disease_n12_1){
            scoreS12 = 2.0;
        } else{
            scoreS12 = 0;
        }
    }
}
