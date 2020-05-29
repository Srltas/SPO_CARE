package com.example.spo_care;

import android.app.Activity;
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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FindIdActivity extends Activity implements View.OnClickListener {

    EditText findIdName;
    EditText findIdPhoneNumber;
    TextView findIdResult;
    Button btnFindId;
    FirebaseFirestore fireDatabase;
    private static final String TAG = "FindIdActivity";
    CollectionReference doc;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.find_id);

        findIdName = (EditText) findViewById(R.id.findIdName);
        findIdPhoneNumber = (EditText) findViewById(R.id.findIdPhoneNumber);
        btnFindId = (Button) findViewById(R.id.btnFindId);
        findIdResult = (TextView) findViewById(R.id.findIdResult);

        btnFindId.setOnClickListener(this);

    }

    private void findId(){
        FirebaseFirestore db = fireDatabase.getInstance();
        String userName = findIdName.getText().toString().trim();
        String phoneNumber = findIdPhoneNumber.getText().toString().trim();

        if (TextUtils.isEmpty(userName)){
            Toast.makeText(this,"이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(phoneNumber)){
            Toast.makeText(this,"전화번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        db.collection("Users").whereEqualTo("name",userName)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot docSnap : queryDocumentSnapshots.getDocuments()){
                            String value = docSnap.get("id").toString();
                            findIdResult.setText(value);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(FindIdActivity.this,"유효한 탐색 결과가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View view){
        if(view == btnFindId){
            findId();
        }
    }
}