package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private static final String TAG = "Home";
    List<String> valuations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        valuations = new ArrayList<>();
        valuations.add("Company Name:");
        valuations.add("hi");
        valuations.add("bob");
        valuations.add("bob's place");

        ListView listView = (ListView) findViewById(R.id.listViewValuation);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, valuations);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Home.this, valuations.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Logout and go back to Login activity.
     * @param view
     */
    public void logout(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    /**
     * Show the information of that company. Go to Display activity.
     * @param view
     */
    public void display(View view) {
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);
    }

    /**
     * Show the information of that company. Go to Display activity.
     * @param view
     */
    public void create(View view) {
        Intent intent = new Intent(this, CreateValuation.class);
        startActivity(intent);
    }

}
