package com.upgrad.chatterbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyPhoneActivity extends AppCompatActivity {

    private EditText otpEditText;
    private Button loginButton;
    private ProgressBar progressBar;
    //firebase auth objects
    private FirebaseAuth mAuth;
    private String mobile;
    private String mverficationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);

        mAuth = FirebaseAuth.getInstance();
        otpEditText = (EditText) findViewById(R.id.otpEditText);
        progressBar = (ProgressBar) findViewById(R.id.progessBar);
        loginButton = (Button) findViewById(R.id.loginButton);

        Intent intent = getIntent();

        mobile = intent.getStringExtra("mobile");
        sendVerificationCode(mobile);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = otpEditText.getText().toString().trim();
                if(code.isEmpty() || code.length()< 6){
                    otpEditText.setError("Enter a vaild code");
                    otpEditText.requestFocus();
                    return;
                }

                verifyVerficationcode(code);
            }
        });

    }

    //automatic code detection
    private void sendVerificationCode(String mobile) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mcallbacks
        );
        progressBar.setVisibility(View.VISIBLE);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                progressBar.setVisibility(View.GONE);

                String code = phoneAuthCredential.getSmsCode();

                if (code != null){
                    otpEditText.setText(code);
                    verifyVerficationcode(code);
                }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(VerifyPhoneActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mverficationID = s;
        }
    };
    //manual method
    private void verifyVerficationcode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mverficationID,code);
        signInWithPhoneAuthCredentials(credential);
    }

    private void signInWithPhoneAuthCredentials(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(VerifyPhoneActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //I am going store the user token
                    SharedPreferences sharedPreferences;
                    sharedPreferences = getSharedPreferences(String.valueOf("Chatter Box"), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name","Rohit Jain");
                    editor.putString("Mobile",mobile);
                    editor.commit();
                    //I am going to start my new Activity
                    Intent intent = new Intent(VerifyPhoneActivity.this,DisplaySocietyActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    // I am going to through a firebase exception
                    String message = "Something wrong happend please try again";
                    if (task.getException() instanceof FirebaseException){
                        Toast.makeText(getApplicationContext(),"OTP Error",Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(getApplicationContext(),"Please Try again",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
