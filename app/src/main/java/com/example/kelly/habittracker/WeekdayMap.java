package com.example.kelly.habittracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kelly on 2016-09-29.
 */
public class WeekdayMap //extends HashMap<Integer,HabitList>
{
    ArrayList<HabitList> map ;
    ArrayList<ArrayList<Listener>> listeners;
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

        listeners = new ArrayList<ArrayList<Listener>>(7);
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());
        listeners.add(new ArrayList<Listener>());

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
        for(int i=0;i<7;i++){
            for(Listener l:listeners.get(i)){
                l.update();
            }
        }
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

    public void addListener(Listener l,int[] occurance) {
        for (int i = 0; i < 7; i++) {
            if (occurance[i] == 1) {
                listeners.get(i).add(l);
            }
        }
    }

    public void removeListener(Listener l,int[] o){
        for (int i = 0; i < 7; i++) {
            if (o[i] == 1) {
                listeners.get(i).remove(l);
            }
        }
    }
}//end of class
