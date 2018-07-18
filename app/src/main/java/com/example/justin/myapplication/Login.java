package com.example.justin.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justin.myapplication.controler.FirebaseDataHandler;
import com.example.justin.myapplication.model.CustomersInfo;
import com.example.justin.myapplication.model.Revenue;
import com.example.justin.myapplication.model.Valuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private final String TAG = "Login";
    public static final String USER = "User";
    private FirebaseAuth mAuth;
    private static final Boolean usingFirebase = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Valuation");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }



    /**
     * Login with username and password and navigate to Home activity.
     * @param view
     */
    public void login(View view) {
        startActivity(new Intent(this, Home.class));
//        EditText etEmail = findViewById(R.id.email);
//        EditText etPassword = findViewById(R.id.etPassword);
//
//        String user = etEmail.getText().toString();
//        String password = etPassword.getText().toString();
//
//        if (user.equals("")) {
//            ((TextView)findViewById(R.id.tvError)).setText("Email is Required");
//            return;
//        }
//        if (password.equals("")) {
//            ((TextView)findViewById(R.id.tvError)).setText("Password is Required");
//            return;
//        }
//
//
//        mAuth.signInWithEmailAndPassword(user, password)
//            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> login) {
//                    if (login.isSuccessful()) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "signInWithEmail:success");
//                        startActivity(new Intent(Login.this, Home.class));
//
//
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "signInWithEmail:failure", login.getException());
//                        ((TextView)findViewById(R.id.tvError)).setText("Failed to Login");
//
//                    }
//                }
//            });


//            SP sp = new SP(this);
//            sp.saveSP(USER, user);
//            String sp_user = sp.matchSP(USER);
//
//            // match the username to the shared preferences
//            if (sp_user.equals(user)) {
//                Intent intent = new Intent(this, Home.class);
//                startActivity(intent);
//            } else {
//                Toast.makeText(this, "The username is incorrect!!", Toast.LENGTH_SHORT).show();
//            }

    }

}
