

package com.example.appointement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class addAppointement extends AppCompatActivity {

    TextView txDate;
    TextView txTime;

    private  int theYear;
    private  int theMonth;
    private  int theDay;

    private  int theHoure;
    private  int theMinute;

    static  final  int DATE_DIALOG_ID = 999;
    static  final  int TIME_DIALOG_ID = 998;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointement);
        setDateInstance();
    }

    private void setDateInstance() {
        txDate = (TextView)findViewById(R.id.tvDateAp);
        txTime = (TextView)findViewById(R.id.tvTimeAp);

        final Calendar c = Calendar.getInstance();
        theYear = c.get(Calendar.YEAR);
        theMonth = c.get(Calendar.MONTH);
        theDay = c.get(Calendar.DAY_OF_MONTH);

        theHoure = c.get(Calendar.HOUR_OF_DAY);
        theMinute = c.get(Calendar.MINUTE);

        // set current time into textview
        txTime.setText(new StringBuilder().append(pad(theHoure))
                .append(":").append(pad(theMinute)));

        // set current date into textview
        txDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(theMonth + 1).append("-").append(theDay).append("-")
                .append(theYear).append(" "));
    }

    private String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }


   //show date picker
    public void showDate(View v){


        showDialog(DATE_DIALOG_ID);

    }

   //show time picker
   public void showTime(View v){

       showDialog(TIME_DIALOG_ID);

   }
    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            theYear = selectedYear;
            theMonth = selectedMonth;
            theDay = selectedDay;

            // set selected date into textview
            txDate.setText(new StringBuilder().append(theMonth + 1)
                    .append("-").append(theDay).append("-").append(theYear)
                    .append(" "));
        }
    };
    //Time picker var
    private TimePickerDialog.OnTimeSetListener timePickerListener
            = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
            theHoure = selectedHour;
            theMinute = selectedMinute;

            // set current time into textview
            txTime.setText(new StringBuilder().append(pad(theHoure))
                    .append(":").append(pad(theMinute)));
        }
    };
    //Displays a new dialog for date picker or time picker
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        datePickerListener, theYear, theMonth,theDay);
            case TIME_DIALOG_ID:
                // set time picker as current time
                return new TimePickerDialog(this,
                        timePickerListener, theHoure, theMinute,false);
        }
        return null;
    }



}