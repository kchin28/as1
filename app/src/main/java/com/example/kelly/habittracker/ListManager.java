package com.example.kelly.habittracker;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Kelly on 2016-10-02.
 */
public class ListManager {
    private static final String FILENAME= "file.sav";
    WeekdayMap hList;
    Context context;
    static private ListManager listManager = null;

    public ListManager(Context context){
        this.context = context;
    }

    public static void initManager(Context context) {
        if (listManager == null) {
            if (context==null) {
                throw new RuntimeException("missing context forListManager");
            }
            listManager = new ListManager(context);
        }
    }

    public static ListManager getManager() {
        if (listManager==null) {
            throw new RuntimeException("Did not initialize Manager");
        }
        return listManager;
    }

    public WeekdayMap loadFromFile() {

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<WeekdayMap>() {}.getType();
            try {
                hList = ListController.getDailyHabits();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            hList = gson.fromJson(in, listType);


        } catch (FileNotFoundException e) {
             hList = new WeekdayMap();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return hList;
    }

    public void saveInFile(WeekdayMap map) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(map, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}//end
