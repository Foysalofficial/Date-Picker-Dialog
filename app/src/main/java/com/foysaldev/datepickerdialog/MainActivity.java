package com.foysaldev.datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton button;
    TextView textView;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.Buttonid);
        textView = findViewById(R.id.TextView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = new DatePicker(MainActivity.this);
                int currentYear = datePicker.getYear();
                int currentMonth = (datePicker.getMonth())+1;
                int currentDay = datePicker.getDayOfMonth();

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                textView.setText("Day:"+i2+"/"+"Month:"+(+i1+1)+"/"+"Year:"+i);
                            }
                        },currentYear, currentMonth ,currentDay);
                datePickerDialog.show();
            }
        });
    }
}