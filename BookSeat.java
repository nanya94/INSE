package org.example.aprilversion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import static org.example.aprilversion.Constants.*;
import static org.example.aprilversion.R.id.time;

/**
 * @author UP785470
 */
public class BookSeat extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner days = null;
    public Spinner times = null;
    public String daySelection = "";
    public String timeSelection = "";
    public DatabaseCreater data = null;
    public final static String EXTRA_USER = "com.example.AprilVersion.USER";
    public String user = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_seat);

        Intent intent = getIntent();
        user = intent.getStringExtra(Login.EXTRA_USER);
        data = new DatabaseCreater(this);
        days = setDaySpinner();
        times = setTimeSpinner();


    }

    public void bookButtonClicked(View view){
        daySelection = days.getSelectedItem().toString();
        timeSelection = times.getSelectedItem().toString();
/*
        showAvaliable(checkAvailability());
*/
    }

    public void backButton(View view){
        Intent back = new Intent(this, Menu.class);
        back.putExtra(EXTRA_USER, user);
        startActivity(back);

    }

    private static String[] FROM = {SEAT_ID, TIME};
    private String WHERECLAUSE = "AVAILABLE = 1  AND " + TIME + " = " + timeSelection + " AND DAY = " + daySelection;
    private  String[] WHEREARGS = {"1", /** timeSelection  ,  daySelection*/};

    public Cursor checkAvailability(){
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cursor = db.query(TIME_SLOT, FROM, WHERECLAUSE, null, null, null, null );
        startManagingCursor(cursor);
        return cursor;
    }

    public void showAvaliable(Cursor cursor){
        StringBuilder builder = new StringBuilder(
                "Available seats:\n");
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String floor = cursor.getString(1);
            /*String isC = cursor.getString(2);*/
            builder.append("Seat id = ").append(id).append("  ");
            builder.append("time = ").append(floor).append(" ");
          /*  builder.append("day= ").append(isC).append("\n");*/

        }
        TextView text2 = (TextView) findViewById(R.id.timeOutput);
        text2.setText(builder);

    }





    public Spinner setDaySpinner(){
        Spinner daySpinner = (Spinner) findViewById(R.id.daysSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Days,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(adapter);
        daySpinner.setOnItemSelectedListener(this);
        return daySpinner;


    }


    public Spinner setTimeSpinner(){
        Spinner timeSpinner = (Spinner) findViewById(R.id.timesSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Times,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(adapter);
        timeSpinner.setOnItemSelectedListener(this);
        return timeSpinner;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        }
    }


