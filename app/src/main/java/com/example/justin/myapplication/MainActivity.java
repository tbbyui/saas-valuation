package com.example.justin.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//

    }

    public void click(View view) {
        View text = findViewById(R.id.tv);
        if (text.getVisibility() == View.INVISIBLE) {
            text.setVisibility(View.VISIBLE);
        } else if (text.getVisibility() == View.VISIBLE) {
            text.setVisibility(View.INVISIBLE);
        }
    }

}
