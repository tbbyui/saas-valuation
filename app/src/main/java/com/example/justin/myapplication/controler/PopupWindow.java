package com.example.justin.myapplication.controler;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import com.example.justin.myapplication.R;


public class PopupWindow extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.popwindow);

            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);

            int width = dm.widthPixels;
            int height = dm.heightPixels;

            getWindow().setLayout((int) (width*.8), (int) (height*.6));
        }

        public void onAdd(View view) {
            Toast.makeText(this, "Addition Successful",Toast.LENGTH_SHORT).show();
        }
    }
