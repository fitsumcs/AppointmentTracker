package com.example.appointement;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
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

import androidx.fragment.app.DialogFragment;
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

    private AddFragment.OnItemSelectedListener listener;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        //finish button
        Button cancel = (Button)view.findViewById(R.id.btCancleAp);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
      //add appointment
        Button addTask = (Button)view.findViewById(R.id.btAddAp);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editAppointmentName = (EditText) getActivity().findViewById(R.id.edNameAp);
                Spinner spinnerAppointmentType = (Spinner) getActivity().findViewById(R.id.spTypeAp);
                if(!(editAppointmentName.getText().toString()).isEmpty()){

                    Appointment app = new Appointment(editAppointmentName.getText().toString(), spinnerAppointmentType.getSelectedItem().toString(),
                            new MyHelper().DisplayTheMonthInCharacters(theMonth), theDay, theYear, new MyHelper().FormatTheHour(theHoure), theMinute, new MyHelper().AMorPM(theHoure));

                    listener.onAddAppointmentSelected(app);
                }
                else {
                    Toast toast = Toast.makeText(getActivity(), "Please enter an Appointment Name", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
        }

        setDateInstance();

        TextView time = (TextView) getActivity().findViewById(R.id.tvTimeAp);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        TextView date = (TextView) getActivity().findViewById(R.id.tvDateAp);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddFragment.OnItemSelectedListener) {
            listener = (AddFragment.OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }
    public interface OnItemSelectedListener {
        public void onAddAppointmentSelected(Appointment appt);
    }

    private void showDatePicker() {
        DatePickerFragment date = new DatePickerFragment();

        Bundle args = new Bundle();
        args.putInt("year", theYear);
        args.putInt("month", theMonth);
        args.putInt("day", theDay);
        date.setArguments(args);

        date.setCallBack(ondate);
        date.show(getFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth,
                              int selectedDay) {

            theYear = selectedYear;
            theMonth = selectedMonth;
            theDay = selectedDay;

            txDate.setText(new StringBuilder().append(theMonth + 1)
                    .append("-").append(theDay).append("-").append(theYear)
                    .append(" "));
        }
    };

    private void showTimePicker() {
        TimePickerFragment time = new TimePickerFragment();

        Bundle args = new Bundle();
        args.putInt("hour", theHoure);
        args.putInt("minute", theMinute);
        time.setArguments(args);

        time.setCallBack(onTime);
        time.show(getFragmentManager(), "Time Picker");
    }

    TimePickerDialog.OnTimeSetListener onTime = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
            theHoure = selectedHour;
            theMinute = selectedMinute;

            // set current time into textview
            txTime.setText(new StringBuilder().append(new MyHelper().pad(theHoure))
                    .append(":").append(new MyHelper().pad(theMinute)));
        }
    };




    private void setDateInstance() {


        final Calendar c = Calendar.getInstance();
        theYear = c.get(Calendar.YEAR);
        theMonth = c.get(Calendar.MONTH);
        theDay = c.get(Calendar.DAY_OF_MONTH);

        theHoure = c.get(Calendar.HOUR_OF_DAY);
        theMinute = c.get(Calendar.MINUTE);

        saveData(theHoure,theMinute,theMonth,theDay,theYear);
    }

    //save data
    private  void saveData(int theHoure,int theMinute,int theMonth,int theDay,int theYear)
    {
        txDate = (TextView)getActivity().findViewById(R.id.tvDateAp);
        txTime = (TextView)getActivity().findViewById(R.id.tvTimeAp);


        // set current time into textview
        txTime.setText(new StringBuilder().append(new MyHelper().pad(theHoure))
                .append(":").append(new MyHelper().pad(theMinute)));

        // set current date into textview
        txDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(theMonth + 1).append("-").append(theDay).append("-")
                .append(theYear).append(" "));
    }


    public static class DatePickerFragment extends DialogFragment {
        DatePickerDialog.OnDateSetListener ondateSet;
        private int year, month, day;

        public DatePickerFragment() {}

        public void setCallBack(DatePickerDialog.OnDateSetListener ondate) {
            ondateSet = ondate;
        }

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            year = args.getInt("year");
            month = args.getInt("month");
            day = args.getInt("day");
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new DatePickerDialog(getActivity(), ondateSet, year, month, day);
        }
    }

    public static class TimePickerFragment extends DialogFragment {
        TimePickerDialog.OnTimeSetListener onTimeSet;
        private int hour, minute;

        public TimePickerFragment() {}

        public void setCallBack(TimePickerDialog.OnTimeSetListener ontime) {
            onTimeSet = ontime;
        }

        @Override
        public void setArguments(Bundle args) {
            super.setArguments(args);
            hour = args.getInt("hour");
            minute = args.getInt("minute");
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new TimePickerDialog(getActivity(), onTimeSet, hour, minute, false);
        }
    }

}
