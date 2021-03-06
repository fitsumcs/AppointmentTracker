package com.example.appointement;

import android.content.Context;
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

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button b = (Button)view.findViewById(R.id.btAddMa);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onButtonSelected();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
        }

        populateElement();

    }

    private void populateElement() {
        for(int i = 0; i < appointmentArrayList.size(); i++){
            populateTable(i);
        }
    }



    public void updateAppointmentList(Appointment appt)
    {
        appointmentArrayList.add(appt);
    }

    public interface OnItemSelectedListener {
        public void onButtonSelected();
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








}
