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

<<<<<<< HEAD

    }


=======
        Intent  intent = new Intent(this, Login.class);
        startActivity(intent);

    }
>>>>>>> c1429e6557a556220474632552ee776b3273e99d
}
