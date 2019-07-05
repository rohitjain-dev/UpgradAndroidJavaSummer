package com.upgrad.shrdprefdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedprefenceUtills sharedprefenceUtills;

    Button loginButton;

    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedprefenceUtills = new SharedprefenceUtills(getApplicationContext());

        loginButton = findViewById(R.id.loginbutton);
        email = findViewById(R.id.emailedittext);
        password = findViewById(R.id.passwordedittext);

        //check

        if (sharedprefenceUtills.checkuseremailandpassword())
        {
            email.setText(sharedprefenceUtills.getuseremail());
            password.setText(sharedprefenceUtills.getuserpassword());
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                sharedprefenceUtills.saveLoginDetails(user_email,user_password);
                Toast.makeText(getApplicationContext(),"Data is saved",Toast.LENGTH_LONG).show();
            }
        });
    }
}
