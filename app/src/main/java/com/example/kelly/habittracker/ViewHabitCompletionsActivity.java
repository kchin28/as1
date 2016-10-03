package com.example.kelly.habittracker;

/*
* Copyright (C) 2016, Kelly Chin
* Android UI to view completions for each habit.
* Completion List does not update immediately, faulty listener.
* */

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class ViewHabitCompletionsActivity extends AppCompatActivity {

    int currWeekday;
    private ArrayAdapter<Completion> PastCompletionsListAdapter;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_completions_activity);
       // ListManager.initManager(this.getApplicationContext());

        currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1 ;

        Bundle extras = getIntent().getExtras();
        final int currHabitpos = extras.getInt("currHabit Position");

        TextView HabitCompletionInfo = (TextView) findViewById(R.id.HabitCompletionsTextView);
        try {
            HabitCompletionInfo.setText(" Viewing Completions for " + ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ListView listview = (ListView) findViewById(R.id.PastCompletionsListView);
        Collection<Completion> pastCompletions = null;
        try {
            pastCompletions = ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getCompletionRecord();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        final ArrayList<Completion> list = new ArrayList<Completion>(pastCompletions);
        PastCompletionsListAdapter = new ArrayAdapter<Completion>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(PastCompletionsListAdapter);

        try {
            ListController.getDailyHabits().addCompletionListener(new Listener() {
                @Override
                public void update() {
                    list.clear();
                    Collection<Completion> pastCompletions = null;
                    try {
                        pastCompletions = ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getCompletionRecord();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    list.addAll(pastCompletions);
                    PastCompletionsListAdapter.notifyDataSetChanged();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id){
                AlertDialog.Builder adb = new AlertDialog.Builder(ViewHabitCompletionsActivity.this);
                final int finalpos = position;
                adb.setMessage("Delete "+list.get(finalpos).toString()+"?")
                        .setPositiveButton(R.string.del, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Completion currCompletion = list.get(finalpos);
                                //ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getCompletionRecord().remove(currCompletion);
                                try {
                                    ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).deleteCompletion(currCompletion);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                adb.show();
                return false;
            }



        });
    }//end of onCreate
}//end of activity
