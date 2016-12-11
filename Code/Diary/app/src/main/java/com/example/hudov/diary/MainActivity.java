package com.example.hudov.diary;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    String selectedDate;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_tab();
        dbHelper = new DBHelper(this);
    }
    public void calendar(View view)
    {
        setContentView(R.layout.calendar);
    }


    public void to_main(View view)
    {
        CalendarView calen = (CalendarView) findViewById(R.id.calendarView);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        selectedDate = sdf.format(new Date(calen.getDate()));
        Log.d("mLog","Data" + selectedDate);
        setContentView(R.layout.activity_main);
        set_tab();
    }

    public void add_subj_to_db(View view)
    {
        Log.d("mLog","Error");
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        Log.d("mLog","Error");
        EditText etNum = (EditText) findViewById(R.id.editText3);
        String num = etNum.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
        Log.d("mLog","Error");


        contentValues.put(DBHelper.KEY_DATA,selectedDate);
        contentValues.put(DBHelper.KEY_NUM,num);
        contentValues.put(DBHelper.KEY_SUBJECT,selected);

        database.insert(DBHelper.TABLE_NAME,null,contentValues);
        Log.d("mLog","Error");
        setContentView(R.layout.activity_main);
        set_tab();
    }


    public void add_sub(View view)
    {
        setContentView(R.layout.add_subject);
    }

    public void get_data()
    {
        CalendarView calen = (CalendarView) findViewById(R.id.calendarView);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        selectedDate = sdf.format(new Date(calen.getDate()));
        Log.d("mLog","Data" + selectedDate);

    }
    public void exit(View view)
    {
        this.finish();
    }



    public void set_tab(){
        setTitle("Tab");
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Window1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Shedule");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Window2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Bells");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Window3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Rating");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }

}