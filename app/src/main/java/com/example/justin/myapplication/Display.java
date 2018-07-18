package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    private static final String VALUE_IS = "Value is: ";
    Valuation valuation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String s = bundle.getString(Home.VAL_ID);

        valuation = null;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(s);

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, VALUE_IS + value);
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
        setTextView(R.id.dataTam, valuation.getTamStr());
        setTextView(R.id.dataLtv,"Cac is coming");
        setTextView(R.id.dataGrowth,"Cac is coming");
        setTextView(R.id.dataArr,"Cac is coming");
        setTextView(R.id.dataChrun,"Cac is coming");
        setTextView(R.id.dataCac,"Cac is coming");

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
        startActivity(new Intent(this, Home.class));
        Toast.makeText(this, "The valuation has accepted!",Toast.LENGTH_SHORT).show();
    }

    /**
     * Declined the information and saved it. After that fo back
     * to Home activity and the status will show declined.
     * @param view
     */
    public void decline(View view) {
        startActivity(new Intent(this, Home.class));
        Toast.makeText(this, "The valuation has declined!",Toast.LENGTH_SHORT).show();
    }

    public void archive(View view) {

    }
}

