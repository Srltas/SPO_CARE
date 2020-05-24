package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccountActivity extends Activity implements View.OnClickListener {
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPasswordCheck;
    EditText editTextUserName;
    EditText editTextPhoneNumber;
    Button createAccount;
    TextView returnLogin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextEmail);
        editTextPasswordCheck = (EditText) findViewById(R.id.editTextPasswordCheck);
        //당장은 쓰지 않는 변수
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        //이것도 마찬가지
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        createAccount = (Button) findViewById(R.id.btnCreateAccount);
        returnLogin = (TextView) findViewById(R.id.returnLogin);

        createAccount.setOnClickListener(this);
    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordCheck = editTextPasswordCheck.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "email을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "password를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.equals(password, passwordCheck)){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(CreateAccountActivity.this, "등록에러", Toast.LENGTH_SHORT).show();
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
