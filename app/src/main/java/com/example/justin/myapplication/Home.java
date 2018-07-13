package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
