package com.example.justin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
    }

    public void edit(View view) {}

    public void cancelEdit(View view) {}

    public void submit(View view) {}

    public void accept(View view) {}

    public void archive(View view) {}
}
