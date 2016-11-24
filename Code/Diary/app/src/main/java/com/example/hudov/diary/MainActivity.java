package com.example.hudov.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tab");
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Window1");
        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("Shedule");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Window2");
        tabSpec.setContent(R.id.linearLayout2);
        tabSpec.setIndicator("Bells");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Window3");
        tabSpec.setContent(R.id.linearLayout3);
        tabSpec.setIndicator("Rating");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

    }
    public void calendar(View view)
    {
        setContentView(R.layout.calendar);
    }

    public void to_main(View view)
    {
        setContentView(R.layout.activity_main);
    }
}