

package com.example.appointement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class addAppointement extends AppCompatActivity implements AddFragment.OnItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointement);
    }


    @Override
    public void onAddAppointmentSelected(Appointment appt) {
        Intent intent = new Intent();

            intent.putExtra("name", appt.name);

            intent.putExtra("type", appt.type);

            intent.putExtra("monthOfYear", appt.theMonth);
            intent.putExtra("dayOfMonth", appt.theDay);
            intent.putExtra("year", appt.theYear);

            intent.putExtra("hour", appt.theHoure);
            intent.putExtra("minute", appt.theMinute);
            intent.putExtra("AMorPM", appt.format_AM_PM);

            setResult(RESULT_OK, intent);

            finish();
    }
}