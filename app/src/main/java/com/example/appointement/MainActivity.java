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





}