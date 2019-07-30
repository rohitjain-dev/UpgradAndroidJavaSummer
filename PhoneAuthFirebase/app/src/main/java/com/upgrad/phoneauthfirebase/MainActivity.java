package com.upgrad.phoneauthfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView phoneText;
    private Button sendOTPButton;

    //firebase auth instance

    private FirebaseAuth mAuth;

    private PhoneAuthProvider mPhoneAuthProvider;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallback;

    private  String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mPhoneAuthProvider = PhoneAuthProvider.getInstance();

        phoneText = findViewById(R.id.phoneText);

        sendOTPButton = findViewById(R.id.sendOtp);



        sendOTPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = phoneText.getText().toString().trim();
            }
        });

        mPhoneAuthProvider.verifyPhoneNumber(phoneNumber,60, TimeUnit.SECONDS,this,mcallback);

        mcallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent mainIntent = new Intent(getApplicationContext(),PhoneAuthActivity.class);
                            startActivity(mainIntent);
                        }
                    }
                });
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                e.printStackTrace();
            }
        };
    }


}
