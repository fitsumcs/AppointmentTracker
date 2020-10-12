package com.example.appointement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillDummyData();

    }

    private void fillDummyData() {
        appointmentArrayList.add(new Appointment("Doctors Visit","Health", "Oct", 9, 2016, 9, 00, "AM"));
        appointmentArrayList.add(new Appointment("Hair Cut appointment","Personal","Oct", 10, 2016,9,30,"AM"));
        appointmentArrayList.add(new Appointment("Meeting with Accountant","Personal","Oct", 11, 2016,11,00,"AM"));
        appointmentArrayList.add(new Appointment("Boss/HR Meeting","Work","Oct", 12, 2016,2,30,"PM"));
        appointmentArrayList.add(new Appointment("Teacher Conference","School","Nov", 1, 2016,9,30,"AM"));
        appointmentArrayList.add(new Appointment("Dentist For Son","Health","Nov", 1, 2016,9,30,"AM"));
        appointmentArrayList.add(new Appointment("Dinner With Friends","Other","Nov", 1, 2016,9,30,"AM"));

        for(int i = 0; i < appointmentArrayList.size(); i++){
            populateTable(i);
        }
    }

    private void populateTable(int arrayListCounter) {
        TableLayout appointmentTBL = (TableLayout) findViewById(R.id.tbList);

        TableRow newTableRow = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        newTableRow.setLayoutParams(lp);

        TextView txtvName = new TextView(this);
        txtvName.setLayoutParams(lp);
        txtvName.setGravity(Gravity.LEFT);
        txtvName.setText(appointmentArrayList.get(arrayListCounter).name);
        txtvName.setWidth(140);
        txtvName.setTextSize(12);

        TextView txtvType = new TextView(this);
        txtvType.setLayoutParams(lp);
        txtvType.setGravity(Gravity.LEFT);
        txtvType.setText(appointmentArrayList.get(arrayListCounter).type);
        txtvType.setWidth(93);
        txtvType.setTextSize(12);


        TextView txtvDate = new TextView(this);
        txtvDate.setLayoutParams(lp);
        txtvDate.setGravity(Gravity.LEFT);
        txtvDate.setText(new MyHelper().SetToDateAndTime(appointmentArrayList.get(arrayListCounter)));
        txtvDate.setWidth(97);
        txtvDate.setTextSize(12);
//        txtvDate.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        newTableRow.addView(txtvName);
        newTableRow.addView(txtvType);
        newTableRow.addView(txtvDate);
        appointmentTBL.addView(newTableRow,arrayListCounter+1);
    }


    @Override
    //Returns information passed from addAppointmentactivity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                //Creates a new appointment with the information passed
                appointmentArrayList.add(new Appointment(
                        data.getStringExtra("name"),data.getStringExtra("type"),
                        data.getStringExtra("monthOfYear"), data.getIntExtra("dayOfMonth", 0), data.getIntExtra("year", 1111),
                        data.getIntExtra("hour", 11),data.getIntExtra("minute", 11),data.getStringExtra("AMorPM")));
                //Displays new appointment on in the table
                populateTable(appointmentArrayList.size()-1);
            }
        }
    }
    public void addAppointement(View view) {
        startActivityForResult(new Intent(this,addAppointement.class),1);
    }


}