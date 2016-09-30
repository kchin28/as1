package com.example.kelly.habittracker;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by Kelly on 2016-09-29.
 */
public class WeekdayMapTest extends TestCase {

    public void testAddHabit(){
        WeekdayMap map = new WeekdayMap();


        int[] o1 = {0,1,0,1,0,0,0};
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);

        assertTrue( map.get(1).contains(h1) );
    }

//    public testDeleteHabit(){
//
//    }




}// end of class
