package com.example.justin.myapplication;

import android.content.Context;
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

public class CreateValuation extends AppCompatActivity {
    private static final String TAG = "CreateValuation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_valuation);
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
        db.store("Valuation", s);

        Valuation newVal = g.fromJson(s, Valuation.class);
        Log.i(TAG, newVal.toString());
    }


    public void onCancel(View view) {
        showError("This Works");
    }

    public void onSubmit(View view) {
        if (checkViews()){

        }
    }

}
