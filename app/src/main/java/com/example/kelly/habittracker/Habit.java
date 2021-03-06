package com.example.kelly.habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*Copyright (C) 2016, Kelly Chin
 *
 * Defines Habit and its behavior. Provides access methods to private variables
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

    public Date getDate(){ return CreationDate; }

    public int getOccurance(int i){ return occurance[i];}

    public void addCompletion(Completion c){record.add(c);}

    public void deleteCompletion(Completion c){ record.remove(c);}

    public CompletionRecord getCompletionRecord(){ return record;}

    public String toString(){
        return this.getName();
    }


}//end of habit class
