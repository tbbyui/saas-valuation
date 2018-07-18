package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.justin.myapplication.model.Valuation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class Display extends AppCompatActivity {
    private static final String TAG = "Display";
    Valuation valuation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        valuation = null;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bob");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson g = new Gson();
                valuation = g.fromJson(value, Valuation.class);
                setUI();
                Log.d(TAG, valuation.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    private void setTextView(int id, String value) {
        ((TextView)findViewById(id)).setText(value);
    }

    private void setUI() {
        setTextView(R.id.dataTam,((Long)valuation.getTam()).toString());

    }

    /**
     * Go back to Home activity.
     * @param view
     */
    public void cancel(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    /**
     * Edit the information and go to DataEntry activity.
     * @param view
     */
    public void edit(View view) {

    }


    public void cancelEdit(View view) {}

    public void submit(View view) {

    }

    /**
     * Accepted the information and saved it. After that go back to Home
     * activity and the status will show completed/accepted.
     * @param view
     */
    public void accept(View view) {

    }

    /**
     * Declined the information and saved it. After that fo back
     * to Home activity and the status will show declined.
     * @param view
     */
    public void decline(View view) {

    }

    public void archive(View view) {

    }
}

