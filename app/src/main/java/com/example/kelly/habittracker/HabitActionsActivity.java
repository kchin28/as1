package com.example.kelly.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class HabitActionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_actions_activity);

        TextView TodaysDate = (TextView) findViewById(R.id.HabitNameText);
        TodaysDate.setText("test");
    }

}//end
