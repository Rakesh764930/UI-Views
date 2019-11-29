package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RatingBar rbRating;
    ProgressBar pbBar;
    AutoCompleteTextView atcView;
    int progress_status = 0;

    Handler handler = new Handler();
    Button btn;
    CheckBox cb1, cb2, cb3, cb4, cb5;
    SeekBar seekBar2;


    RadioGroup rgGender;
    RadioButton rbMale;
    RadioButton rbFemale;
    RadioButton rbOthers;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] countries = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.atcView);
        textView.setAdapter(adapter);


        // Rating Bar

        rbRating = findViewById(R.id.rb_rating);
        rbRating.setNumStars(5);
        rbRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(MainActivity.this, "You rated" + v + "stars", Toast.LENGTH_SHORT).show();
            }
        });
        rgGender=findViewById(R.id.rgGender);
        rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);
        rbOthers=findViewById(R.id.rbOthers);

btn=findViewById(R.id.button);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this, OtherActivity.class);
        startActivity(intent);
    }
});



        // Radio buttons
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (rbMale.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Male", Toast.LENGTH_SHORT).show();
                if (rbFemale.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Female", Toast.LENGTH_SHORT).show();
                if (rbOthers.isChecked())
                    Toast.makeText(MainActivity.this, "You Chose Others", Toast.LENGTH_SHORT).show();
            }
        });



        //progress bar
        pbBar = findViewById(R.id.pbBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress_status < 100) {
                    progress_status++;
                    android.os.SystemClock.sleep(50);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pbBar.setProgress(progress_status);
                        }
                    });
                }

            }
        }).start();
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb5);
        cb5 = findViewById(R.id.cb1);

        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);
        cb4.setOnClickListener(this);
        cb5.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (cb1.isChecked())
            Toast.makeText(MainActivity.this, "You Chose SQL", Toast.LENGTH_SHORT).show();

        if (cb2.isChecked())
            Toast.makeText(MainActivity.this, "You Chose Java", Toast.LENGTH_SHORT).show();
        if (cb3.isChecked())
        Toast.makeText(MainActivity.this, "You Chose Swift", Toast.LENGTH_SHORT).show();

        if (cb4.isChecked())
            Toast.makeText(MainActivity.this, "You Chose iOs", Toast.LENGTH_SHORT).show();


        if (cb5.isChecked())
            Toast.makeText(MainActivity.this, "You Chose Android", Toast.LENGTH_SHORT).show();
    }
}