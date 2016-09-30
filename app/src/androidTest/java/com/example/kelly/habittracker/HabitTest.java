package com.example.kelly.habittracker;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by Kelly on 2016-09-29.
 */
public class HabitTest extends TestCase {

    public void testOccurance(){
        int[] o = {1,0,0,0,0,0,0};

        String name = "h1";

        Habit h1 = new Habit(new Date(),name, o);

        assertTrue(h1.getOccurance(0)==1);
    }

//    public void testAddCompletion(){
//        int[] o = {1,0,0,0,0,0,0};
//        Habit h = new Habit(new Date(1), "h1",o);
//        Completion c = new Completion();
//
//        h.addCompletion(c);
//
//        assertTrue(h.getCompletionRecord().get(0) == ) );
//}

}
