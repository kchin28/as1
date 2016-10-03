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

        assertTrue( map.getaList(1).contains(h1) );
    }

    public void testDeleteHabit(){
        WeekdayMap map = new WeekdayMap();
        int[] o1 = {0,1,0,1,0,0,0};
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);
        map.deleteHabit(h1);

        assertFalse( map.getaList(1).contains(h1) );
    }

    boolean updated  = false;
    public void testNotifyListeners(){
        WeekdayMap map = new WeekdayMap();
        Listener l = new Listener() {
            public void update(){
                WeekdayMapTest.this.updated = true;
            }
        };

        int[] o1 = {1,0,0,0,0,0,0};
        map.addListener(l);
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);
        assertTrue(this.updated);
    }

    public void testRemoveListeners(){
        WeekdayMap map = new WeekdayMap();
        this.updated=false;
        Listener l = new Listener() {
            public void update(){
                    WeekdayMapTest.this.updated = true;
            }
        };

        int[] o1 = {0,1,0,0,0,0,0};
        map.addListener(l);
        map.removeListener(l);
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);
        assertFalse(this.updated);

    }

    public void testAddCompletion(){
        WeekdayMap map = new WeekdayMap();
        int[] o1 = {1,0,0,0,0,0,0};
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);

        Completion c1 = new Completion();
        map.addHabitCompletion(0,0,c1);

        assertTrue(map.getaList(0).get(0).getCompletionRecord().contains(c1));

    }

    boolean updated2  = false;
    public void testNotifyCompletionListeners(){
        WeekdayMap map = new WeekdayMap();
        Listener l = new Listener() {
            public void update(){
                WeekdayMapTest.this.updated2 = true;
            }
        };

        map.addCompletionListener(l);
        int[] o1 = {1,0,0,0,0,0,0};
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);
        map.addHabitCompletion(0,0,new Completion(2));
        assertTrue(this.updated2);

    }

    public void testRemoveCompletionListeners(){
        WeekdayMap map = new WeekdayMap();
        updated2=false;
        Listener l = new Listener() {
            public void update(){
                WeekdayMapTest.this.updated2 = true;
            }
        };

        map.addListener(l);
        map.removeListener(l);
        int[] o1 = {1,0,0,0,0,0,0};
        Habit h1 = new Habit(new Date(1),"h1",o1);
        map.addHabit(h1);
        Completion c=new Completion(2);
        map.addHabitCompletion(0,0,c);
        assertFalse(this.updated);

    }

}// end of class
