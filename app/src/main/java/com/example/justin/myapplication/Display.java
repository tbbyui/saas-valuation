package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
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

    public void archive(View view) {}
}

