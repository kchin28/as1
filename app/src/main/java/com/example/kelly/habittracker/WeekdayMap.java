package com.example.kelly.habittracker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kelly on 2016-09-29.
 */
public class WeekdayMap //extends HashMap<Integer,HabitList>
{
    ArrayList<HabitList> map ;
    public WeekdayMap(){
//        super();
//        this.put(0,new HabitList(0));
//        this.put(1,new HabitList(1));
//        this.put(2,new HabitList(2));
//        this.put(3,new HabitList(3));
//        this.put(4,new HabitList(4));
//        this.put(5,new HabitList(5));
//        this.put(6,new HabitList(6));
        map = new ArrayList<HabitList>(7);
        map.add( new HabitList(0));
        map.add( new HabitList(1));
        map.add( new HabitList(2));
        map.add( new HabitList(3));
        map.add( new HabitList(4));
        map.add( new HabitList(5));
        map.add( new HabitList(6));

    }

    public void addHabit(Habit h){

        for (int i=0; i<7; i++){
            if(h.getOccurance(i)==1){
                map.get(i).add(h);
                notifyListeners();
 //               this.get(i).add(h);
            }
        }
    }

    private void notifyListeners() {

    }

    public void deleteHabit(Habit h){
        for (int i=0; i<7; i++){
            if(h.getOccurance(i)==1){
                map.get(i).remove(h);
 //               this.get(i).remove(h);
            }
        }


    }

    public HabitList getaList(int i){
        return map.get(i);
    }
}//end of class
