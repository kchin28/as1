package com.example.kelly.habittracker;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kelly on 2016-09-25.
 */
public class HabitListTest extends TestCase {

    public void testAddHabit(){
        HabitList testList = new HabitList(1);
        int[] o = {0,1,0,0,0,0,0};
        Habit habit1 = new Habit(new Date(1), "habit1", o);
        testList.add(habit1);

        assertTrue("habit not added properly to list.",testList.contains(habit1));
    }

    public void testDeleteHabit(){
        HabitList testList = new HabitList(0);
        int[] o = {0,1,0,0,0,0,0};
        Habit habit1 = new Habit(new Date(),"habit1",o);
        testList.add(habit1);
        testList.remove(habit1);

        assertTrue("habit not deleted.",!testList.contains(habit1));
    }



}//end
