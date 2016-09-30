package com.example.kelly.habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ArrayAdapter<Habit> array_adapter;
    private ArrayList<Habit> hList = new ArrayList<Habit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button) findViewById(R.id.AddHabitButton);
        ListView dailyListView = (ListView) findViewById(R.id.dailyListView);

        addButton.setOnClickListener(new View.OnClickListener() { //anon class
            public void onClick(View v){



            }
        }); //anon class end
    }//end of onCreate
}//end of MainActivity
