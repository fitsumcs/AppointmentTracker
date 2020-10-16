package com.example.appointement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    public ArrayList<Appointment> appointmentArrayList = new ArrayList<Appointment>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
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
        TableLayout appointmentTBL = (TableLayout) getActivity().findViewById(R.id.tbList);

        TableRow newTableRow = new TableRow(getActivity());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        newTableRow.setLayoutParams(lp);

        TextView txtvName = new TextView(getActivity());
        // txtvName.setLayoutParams(lp);
        txtvName.setText(appointmentArrayList.get(arrayListCounter).name);
        txtvName.setWidth(140);
        txtvName.setTextAppearance(R.style.textViewStyle);

        TextView txtvType = new TextView(getActivity());
        //txtvType.setLayoutParams(lp);
        txtvType.setText(appointmentArrayList.get(arrayListCounter).type);
        txtvType.setWidth(93);
        txtvType.setTextAppearance(R.style.textViewStyle);



        TextView txtvDate = new TextView(getActivity());
        // txtvDate.setLayoutParams(lp);
        txtvDate.setText(new MyHelper().SetToDateAndTime(appointmentArrayList.get(arrayListCounter)));
        txtvDate.setWidth(97);
        txtvDate.setTextAppearance(R.style.textViewStyle);

        newTableRow.addView(txtvName);
        newTableRow.addView(txtvType);
        newTableRow.addView(txtvDate);
        appointmentTBL.addView(newTableRow,arrayListCounter+1);
    }



    public void addAppointement(View view) {
        //startActivityForResult(new Intent(this,addAppointement.class),1);
    }




}
