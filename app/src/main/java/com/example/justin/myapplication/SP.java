package com.example.justin.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class SP {

    Context context;

    /**
     * A constructor of shared preferences.
     * @param context creates an own context
     */
    public SP(Context context) {
        this.context = context;
    }

    /**
     * A save function of shared preferences.
     * @param key passing a string key that identified the information in the shared preferences.
     * @param value passing a string value that want to save in the shared preferences.
     */
    public void saveSP(String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sp.edit();

        editor.putString(Login.USER, value);

        editor.commit();

        Toast.makeText(context, "It saved in the SharedPreferences!!", Toast.LENGTH_SHORT).show();
    }

    /**
     * A match function that match the input and the information in the shared preferences.
     * @param key passing a string key that identified the information in the shared preferences.
     * @return an information from the shared preferences.
     */
    public String matchSP(String key) {
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);

        String user = sp.getString(key, null);

        Toast.makeText(context, "User name matched!!", Toast.LENGTH_SHORT).show();
        return user;
    }
}
