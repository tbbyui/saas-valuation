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
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;

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
    }



    /**
     * Login with username and password. Go to Home activity.
     * @param view
     */
    public void login(View view) {

        EditText editText_User = findViewById(R.id.user);
        EditText editText_Password = findViewById(R.id.pw);

        String user = editText_User.getText().toString();
        String password = editText_Password.getText().toString();

        if (usingFirebase) {
            mAuth.signInWithEmailAndPassword(user, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> login) {
                            if (login.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                updateUI(mAuth.getCurrentUser());
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", login.getException());

                                updateUI(null);
                            }
                        }
                    });
        } else {

            SP sp = new SP(this);
            sp.saveSP(USER, user);
            String sp_user = sp.matchSP(USER);

            // match the username to the shared preferences
            if (sp_user.equals(user)) {
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "The username is incorrect!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void updateUI(FirebaseUser user) {
        TextView display = findViewById(R.id.display);
        if (user != null) {
            display.setText(user.getEmail().toString());
        } else {
            display.setText("Failed to Login");
        }
    }

    public void test(View view) {
        FirebaseDataHandler db = new FirebaseDataHandler();
        Valuation v = new Valuation();
        v.setMarketingCost(100.32d);
        v.setSubscriptionPrice(19.98d);
        v.setRevenueObj(new Revenue(13432111.22, 133243.23));
        CustomersInfo info  = new CustomersInfo();
        try {
            info.addMonth(Month.APRIL, new Year(2020), 3999,2000);
            v.getCustomers().addMonth(Month.MARCH, new Year(2020),1000,100);
        } catch (Exception e) {}
        v.setCustomers(info);


        db.store("Valuation", v);
    }
}
