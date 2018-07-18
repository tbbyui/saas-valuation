package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.justin.myapplication.model.Valuation;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private static final String TAG = "Home";
    List<String> valuations;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        valuations = new ArrayList<>();

        valuations = new ArrayList<> ();
        listView = (ListView) findViewById(R.id.listViewValuation);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, valuations);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                display(view);
                Toast.makeText(Home.this, valuations.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                valuations.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    valuations.add(child.getKey().toString());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    /**
     * Navigate back to Login activity.
     * @param view
     */
    public void logout(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /**
     * Show the information of that company and navigate to Display activity.
     * @param view
     */
    public void display(View view) {
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);
    }

    /**
     * Create a new company that it needs to do the valuation and navigate to Display activity.
     * @param view
     */
    public void create(View view) {
        Intent intent = new Intent(this, CreateValuation.class);
        startActivity(intent);
    }

}
