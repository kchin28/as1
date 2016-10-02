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
            }
        }


    }

    public HabitList getaList(int i){
        return map.get(i);
    }

    public void addListener(int o, Listener l) {
//        for (int i = 0; i < 7; i++) {
//            if (o[i] == 1) {
//                listeners.get(i).add(l);
//            }
//        }
            listeners.get(o).add(l);

    }

    public void removeListener(int o,Listener l){
//        for (int i = 0; i < 7; i++) {
//            if (o[i] == 1) {
//                listeners.get(i).remove(l);
//            }
//        }
                listeners.get(o).remove(l);

    }
}//end of class
