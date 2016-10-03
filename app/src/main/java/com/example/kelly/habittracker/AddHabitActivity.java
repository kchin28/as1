package com.example.kelly.habittracker;
/*
* Copyright (C) 2016, Kelly Chin
* Android UI to Add Habits
* */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;

public class AddHabitActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_habit_activity);
        //ListManager.initManager(this.getApplicationContext());
    }

    public void saveHabitBpress(View v){
        Toast.makeText(this,"Saving Habit!",Toast.LENGTH_SHORT).show();
        EditText HabitNameTextView = (EditText) findViewById(R.id.newHabitName);
        //checkboxes for occurance
        int[] OccuranceNewHabit = {0,0,0,0,0,0,0};

        CheckBox sun = (CheckBox) findViewById(R.id.sun_checkBox);
        if (sun.isChecked()){OccuranceNewHabit[0]=1;}

        CheckBox mon = (CheckBox) findViewById(R.id.mon_checkBox);
        if (mon.isChecked()){OccuranceNewHabit[1]=1;}

        CheckBox tue = (CheckBox) findViewById(R.id.tue_checkBox);
        if (tue.isChecked()){OccuranceNewHabit[2]=1;}

        CheckBox wed = (CheckBox) findViewById(R.id.wed_checkBox);
        if (wed.isChecked()){OccuranceNewHabit[3]=1;}

        CheckBox thu = (CheckBox) findViewById(R.id.thu_checkBox);
        if (thu.isChecked()){OccuranceNewHabit[4]=1;}

        CheckBox fri = (CheckBox) findViewById(R.id.fri_checkBox);
        if (fri.isChecked()){OccuranceNewHabit[5]=1;}

        CheckBox sat = (CheckBox) findViewById(R.id.sat_checkBox);
        if (sat.isChecked()){OccuranceNewHabit[6]=1;}

        Habit newHabit = new Habit(new Date(),HabitNameTextView.getText().toString(),OccuranceNewHabit);
        ListController lc = new ListController();
        try {
            lc.addHabit(newHabit);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//       // Log.d("hi",lc.getDailyHabits().get(0).get(0).toString());
    }
}//end

