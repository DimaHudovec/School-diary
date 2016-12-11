package com.example.hudov.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TabHost;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_tab();
    }
    public void calendar(View view)
    {
        setContentView(R.layout.calendar);
    }


    public void to_main(View view)
    {

        CalendarView calen = (CalendarView) findViewById(R.id.calendarView);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calen.getDate()));
        Log.d("mLog","Data" + selectedDate);
        setContentView(R.layout.activity_main);
        set_tab();


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