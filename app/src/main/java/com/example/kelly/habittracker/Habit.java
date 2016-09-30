package com.example.kelly.habittracker;

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
        this.occurance = howOften;
        this.record = new CompletionRecord();
    }

    //methods
    public String getName(){
        return Name;
    }

    public Date getDate(){ return CreationDate; }

    public int getOccurance(int i){ return occurance[i];}

    public CompletionRecord getCompletionRecord(){ return record;}


}//end of habit class
