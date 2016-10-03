package com.example.kelly.habittracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Copyright (C) 2016, Kelly Chin
* Extends from Date, but overrides toString method with a specific date format
* */
public class Completion extends Date {

    public Completion(){
        super();
    }
    public Completion(long l){super();}

    public String toString(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        String displayDate = dateFormat.format(this);

        return displayDate;
    }
}
