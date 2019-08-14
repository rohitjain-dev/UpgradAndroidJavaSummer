package com.upgrad.chatterbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import com.hbb20.CountryCodePicker;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText name,mobilenumber;
    private Button continueButton;
    private CountryCodePicker countryCodePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.nameEditText);
        mobilenumber = (EditText) findViewById(R.id.mobileNumberEditText);
        continueButton = (Button) findViewById(R.id.continueButton);
        countryCodePicker = (CountryCodePicker) findViewById(R.id.ccp);
        countryCodePicker.registerCarrierNumberEditText(mobilenumber);
        countryCodePicker.setNumberAutoFormattingEnabled(false);
        countryCodePicker.isValidFullNumber();

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = mobilenumber.getText().toString().trim();

                if (mobile.isEmpty() || mobile.length()<10){
                    mobilenumber.setError("Enter a Valid Mobile Number");
                    mobilenumber.requestFocus();
                    return;
                }

                mobile = countryCodePicker.getFullNumberWithPlus();

                Intent intent = new Intent(LoginActivity.this,VerifyPhoneActivity.class);
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });
    }
}
