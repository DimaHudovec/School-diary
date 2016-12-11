package com.example.hudov.diary;

import android.content.ContentValues;
import android.database.Cursor;
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
import android.widget.TextView;
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
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        data.getDate();
        selectedDate = sdf.format(data);
        Log.d("mLog",selectedDate);
        Cursor cursor = database.query(DBHelper.TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            int dataIndex = cursor.getColumnIndex(DBHelper.KEY_DATA);
            int numIndex = cursor.getColumnIndex(DBHelper.KEY_NUM);
            int subIndex = cursor.getColumnIndex(DBHelper.KEY_SUBJECT);
            do{
                Log.d("mLog","Number" + cursor.getInt(numIndex) + "Subject" + cursor.getString(subIndex) + "Data" + cursor.getString(dataIndex));
                String str = new String();
                str = cursor.getString(dataIndex);
                if(selectedDate.equalsIgnoreCase(str)){
                    switch (cursor.getInt(numIndex)) {
                        case(int)1 :
                            TextView setText1 = (TextView) findViewById(R.id.textView15);
                            setText1.setText(cursor.getString(subIndex));
                            break;
                        case(int)2 :
                            TextView setText2 = (TextView) findViewById(R.id.textView17);
                            setText2.setText(cursor.getString(subIndex));
                            break;
                        case(int)3 :
                            TextView setText3 = (TextView) findViewById(R.id.textView19);
                            setText3.setText(cursor.getString(subIndex));
                            break;
                        case(int)4 :
                            TextView setText4 = (TextView) findViewById(R.id.textView21);
                            setText4.setText(cursor.getString(subIndex));
                            break;
                        case(int)5 :
                            TextView setText5 = (TextView) findViewById(R.id.textView);
                            setText5.setText(cursor.getString(subIndex));
                            break;
                        case(int)6 :
                            TextView setText6 = (TextView) findViewById(R.id.textView24);
                            setText6.setText(cursor.getString(subIndex));
                            break;
                        case(int)7 :
                            TextView setText7 = (TextView) findViewById(R.id.textView26);
                            setText7.setText(cursor.getString(subIndex));
                            break;
                        default:
                            Log.d("mLog","Error");

                    }

                }

            }while(cursor.moveToNext());
        }

        cursor.close();


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
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            int dataIndex = cursor.getColumnIndex(DBHelper.KEY_DATA);
            int numIndex = cursor.getColumnIndex(DBHelper.KEY_NUM);
            int subIndex = cursor.getColumnIndex(DBHelper.KEY_SUBJECT);
            do{
                Log.d("mLog","Number" + cursor.getInt(numIndex) + "Subject" + cursor.getString(subIndex) + "Data" + cursor.getString(dataIndex));
                String str = new String();
                str = cursor.getString(dataIndex);
                if(selectedDate.equalsIgnoreCase(str)){
                    switch (cursor.getInt(numIndex)) {
                        case(int)1 :
                            TextView setText1 = (TextView) findViewById(R.id.textView15);
                            setText1.setText(cursor.getString(subIndex));
                            break;
                        case(int)2 :
                            TextView setText2 = (TextView) findViewById(R.id.textView17);
                            setText2.setText(cursor.getString(subIndex));
                            break;
                        case(int)3 :
                            TextView setText3 = (TextView) findViewById(R.id.textView19);
                            setText3.setText(cursor.getString(subIndex));
                            break;
                        case(int)4 :
                            TextView setText4 = (TextView) findViewById(R.id.textView21);
                            setText4.setText(cursor.getString(subIndex));
                            break;
                        case(int)5 :
                            TextView setText5 = (TextView) findViewById(R.id.textView);
                            setText5.setText(cursor.getString(subIndex));
                            break;
                        case(int)6 :
                            TextView setText6 = (TextView) findViewById(R.id.textView24);
                            setText6.setText(cursor.getString(subIndex));
                            break;
                        case(int)7 :
                            TextView setText7 = (TextView) findViewById(R.id.textView26);
                            setText7.setText(cursor.getString(subIndex));
                            break;
                        default:
                            Log.d("mLog","Error");

                    }

                }

            }while(cursor.moveToNext());
        }

        cursor.close();
    }

    public void add_subj_to_db(View view)
    {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        EditText etNum = (EditText) findViewById(R.id.editText3);
        String num = etNum.getText().toString();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();


        contentValues.put(DBHelper.KEY_DATA,selectedDate);
        contentValues.put(DBHelper.KEY_NUM,num);
        contentValues.put(DBHelper.KEY_SUBJECT,selected);

        database.insert(DBHelper.TABLE_NAME,null,contentValues);
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