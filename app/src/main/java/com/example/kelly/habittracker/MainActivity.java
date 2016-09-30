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
import java.util.Date;

public class MainActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private ArrayAdapter<Habit> array_adapter;
    private ArrayList<Habit> hList = new ArrayList<Habit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
        String displayDate = dateFormat.format(new Date());

        TextView TodaysDate = (TextView) findViewById(R.id.todayTextView);
        TodaysDate.setText("Today is " + displayDate);


//        ListView listview = (ListView) findViewById(R.id.dailyListView);
//        final ArrayList<Habit> list = new ArrayList<Student>(students);
//        final ArrayAdapter<Habit> DailyHabitListAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, ListController.getDailyHabits());
//        listview.setAdapter(DailyHabitListAdapter);
//  ArrayAdapter<Habit> dailyHabitAdapter = new ArrayAdapter<Habit>();



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

    public void addAHabitBpress(View v){

        Toast.makeText(this,"Add Habit Button Pressed!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }

}//end of MainActivity
