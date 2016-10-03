package com.example.kelly.habittracker;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    private static final String FILENAME = "file.sav";
    private ArrayAdapter<Habit> DailyHabitListAdapter;
    int currWeekday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1 ;

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM.d,yyyy");
        String displayDate = dateFormat.format(new Date());
        TextView TodaysDate = (TextView) findViewById(R.id.todayTextView);
        TodaysDate.setText("Today is " + displayDate);


        ListView listview = (ListView) findViewById(R.id.dailyListView);
        Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
        final ArrayList<Habit> list = new ArrayList<Habit>(habits);
        DailyHabitListAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(DailyHabitListAdapter);

        ListController.getDailyHabits().addListener(new Listener() {// observing habits add/delete
            public void update() {
                list.clear();
                Collection<Habit> habits = ListController.getDailyHabits().getaList(currWeekday);
                list.addAll(habits);
                DailyHabitListAdapter.notifyDataSetChanged();
            }
        });

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
                                    ListController.getDailyHabits().addHabitCompletion(currWeekday,currHabit_pos,newCompletion);

                                }
                                if(which==1){ //delete habit
                                    Toast.makeText(MainActivity.this, "Deleted " + list.get(currHabit_pos).toString(), Toast.LENGTH_SHORT).show();
                                    Habit currHabit = list.get(currHabit_pos);
                                    ListController.getDailyHabits().deleteHabit(currHabit);
                                }
                                if(which==2){ //view completions
                                  //  Toast.makeText(MainActivity.this, "I want to view completions for " + list.get(currHabit_pos).toString(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,ViewHabitCompletionsActivity.class);
                                    intent.putExtra("currHabit Position",currHabit_pos);
                                    startActivity(intent);
                                }
                                if(which==3){//view fulfillment summary
                                    Toast.makeText(MainActivity.this, "I want to view fulfillments for " + list.get(currHabit_pos).toString(), Toast.LENGTH_SHORT).show();
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
       // Toast.makeText(this,"Add Habit Button Pressed!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,AddHabitActivity.class);
        startActivity(intent);
    }

}//end of MainActivity
