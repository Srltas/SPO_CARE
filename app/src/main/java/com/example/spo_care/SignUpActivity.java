package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.proto.TargetGlobal;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends Activity implements View.OnClickListener {
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPasswordCheck;
    EditText editTextUserName;
    EditText editTextPhoneNumber;
    Button createAccount;
    TextView returnLogin;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore fireDatabase;

    private static final String TAG = "SignUpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firebaseAuth = FirebaseAuth.getInstance();
        fireDatabase = FirebaseFirestore.getInstance();

        /*
        //로그인 기록이 존재하면 바로 메인 화면으로 넘어가게 함
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        */

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPasswordCheck = (EditText) findViewById(R.id.editTextPasswordCheck);
        //당장은 쓰지 않는 변수
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        //이것도 마찬가지
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        createAccount = (Button) findViewById(R.id.btnCreateAccount);
        //returnLogin = (TextView) findViewById(R.id.returnLogin);

        createAccount.setOnClickListener(this);
    }
//TODO 이메일 인증 기능 추가하기

    private void registerUser(){
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordCheck = editTextPasswordCheck.getText().toString().trim();
        final String name = editTextUserName.getText().toString().trim();
        final String phoneNumber = editTextPhoneNumber.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "email을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "password를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!TextUtils.equals(password, passwordCheck)){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "계정 생성 성공. DB로 데이터를 넘깁니다.", Toast.LENGTH_SHORT).show();

                            //추후 마이페이지에서 사용하기 위해 DB로 값을 전달하는 부분이 될 예정
                            Map<String, String> user = new HashMap<>();
                            user.put("id",email);
                            user.put("name",name);
                            user.put("phoneNumber",phoneNumber);

                            fireDatabase.collection("Users").document(email)
                                    .set(user)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "문서 작성완료 되었습니다.");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG,"에러 발생 : ", e);
                                        }
                                    });

                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(SignUpActivity.this, "등록에러", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View view){
        if(view == createAccount) {
            registerUser();
        }

        if(view == returnLogin){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
