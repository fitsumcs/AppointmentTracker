package com.example.appointement;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class MyHelper {

    /* Helper Methods */

    //Returns the Month Abbreviation for the corresponding number.
    public String DisplayTheMonthInCharacters(int passedMonth){
        switch(passedMonth){
            case 0:
                return "Jan";
            case 1:
                return"Feb";
            case 2:
                return"Mar";
            case 3:
                return"Apr";
            case 4:
                return"May";
            case 5:
                return"Jun";
            case 6:
                return"Jul";
            case 7:
                return"Aug";
            case 8:
                return"Sept";
            case 9:
                return"Oct";
            case 10:
                return"Nov";
            case 11:
                return"Dec";

        }
        return "";
    }

    //Converts the 24 hours PassedHour to a 12 Hour time.
    public int FormatTheHour(int passedHour){
        if (passedHour > 12){ passedHour -= 12; }
        return passedHour;
    }

    //Returns AM or PM depending on the hour (1-24)
    public String AMorPM(int passedHour){
        if (passedHour > 12){ return "PM"; }
        else{ return "AM"; }
    }


    public String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
   //set date and time
    public String SetToDateAndTime(Appointment appointment){
        long currentDateAndTime = System.currentTimeMillis(); //Todays Date
        SimpleDateFormat formatDate = new SimpleDateFormat("MMM d, yyyy"); //Date Format

        String todaysDate = formatDate.format(currentDateAndTime); //Today's date formated
        String passDate = appointment.theMonth +" " + appointment.theDay +", " + appointment.theYear; //Tasks date formated the same way

        if(Objects.equals(todaysDate, passDate)){ //Compare today's date and passed date, return time if dates match
            return appointment.theHoure +":" +appointment.theMinute +" " +appointment.format_AM_PM;
        }
        return appointment.theMonth +" " + appointment.theDay +", " + appointment.theYear; //Otherwise, return the date

    }


}
