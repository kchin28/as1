package com.example.kelly.habittracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**Copyright (C) 2016, Kelly Chin
 * Sorts HabitLists by weekday to provide a way for habits to be organised.
 */
public class WeekdayMap
{
    //functionality of ArrayList is used to implement these three attributes
    ArrayList<HabitList> map ;
    ArrayList<Listener> listeners;
    ArrayList<Listener> completionListeners;

    public WeekdayMap(){
        map = new ArrayList<HabitList>(7);
        map.add( new HabitList(0));
        map.add( new HabitList(1));
        map.add( new HabitList(2));
        map.add( new HabitList(3));
        map.add( new HabitList(4));
        map.add( new HabitList(5));
        map.add( new HabitList(6));

        listeners = new ArrayList<Listener>();
        completionListeners = new ArrayList<Listener>();
    }

    public void addHabit(Habit h){
        //occurance of habit must be cycled through because a date needs to show up on multiple days if it
        //needs to occur on different weekdays
        for (int i=0; i<7; i++){
            if(h.getOccurance(i)==1){
                map.get(i).add(h);
                notifyListeners();
            }
        }
    }

    public void deleteHabit(Habit h){
        for (int i=0; i<7; i++){
            if(h.getOccurance(i)==1){
                map.get(i).remove(h);
                notifyListeners();
            }
        }
    }

    public HabitList getaList(int i){
        return map.get(i);
    }

    private void notifyListeners() {
        for(Listener l:listeners){
            l.update();
        }
    }
    public void addListener( Listener l) {   listeners.add(l);}

    public void removeListener(Listener l){  listeners.remove(l);}

    private void notifyCompletionListeners() {
        for(Listener cl:completionListeners){
            cl.update();
        }
    }

    public void addHabitCompletion(int currWeekday,int currHabit, Completion c){
        map.get(currWeekday).get(currHabit).addCompletion(c);
        notifyCompletionListeners();
    }

    public void deleteHabitCompletion(int currWeekday,int currHabit, Completion c){
        map.get(currWeekday).get(currHabit).deleteCompletion(c);
        notifyCompletionListeners();
    }

    public void addCompletionListener( Listener l) {    completionListeners.add(l);}

    public void removeCompletionListener(Listener l){   completionListeners.remove(l);}

}//end of class
