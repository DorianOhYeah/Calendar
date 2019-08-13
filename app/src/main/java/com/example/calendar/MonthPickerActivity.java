package com.example.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MonthPickerActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_month;
    private MonthPicker mp_month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_picker);
        tv_month = findViewById(R.id.tv_month);
        mp_month = findViewById(R.id.mp_month);
        findViewById(R.id.btn_ok).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_ok) {
            String desc = String.format("The time is %d,%d",
                    mp_month.getYear(), mp_month.getMonth() + 1);
            tv_month.setText(desc);
        }
    }
}
