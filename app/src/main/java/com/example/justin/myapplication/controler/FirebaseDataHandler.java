package com.example.justin.myapplication.controler;

import android.util.Log;

import com.example.justin.myapplication.model.Valuation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDataHandler {
    private static String TAG = "FireBaseHandler";

    FirebaseDatabase database;

    public void store(String key, Object o){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(key);

        myRef.setValue(o);

        Log.i(TAG, "Stored: \"" + key.toString() + "\" as \"" + o.toString());

    }
}
