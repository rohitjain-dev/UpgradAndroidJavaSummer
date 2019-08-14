package com.upgrad.phoneauth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class AuthActivity extends AppCompatActivity {

    private LinearLayout mphoneLayout;
    private LinearLayout mcodeLayout;
    private EditText phoneNumber,otpText;
    private Button sendOTP;

    private FirebaseAuth mAuth;
    private PhoneAuthProvider mphone;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallbacks;

    private String mverificationID;
    private PhoneAuthProvider.ForceResendingToken resendingToken;

    //private int buttonType = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mcodeLayout = (LinearLayout) findViewById(R.id.codeLayout);
        mphoneLayout = (LinearLayout) findViewById(R.id.phoneLayout);

        phoneNumber = (EditText) findViewById(R.id.phoneNumberEditText);
        otpText = (EditText) findViewById(R.id.otpText);

        mAuth = FirebaseAuth.getInstance();
        mphone = PhoneAuthProvider.getInstance();

        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = phoneNumber.getText().toString().trim();
                sendOTP.setEnabled(false);
                mphone.verifyPhoneNumber(phonenumber,60, TimeUnit.SECONDS,AuthActivity.this,mcallbacks);
            }
        });

        mcallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                e.printStackTrace();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                mverificationID = s;
                resendingToken = forceResendingToken;
                mcodeLayout.setVisibility(View.VISIBLE);
                sendOTP.setText("Verify Code");
            }
        };
    }

    public void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }
        });
    }
}
