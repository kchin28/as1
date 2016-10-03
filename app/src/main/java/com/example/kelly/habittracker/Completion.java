package com.example.kelly.habittracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kelly on 2016-09-26.
 */
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
