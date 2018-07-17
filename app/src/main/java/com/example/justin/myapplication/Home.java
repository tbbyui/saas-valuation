package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        valuations.add("hi");
        valuations.add("bob");
        valuations.add("bob's place");
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

    public void onSelect(View view) {
        Log.i(TAG, "bob's place");
    };
}
