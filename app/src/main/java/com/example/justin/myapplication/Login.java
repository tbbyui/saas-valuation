package com.example.justin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static final String USER = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Login with username and password. Go to Home activity.
     * @param view
     */
    public void login(View view) {
        EditText user = findViewById(R.id.user);
        String str_user = user.getText().toString();

        SP sp = new SP(this);
        sp.saveSP(USER, str_user);
        String sp_user = sp.matchSP(USER);

        // match the username to the shared preferences
        if (sp_user.equals(str_user)){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "The username is incorrect!!", Toast.LENGTH_SHORT).show();
        }

    }
}
