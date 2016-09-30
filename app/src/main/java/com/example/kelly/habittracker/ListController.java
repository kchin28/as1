package com.example.kelly.habittracker;

/**
 * Created by Kelly on 2016-09-30.
 */
public class ListController {
    //static instance is restricted to the class level so that
    //there is only one instance of it. This instance can get passed around
    //btwn objects so the data that the objects access from this instance
    //will be the same throughout all these interactions.
    private static WeekdayMap map = null;

    public static WeekdayMap getDailyHabits() {//this static instance can work on the class itself ( no obj necessary)
        if (map==null){
            map = new WeekdayMap();
        }
        return map;
    }

    public void addHabit(Habit h){
        map.addHabit(h);
    }

    public void deleteHabit(Habit h){
        map.deleteHabit(h);
    }



}//end
