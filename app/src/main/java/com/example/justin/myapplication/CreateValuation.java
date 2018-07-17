package com.example.justin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justin.myapplication.controler.FirebaseDataHandler;
import com.example.justin.myapplication.model.CustomersInfo;
import com.example.justin.myapplication.model.Revenue;
import com.example.justin.myapplication.model.Valuation;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateValuation extends AppCompatActivity {
    private static final String TAG = "CreateValuation";
    Map<String, EditText> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_valuation);
        values = new HashMap<>();
    }

    public void showError(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

    private boolean isEmpty(EditText input) {
        if(input.getText().equals("")) {
            return true;
        }
        return false;
    }

    private boolean checkViews() {
        return false;
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
            info.addMonth(Month.MARCH, new Year(2020),1000,100);
            info.addMonth(Month.FEBRUARY, new Year(2020), 4000,3000);
        } catch (Exception e) {}
        v.setCustomers(info);

        Gson g = new Gson();

        String s = g.toJson(v);
        Log.i(TAG, v.toString());
        db.store("Valuation", g);

        Valuation newVal = g.fromJson(s, Valuation.class);
        Log.i(TAG, newVal.toString());
    }


    public void onCancel(View view) {
        startActivity(new Intent(this, Home.class));
    }

    public void onSubmit(View view) {
        values.put("compName", (EditText)findViewById(R.id.etCompName));
        values.put("marketingCost", (EditText)findViewById(R.id.etCompName));
        values.put("subCost", (EditText)findViewById(R.id.etCompName));
        values.put("tam", (EditText)findViewById(R.id.etCompName));
        values.put("lastRev", (EditText)findViewById(R.id.etCompName));
        values.put("revThis", (EditText)findViewById(R.id.etCompName));
        values.put("custStart", (EditText)findViewById(R.id.etCompName));
        values.put("custLoss", (EditText)findViewById(R.id.etCompName));


    }

}
