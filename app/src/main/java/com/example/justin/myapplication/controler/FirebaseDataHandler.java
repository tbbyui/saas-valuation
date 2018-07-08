package com.example.justin.myapplication.controler;

import android.util.Log;

import com.example.justin.myapplication.model.Valuation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDataHandler {
    private static String TAG = "FireBaseHandler";

    public void store(String key, Valuation v){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(key);

        myRef.setValue(v);

        Log.i(TAG, "Stored: \"" + key.toString() + "\" as \"" + v.toString());

    }
}
