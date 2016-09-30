package com.example.kelly.habittracker;

import java.util.HashMap;

/**
 * Created by Kelly on 2016-09-29.
 */
public class WeekdayMap extends HashMap<Integer,HabitList> {
    public WeekdayMap(){
        super();
        this.put(0,new HabitList(0));
        this.put(1,new HabitList(1));
        this.put(2,new HabitList(2));
        this.put(3,new HabitList(3));
        this.put(4,new HabitList(4));
        this.put(5,new HabitList(5));
        this.put(6,new HabitList(6));

    }

    public void addHabit(Habit h){

        for (int i=0; i<7; i++){
            if(h.getOccurance(i)==1){
                this.get(i).add(h);
            }
        }
    }
}//end of class
