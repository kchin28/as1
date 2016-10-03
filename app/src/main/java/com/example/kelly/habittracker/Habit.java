package com.example.kelly.habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kelly on 2016-09-21.
 */
public class Habit {
    private String Name;
    private Date CreationDate;
    private int[] occurance;
    private CompletionRecord record;


    //constructors
    public Habit(Date dateAdded, String HabitName, int[] howOften ){
        this.Name = HabitName;
        this.CreationDate = dateAdded;
        this.occurance=howOften;
        this.record = new CompletionRecord();
    }

    //methods
    public String getName(){
        return Name;
    }

//    public String getAllInfo(){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d");
//        String displayDate = dateFormat.format(getDate());
//
//        String output = this.getName() + " | Started on: " + displayDate;
//        return output;
//    }

    public Date getDate(){ return CreationDate; }

    public int getOccurance(int i){ return occurance[i];}

    public void addCompletion(Completion c){record.add(c);}

    public void deleteCompletion(Completion c){ record.remove(c);}

    public CompletionRecord getCompletionRecord(){ return record;}

    public String toString(){
        return this.getName();
    }


}//end of habit class
