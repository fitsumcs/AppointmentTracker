package com.example.appointement;

public class Appointment {

    public String name;
    public String type;
    public int theYear;
    public String theMonth;
    public int theDay;
    public int theHoure;
    public int theMinute;
    public String format_AM_PM;

    public Appointment(String name, String type, String theMonth,int theYear, int theDay, int theHoure, int theMinute, String format_AM_PM) {
        this.name = name;
        this.type = type;
        this.theYear = theYear;
        this.theMonth = theMonth;
        this.theDay = theDay;
        this.theHoure = theHoure;
        this.theMinute = theMinute;
        this.format_AM_PM = format_AM_PM;
    }




}
