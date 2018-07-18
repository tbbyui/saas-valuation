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

    /**
     * Storing the information from the app into the firebase.
     * @param key
     * @param o
     */
    public void store(String key, Object o){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(key);

        myRef.setValue(o);

        Log.i(TAG, "Stored: \"" + key.toString() + "\" as \"" + o.toString());

    }
<<<<<<< HEAD

    /**
     *
     * @param key
     */
    public void readValuation(String key) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(key);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
=======
>>>>>>> 86b3d8956f1a2dee963a960470b99a5a718b1379
}
