package com.example.kelly.habittracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class MainActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private ArrayAdapter<Habit> DailyHabitListAdapter;
    int currWeekday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1 ;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
        String displayDate = dateFormat.format(new Date());

        TextView TodaysDate = (TextView) findViewById(R.id.todayTextView);
        TodaysDate.setText("Today is " + displayDate);


        ListView listview = (ListView) findViewById(R.id.dailyListView);
        Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
        final ArrayList<Habit> list = new ArrayList<Habit>(habits);
        DailyHabitListAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(DailyHabitListAdapter);

       ListController.getDailyHabits().addListener(currWeekday,new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
                list.addAll(habits);
                DailyHabitListAdapter.notifyDataSetChanged();
            }
        });




//        Button addButton = (Button) findViewById(R.id.AddHabitButton);
//        ListView dailyListView = (ListView) findViewById(R.id.dailyListView);
//
//        addButton.setOnClickListener(new View.OnClickListener() { //anon class
//            public void onClick(View v){
//
//
//
//            }
//       }); //anon class end
    }//end of onCreate

//    public void onResume(){
//        super.onResume();
//
//            ListView listview = (ListView) findViewById(R.id.dailyListView);
//            Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
//            final ArrayList<Habit> list = new ArrayList<Habit>(habits);
//            DailyHabitListAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1,list);
//            listview.setAdapter(DailyHabitListAdapter);
//
//            ListController.getDailyHabits().addListener(currWeekday,new Listener() {
//                @Override
//                public void update() {
//                    list.clear();
//                    Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
//                    list.addAll(habits);
//                    DailyHabitListAdapter.notifyDataSetChanged();
//                }
//            });
//
//    }

    public void addAHabitBpress(View v){

        Toast.makeText(this,"Add Habit Button Pressed!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }

}//end of MainActivity
