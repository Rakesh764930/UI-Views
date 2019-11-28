package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class calendarActivity extends AppCompatActivity {
 CalendarView calendarView;
 TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendarView=findViewById(R.id.cvDate);
        txt1=findViewById(R.id.txt1);
        calendarView.setOnDateChangeListener (new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date=(i1+1)+ "/" +i2+"/"+(i);
                txt1.setText(date);
            }
        });
    }
}
