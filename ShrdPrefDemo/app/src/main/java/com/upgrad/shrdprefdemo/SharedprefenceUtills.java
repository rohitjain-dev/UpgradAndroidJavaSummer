package com.upgrad.shrdprefdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedprefenceUtills {

    public static final String FILE_NAME = "login";
    public static final String USER_EMAIL = "u_email";
    public static final String USER_PASSWORD = "u_password";
    Context context;

    public SharedprefenceUtills(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String email, String password){
        SharedPreferences mSharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mSharedPreferences.edit();

        editor.putString(USER_EMAIL,email);
        editor.putString(USER_PASSWORD,password);

        editor.commit();
    }


    public String getuseremail()
    {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        return mSharedPreferences.getString(USER_EMAIL,"");
    }

    public String getuserpassword()
    {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        return mSharedPreferences.getString(USER_PASSWORD,"");
    }

    public boolean checkuseremailandpassword()
    {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);

        if (mSharedPreferences.contains(USER_EMAIL) && mSharedPreferences.contains(USER_PASSWORD)) {
            return  true;
        }
        return false;
    }


}
