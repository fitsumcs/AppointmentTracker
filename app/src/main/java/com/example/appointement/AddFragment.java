package com.example.appointement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class AddFragment  extends Fragment {

    TextView txDate;
    TextView txTime;

    private  int theYear;
    private  int theMonth;
    private  int theDay;

    private  int theHoure;
    private  int theMinute;

    static  final  int DATE_DIALOG_ID = 999;
    static  final  int TIME_DIALOG_ID = 998;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);


        return view;
    }





//    //on  save instance
//    @Override
//    //Saves the currently Selected Date and Time
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putInt("Month", theMonth);
//        outState.putInt("Day", theDay);
//        outState.putInt("Year", theYear);
//
//        outState.putInt("Hour", theHoure);
//        outState.putInt("Minute", theMinute);
//    }
//    //on save restored
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        theMonth = savedInstanceState.getInt("Month");
//        theDay = savedInstanceState.getInt("Day");
//        theYear = savedInstanceState.getInt("Year");
//
//        theHoure = savedInstanceState.getInt("Hour");
//        theMinute = savedInstanceState.getInt("Minute");
//        saveData(theHoure,theMinute,theMonth,theDay,theYear);
//
//
//    }
//
//    private void setDateInstance() {
//
//
//        final Calendar c = Calendar.getInstance();
//        theYear = c.get(Calendar.YEAR);
//        theMonth = c.get(Calendar.MONTH);
//        theDay = c.get(Calendar.DAY_OF_MONTH);
//
//        theHoure = c.get(Calendar.HOUR_OF_DAY);
//        theMinute = c.get(Calendar.MINUTE);
//
//        saveData(theHoure,theMinute,theMonth,theDay,theYear);
//    }
//
//    //save data
//    private  void saveData(int theHoure,int theMinute,int theMonth,int theDay,int theYear)
//    {
//        txDate = (TextView)findViewById(R.id.tvDateAp);
//        txTime = (TextView)findViewById(R.id.tvTimeAp);
//
//
//        // set current time into textview
//        txTime.setText(new StringBuilder().append(new MyHelper().pad(theHoure))
//                .append(":").append(new MyHelper().pad(theMinute)));
//
//        // set current date into textview
//        txDate.setText(new StringBuilder()
//                // Month is 0 based, just add 1
//                .append(theMonth + 1).append("-").append(theDay).append("-")
//                .append(theYear).append(" "));
//    }
//
//    //show date picker
//    public void showDate(View v){
//
//
//        showDialog(DATE_DIALOG_ID);
//
//    }
//
//    //show time picker
//    public void showTime(View v){
//
//        showDialog(TIME_DIALOG_ID);
//
//    }
//    private DatePickerDialog.OnDateSetListener datePickerListener
//            = new DatePickerDialog.OnDateSetListener() {
//
//        // when dialog box is closed, below method will be called.
//        public void onDateSet(DatePicker view, int selectedYear,
//                              int selectedMonth, int selectedDay) {
//            theYear = selectedYear;
//            theMonth = selectedMonth;
//            theDay = selectedDay;
//
//            // set selected date into textview
//            txDate.setText(new StringBuilder().append(theMonth + 1)
//                    .append("-").append(theDay).append("-").append(theYear)
//                    .append(" "));
//        }
//    };
//    //Time picker var
//    private TimePickerDialog.OnTimeSetListener timePickerListener
//            = new TimePickerDialog.OnTimeSetListener() {
//        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
//            theHoure = selectedHour;
//            theMinute = selectedMinute;
//
//            // set current time into textview
//            txTime.setText(new StringBuilder().append(new MyHelper().pad(theHoure))
//                    .append(":").append(new MyHelper().pad(theMinute)));
//        }
//    };
//    //Displays a new dialog for date picker or time picker
//    @Override
//    protected Dialog onCreateDialog(int id) {
//        switch (id) {
//            case DATE_DIALOG_ID:
//                return new DatePickerDialog(this,
//                        datePickerListener, theYear, theMonth,theDay);
//            case TIME_DIALOG_ID:
//                // set time picker as current time
//                return new TimePickerDialog(this,
//                        timePickerListener, theHoure, theMinute,false);
//        }
//        return null;
//    }
//    //canlce button
//    public void cancle(View v){
//        finish();
//    }
//
//    //add button
//    public  void  add(View v)
//    {
//        EditText editAppointmentName = (EditText) findViewById(R.id.edNameAp);
//        Spinner spinnerAppointmentType = (Spinner) findViewById(R.id.spTypeAp);
//        if(!(editAppointmentName.getText().toString()).isEmpty()){
//            Intent intent = new Intent();
//
//            intent.putExtra("name", editAppointmentName.getText().toString());
//
//            intent.putExtra("type", spinnerAppointmentType.getSelectedItem().toString());
//
//            intent.putExtra("monthOfYear", new MyHelper().DisplayTheMonthInCharacters(theMonth));
//            intent.putExtra("dayOfMonth", theDay);
//            intent.putExtra("year", theYear);
//
//            intent.putExtra("hour", new MyHelper().FormatTheHour(theHoure));
//            intent.putExtra("minute", theMinute);
//            intent.putExtra("AMorPM", new MyHelper().AMorPM(theHoure));
//
//            setResult(RESULT_OK, intent);
//
//            finish();
//        }
//        else{
//            Toast toast = Toast.makeText(addAppointement.this, "Please enter an Appointment Title", Toast.LENGTH_SHORT);
//            toast.show();
//        }
//    }

}
