package com.example.justin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justin.myapplication.controler.FirebaseDataHandler;
import com.example.justin.myapplication.model.CustomersInfo;
import com.example.justin.myapplication.model.Revenue;
import com.example.justin.myapplication.model.Valuation;
import com.google.gson.Gson;

import java.lang.reflect.Field;
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

    private double parseDouble(String valuesKey) {
        return Double.parseDouble(values.get(valuesKey).getText().toString());
    }
    private int parseInt(String valuesKey) {
        return Integer.parseInt(values.get(valuesKey).getText().toString());
    }

    public void onSubmit(View view) {
        Log.i(TAG, "Submitted");
        values.clear();
        values.put("Company Name", (EditText)findViewById(R.id.etCompName));
        values.put("Marketing Cost", (EditText)findViewById(R.id.etMarketingCost));
        values.put("Subscription Cost", (EditText)findViewById(R.id.etSubCost));
        values.put("TAM", (EditText)findViewById(R.id.etTam));
        values.put("Last Year's Revenue", (EditText)findViewById(R.id.etRevLastYear));
        values.put("This Year's Revenue", (EditText)findViewById(R.id.etRevThisYear));
        values.put("Customers at the Start of Month", (EditText)findViewById(R.id.etCustAtStart));
        values.put("Customer Over Last Month", (EditText)findViewById(R.id.etCustLoss));
        values.put("Year", (EditText)findViewById(R.id.etYear));

        for (Map.Entry<String, EditText> entry : values.entrySet()) {
            if (entry.getValue().getText().toString().equals("")) {
                String err = entry.getKey() + " is Required";
                ((TextView)findViewById(R.id.tvErrorCreate)).setText(err);
                Log.e(TAG, err);
                return;
            }
        }



        FirebaseDataHandler db = new FirebaseDataHandler();
        Valuation v = new Valuation();

        v.setMarketingCost(parseDouble("Marketing Cost"));
        v.setSubscriptionPrice(parseDouble("Subscription Cost"));
        v.setRevenueObj(new Revenue(parseDouble("This Year's Revenue"), parseDouble("Last Year's Revenue")));
        CustomersInfo info  = new CustomersInfo();


        try {
            String month = ((Spinner)findViewById(R.id.monthSpinner)).getSelectedItem().toString();
            info.addMonth(
                    Month.of(month),
                    new Year(parseInt("Year")),
                    parseInt("Customers at the Start of Month"),
                    parseInt("Customer Over Last Month"));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        v.setCustomers(info);

        Gson g = new Gson();

        String s = g.toJson(v);
        Log.i(TAG, v.toString());
        db.store(values.get("Company Name").getText().toString(), s);



    }

}
