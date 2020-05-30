/*
package com.example.spo_care;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class UserInformationController {
    private String userName;
    private String userPhoneNumber;
    private String email;
    private String password;

    FirebaseFirestore fireDatabase;
    FirebaseAuth firebaseAuth

    String value;
    boolean result;

    private static final String TAG = "UserInformationController";

    public UserInformationController() {

    }

    public UserInformationController(String userName, String userPhoneNumber){
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }
    public UserInformationController(String userName, String userPhoneNumber, String email, String password){
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getUserData() {
        FirebaseFirestore db = fireDatabase.getInstance();


        db.collection("Users").whereEqualTo("name",userName).whereEqualTo("phoneNumber",userPhoneNumber)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (DocumentSnapshot docSnap : queryDocumentSnapshots.getDocuments()){
                            value = docSnap.get("id").toString();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        value = "Value not found";
                    }
                });
                return value;
    }
}
*/