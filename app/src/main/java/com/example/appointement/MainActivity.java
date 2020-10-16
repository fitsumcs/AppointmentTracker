package com.example.appointement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity extends AppCompatActivity implements MainFragment.OnItemSelectedListener, AddFragment.OnItemSelectedListener {


    MainFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        myFragment = new MainFragment();

        // add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.myContainer, myFragment);
        ft.commit();


    }

//    @Override
//    //Returns information passed from addAppointmentactivity
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                MainFragment myFragment = (MainFragment) fragmentManager.findFragmentById(R.id.mainFragment);
//
//                Appointment myAppointment = new Appointment(
//                        data.getStringExtra("name"),data.getStringExtra("type"),
//                        data.getStringExtra("monthOfYear"), data.getIntExtra("dayOfMonth", 0), data.getIntExtra("year", 1111),
//                        data.getIntExtra("hour", 11),data.getIntExtra("minute", 11),data.getStringExtra("AMorPM"));
//
//                myFragment.updateAppointmentListAndDisplay(myAppointment);
//            }
//        }
//    }

    @Override
    public void onButtonSelected() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, new AddFragment());
        ft.commit();

    }

    @Override
    public void onAddAppointmentSelected(Appointment appt) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        myFragment.updateAppointmentList(appt);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, myFragment);
        ft.commit();

    }

    @Override
    public void onCancel() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.myContainer, myFragment);
        ft.commit();
    }

//    @Override
//    //Returns information passed from addAppointmentactivity
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//
//                //Creates a new appointment with the information passed
//                appointmentArrayList.add(new Appointment(
//                        data.getStringExtra("name"),data.getStringExtra("type"),
//                        data.getStringExtra("monthOfYear"), data.getIntExtra("dayOfMonth", 0), data.getIntExtra("year", 1111),
//                        data.getIntExtra("hour", 11),data.getIntExtra("minute", 11),data.getStringExtra("AMorPM")));
//                //Displays new appointment on in the table
//                populateTable(appointmentArrayList.size()-1);
//            }
//        }
//    }



}