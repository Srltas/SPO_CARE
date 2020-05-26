package com.example.spo_care;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class FindPasswordActivity extends Activity implements View.OnClickListener {
    EditText editTextUserEmail;
    EditText editTextUserName;
    EditText editTextPhoneNumber;

    Button btnFindPassword;
    //TextView returnLogin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_pw);

        editTextUserEmail = (EditText) findViewById(R.id.textEmail);
        editTextUserName = (EditText) findViewById(R.id.textUserName);
        editTextPhoneNumber = (EditText) findViewById(R.id.textPhoneNumber);
        btnFindPassword = (Button) findViewById(R.id.btnFindPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        btnFindPassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view == btnFindPassword){
            String emailAddress = editTextUserEmail.getText().toString().trim();
            firebaseAuth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(FindPasswordActivity.this, "이메일을 보냈습니다.", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else {
                                Toast.makeText(FindPasswordActivity.this, "메일 발송 실패", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
