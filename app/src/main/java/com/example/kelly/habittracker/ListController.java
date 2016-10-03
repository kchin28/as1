package com.example.kelly.habittracker;

import java.io.IOException;

/**Copyright (C) 2014, Abram Hindle abram.hindle@softwareprocess.ca
 * Modified by Kelly Chin, 2016
 *
 * Listcontroller acts as an in between from the Android UI and the java backend.
 * Static instances of this class include the Weekday Map class and the all the methods
 * are to access the values from this class.
 *
 * Persistant data through the ListManager is not implemented and has been commented out.
 * Was supposed to communicate with ListManager here.
 */
public class ListController {
    //static instance is restricted to the class level so that
    //there is only one instance of it. This instance can get passed around
    //btwn objects so the data that the objects access from this instance
    //will be the same throughout all these interactions.
    private static WeekdayMap map = null;

    public static WeekdayMap getDailyHabits() throws IOException, ClassNotFoundException {//this static instance can work on the class itself ( no obj necessary)
        if (map==null){
//            map = ListManager.getManager().loadFromFile();
//            map.addListener(new Listener() {
//                @Override
//                public void update() {
//                    try {
//                        saveMap();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            map = new WeekdayMap();
        }
        return map;
    }

    public void addHabit(Habit h) throws IOException, ClassNotFoundException {
        getDailyHabits().addHabit(h);
    }

    public void deleteHabit(Habit h) throws IOException, ClassNotFoundException {
        getDailyHabits().deleteHabit(h);
    }

    public void completeHabit(int currWeekday,int currHabit, Completion c) throws IOException, ClassNotFoundException {
        getDailyHabits().addHabitCompletion(currWeekday,currHabit,c);
    }

    public void deleteCompletion(int currWeekday,int currHabit,Completion c) throws IOException, ClassNotFoundException {
        getDailyHabits().deleteHabitCompletion(currWeekday,currHabit,c);
    }

    static void saveMap() throws IOException, ClassNotFoundException {
        ListManager.getManager().saveInFile(getDailyHabits());
    }


}//end
