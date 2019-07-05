package com.upgrad.sharedprefrencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public static final String Name = "person_name";
    public static final String Email = "email_add";
    public static final String Phone = "phone_no";
    SharedPreferences sharedpreferences;
    EditText et_name;
    EditText et_email;
    EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText) findViewById(R.id.etName);
        et_email = (EditText) findViewById(R.id.etEmail);
        et_phone = (EditText) findViewById(R.id.etPhone);
        //custom prefrence
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        //Show data in EditTexts when app is launched, if data is there in Android Shared Preferences
        if (sharedpreferences.contains(Name))
            et_name.setText(sharedpreferences.getString(Name, ""));
        if (sharedpreferences.contains(Email))
            et_email.setText(sharedpreferences.getString(Email, ""));
        if (sharedpreferences.contains(Phone))
            et_phone.setText(sharedpreferences.getString(Phone, ""));
    }


    public void Store(View view) {
        String n = et_name.getText().toString();
        String e = et_email.getText().toString();
        String p = et_phone.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.putString(Phone, p);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Data Stored Successfuly!", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        et_name = (EditText) findViewById(R.id.etName);
        et_email = (EditText) findViewById(R.id.etEmail);
        et_phone = (EditText) findViewById(R.id.etPhone);
        et_name.setText("");
        et_email.setText("");
        et_phone.setText("");
        Toast.makeText(getApplicationContext(), "Data Cleared Successfuly!", Toast.LENGTH_SHORT).show();
    }

    public void Fetch(View view) {
        et_name = (EditText) findViewById(R.id.etName);
        et_email = (EditText) findViewById(R.id.etEmail);
        et_phone = (EditText) findViewById(R.id.etPhone);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name))
            et_name.setText(sharedpreferences.getString(Name, ""));
        if (sharedpreferences.contains(Email))
            et_email.setText(sharedpreferences.getString(Email, ""));
        if (sharedpreferences.contains(Phone))
            et_phone.setText(sharedpreferences.getString(Phone, ""));
        Toast.makeText(getApplicationContext(), "Data Displayed Successfuly!", Toast.LENGTH_SHORT).show();
    }

}
