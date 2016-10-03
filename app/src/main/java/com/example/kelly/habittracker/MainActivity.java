package com.example.kelly.habittracker;
/*
* Copyright (C) 2014 Abram Hindle abram.hindle@softwareprocess.ca
* Modified by : Kelly Chin, 2016
*
* Main activity is the "home screen" of the app, it provides the user with a way to look
* at their habits for the day and select them to perform different actions on them.
*
* View all habits button is not functional/implemented.
* */
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {
    private static final String FILENAME= "file.sav";
    ArrayList<Habit> list = new ArrayList<Habit>();
    private ArrayAdapter<Habit>  DailyHabitListAdapter;
    int currWeekday;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListManager.initManager(this.getApplicationContext());

        //get current weekday to index WeekdayMap to get proper HabitList for today
        currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1 ;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM.d,yyyy");
        String displayDate = dateFormat.format(new Date());
        TextView TodaysDate = (TextView) findViewById(R.id.todayTextView);
        TodaysDate.setText("Today is " + displayDate);


        ListView listview = (ListView) findViewById(R.id.dailyListView);
        try {
            Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DailyHabitListAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(DailyHabitListAdapter);


        //fetch data from Listcontroller to display updated habitsList
        try {
            ListController.getDailyHabits().addListener(new Listener() {// observing habits add/delete
                public void update() {
                    list.clear();
                    Collection<Habit> habits = null;
                    try {
                        habits = ListController.getDailyHabits().getaList(currWeekday);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    list.addAll(habits);
                    DailyHabitListAdapter.notifyDataSetChanged();

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //allow user to select a single habit and choose an action from a dialog window
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final int currHabit_pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.habit_actions)
                        .setItems(R.array.habit_actions_array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if(which==0){ //complete habit
                                    Toast.makeText(MainActivity.this, "Good job completing " + list.get(currHabit_pos).toString() + "!", Toast.LENGTH_SHORT).show();
                                    Completion newCompletion = new Completion(); //curr completion date
                                    try {
                                        ListController.getDailyHabits().addHabitCompletion(currWeekday,currHabit_pos,newCompletion);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }

                                }
                                if(which==1){ //delete habit
                                    Toast.makeText(MainActivity.this, "Deleted " + list.get(currHabit_pos).toString(), Toast.LENGTH_SHORT).show();
                                    Habit currHabit = list.get(currHabit_pos);
                                    try {
                                        ListController.getDailyHabits().deleteHabit(currHabit);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if(which==2){ //view completions
                                    //pass position so we are able to access current habit in other activities
                                    Intent intent = new Intent(MainActivity.this,ViewHabitCompletionsActivity.class);
                                    intent.putExtra("currHabit Position",currHabit_pos);
                                    startActivity(intent);
                                }
                                if(which==3){//view fulfillment summary
                                    Intent intent = new Intent(MainActivity.this,ViewFulfillmentSummary.class);
                                    intent.putExtra("currHabit Position",currHabit_pos);
                                    startActivity(intent);
                                }
                            }
                        });
                builder.show();
                return false;
            }
        });


    }//end of onCreate



    public void addAHabitBpress(View v){
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }




}//end of MainActivity
