package com.example.kelly.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class ViewFulfillmentSummary extends AppCompatActivity {

    int currWeekday;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fulfillment_summary_activity);

        currWeekday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1 ;

        Bundle extras = getIntent().getExtras();
        final int currHabitpos = extras.getInt("currHabit Position");

        TextView FulfillmentInfo = (TextView) findViewById(R.id.FulfillmentDisplaytextView);
        FulfillmentInfo.setText(" Fulfillment Summary of " + ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getName());

        ListView listview = (ListView) findViewById(R.id.PastCompletionsListView);
        Collection<Completion> pastCompletions = ListController.getDailyHabits().getaList(currWeekday).get(currHabitpos).getCompletionRecord();
        final ArrayList<Completion> list = new ArrayList<Completion>(pastCompletions);
        Integer count = list.size();
        TextView CompletionCount = (TextView) findViewById(R.id.fulfillmentCountTextView);
        CompletionCount.setText(count.toString());


    }//end onCreate
}//end
