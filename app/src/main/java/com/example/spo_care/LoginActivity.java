package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity implements View.OnClickListener{

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
        findPassword.setOnClickListener(this);
        createAccount.setOnClickListener(this);
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
            finish();
            //계정생성 액티비티
            startActivity(new Intent(this, SignUpActivity.class));
        }
        if(view == findPassword) {
            finish();
            //비밀번호 찾기 액티비티
            startActivity(new Intent(this, FindPasswordActivity.class));
        }
    }
}
