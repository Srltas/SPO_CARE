package com.example.spo_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends Activity implements View.OnClickListener{

    //뒤로가기 2번 누를 시 종료를 위해 시간을 체크하는 변수
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    EditText loginTextEmail;
    EditText loginTextPassword;
    Button login;
    Button createAccount;
    Button findPassword;
    Button findId;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();

        /*
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            //후에 추가해줄 메인화면
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        */
        loginTextEmail = (EditText) findViewById(R.id.textEmail);
        loginTextPassword = (EditText) findViewById(R.id.textPassword);
        login = (Button) findViewById(R.id.btnLogin);
        createAccount = (Button) findViewById(R.id.btnCreateAccount);
        findPassword = (Button) findViewById(R.id.btnFindPassword);
        findId = (Button) findViewById(R.id.btnFindId);

        login.setOnClickListener(this);
        findId.setOnClickListener(this);
        findPassword.setOnClickListener(this);
        findId.setOnClickListener(this);
        createAccount.setOnClickListener(this);
        getHashKey();
    }


    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }










    private void userLogin(){
        String email = loginTextEmail.getText().toString().trim();
        String password = loginTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "email을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "password을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == login){
            userLogin();
        }
        if(view == createAccount) {
            //계정생성 액티비티
            startActivity(new Intent(this, SignUpActivity.class));
        }
        if(view == findId){
            //아이디 찾기 액티비티
            startActivity(new Intent(this, FindIdActivity.class));
        }

        if(view == findPassword) {
            //비밀번호 찾기 액티비티
            startActivity(new Intent(this, FindPasswordActivity.class));
        }
    }

    //뒤로가기 2번 누를 시 종료
    @Override
    public void onBackPressed(){
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if(0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime){
            super.onBackPressed();
        } else{
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기를 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
