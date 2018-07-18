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
    private static final String COMPANYNAME = "Company Name";
    private static final String MARKETINGCOST = "Marketing Cost";
    private static final String SUBCOST = "Subscription Cost";
    private static final String TAM = "TAM";
    private static final String LASTYEARREVENUE = "Last Year's Revenue";
    private static final String THISYEARREVENUE = "This Year's Revenue";
    private static final String STARTOFMONTH= "Customers at the Start of Month";
    private static final String OVERLASTMONTH = "Customer Over Last Month";
    private static final String YEAR = "Year";
    private static final String SUMITTED = "Submitted";
    private static final String ISREQUIRED = " is Required";

    Map<String, EditText> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_valuation);
        values = new HashMap<>();
    }

    /**
     *
     * @param message
     */
    public void showError(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.show();
    }

//    public void test(View view) {
//        FirebaseDataHandler db = new FirebaseDataHandler();
//        Valuation v = new Valuation();
//        v.setMarketingCost(100.32d);
//        v.setSubscriptionPrice(19.98d);
//        v.setRevenueObj(new Revenue(13432111.22, 133243.23));
//        CustomersInfo info  = new CustomersInfo();
//        try {
//
//            info.addMonth(Month.APRIL, new Year(2020), 3999,2000);
//            info.addMonth(Month.MARCH, new Year(2020),1000,100);
//            info.addMonth(Month.FEBRUARY, new Year(2020), 4000,3000);
//        } catch (Exception e) {}
//        v.setCustomers(info);
//
//        Gson g = new Gson();
//
//        String s = g.toJson(v);
//        Log.i(TAG, v.toString());
//        db.store("Valuation", g);
//
//        Valuation newVal = g.fromJson(s, Valuation.class);
//        Log.i(TAG, newVal.toString());
//    }

    /**
     * Navigate back to the Home activity.
     * @param view
     */
    public void onCancel(View view) {
        startActivity(new Intent(this, Home.class));
    }

    /**
     * Parsing from string to double.
     * @param valuesKey
     * @return
     */
    private double parseDouble(String valuesKey) {
        return Double.parseDouble(values.get(valuesKey).getText().toString());
    }

    /**
     * Parsing from string to integer.
     * @param valuesKey
     * @return
     */
    private int parseInt(String valuesKey) {
        return Integer.parseInt(values.get(valuesKey).getText().toString());
    }

    /**
     * Pass all the information from the user to the firebase
     * @param view
     */
    public void onSubmit(View view) {
        Log.i(TAG, SUMITTED);
        values.clear();
        values.put(COMPANYNAME, (EditText)findViewById(R.id.etCompName));
        values.put(MARKETINGCOST, (EditText)findViewById(R.id.etMarketingCost));
        values.put(SUBCOST, (EditText)findViewById(R.id.etSubCost));
        values.put(TAM, (EditText)findViewById(R.id.etTam));
        values.put(LASTYEARREVENUE, (EditText)findViewById(R.id.etRevLastYear));
        values.put(THISYEARREVENUE, (EditText)findViewById(R.id.etRevThisYear));
        values.put(STARTOFMONTH, (EditText)findViewById(R.id.etCustAtStart));
        values.put(OVERLASTMONTH, (EditText)findViewById(R.id.etCustLoss));
        values.put(YEAR, (EditText)findViewById(R.id.etYear));



        for (Map.Entry<String, EditText> entry : values.entrySet()) {
            if (entry.getValue().getText().toString().equals("")) {
                String err = entry.getKey() + ISREQUIRED;
                ((TextView)findViewById(R.id.tvErrorCreate)).setText(err);
                Log.e(TAG, err);
                return;
            }
        }



        FirebaseDataHandler db = new FirebaseDataHandler();

        Valuation v = new Valuation();

        v.setMarketingCost(parseDouble(MARKETINGCOST));
        v.setSubscriptionPrice(parseDouble(SUBCOST));
        v.setRevenueObj(new Revenue(parseDouble(THISYEARREVENUE), parseDouble(LASTYEARREVENUE)));
        CustomersInfo info  = new CustomersInfo();


        try {
            String month = ((Spinner)findViewById(R.id.monthSpinner)).getSelectedItem().toString();
            info.addMonth(
                    Month.of(month),
                    new Year(parseInt(YEAR)),
                    parseInt(STARTOFMONTH),
                    parseInt(OVERLASTMONTH));
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        v.setCustomers(info);

        Gson g = new Gson();

        String s = g.toJson(v);

        Log.i(TAG, v.toString());

        db.store(values.get(COMPANYNAME).getText().toString(), s);

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);

    }
}
