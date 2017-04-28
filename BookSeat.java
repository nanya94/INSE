package org.example.aprilversion;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
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
 *
 */

/**
 * This class is for booking a seat, the user will pick a time and a day
 * and this class will test the database for availability
 */
public class BookSeat extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Spinner days = null;
    public Spinner times = null;
    public String daySelection = "";
    public String timeSelection = "";
    public DatabaseCreater data;
    public final static String EXTRA_USER = "com.example.AprilVersion.USER";
    public String user = "";
    private AlertDialog mDialog;


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

    /**
     * handles the event when the book button is clicked
     * @param view the current view
     */
    public void bookButtonClicked(View view){
        daySelection = days.getSelectedItem().toString();
        timeSelection = times.getSelectedItem().toString();
        Cursor cursor = checkAvailability(daySelection, timeSelection);
        if (cursor.moveToFirst()){
            int time_slot = cursor.getInt(0);
            makeBooking(user, time_slot);

        }
        else{
            /**
             * no availabe seat at that time
             */
        }


        /*        DialogFragment popUp = new DialogFragment();
        popUp.show(getSupportFragmentManager(), "Confirm");*/




    }

    /**
     * Takes the user back to the main menu page
     * @param view
     */
    public void backButton(View view){
        Intent back = new Intent(this, Menu.class);
        back.putExtra(EXTRA_USER, user);
        startActivity(back);

    }



    /**
     * query to search for available seats
     * @return  return all seats that match search criteria
     */
    public Cursor checkAvailability(String dayPicked, String timePicked){
        SQLiteDatabase db = data.getReadableDatabase();

        String[] FROM = {TIME_SLOT_ID, SEAT_ID, TIME, DAY};
        String WHERE = AVAILABLE + " = ?" + " AND " + DAY + " = ?" + " AND " + TIME + " = ?";
        String WHEREARGS[] = {"1", dayPicked, timePicked };

        Cursor cursor = db.query(TIME_SLOT, FROM, WHERE, WHEREARGS, null, null, null);
        startManagingCursor(cursor);
        return cursor;
    }


    /**
     * for a given user and time adds the booking to the database
     * @param user  the current user
     * @param time_slot the available time slot
     */
    public void makeBooking(String user, int time_slot){
        SQLiteDatabase db = data.getWritableDatabase();
        db.execSQL("INSERT INTO " + BOOKING + "(" + STUDENT_NUMBER + "," + TIME_SLOT_ID + ")" +
                " VALUES ( '" + user + "', " + time_slot + " )");


    }



    public void showAvailable(Cursor cursor){
        StringBuilder builder = new StringBuilder(
                "Available seats:\n");
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String time = cursor.getString(1);
            /*String isC = cursor.getString(2);*/
            builder.append("Seat id = ").append(id).append("  ");
            builder.append("time = ").append(time).append(" ");
          /*  builder.append("day= ").append(isC).append("\n");*/

        }
        TextView text2 = (TextView) findViewById(R.id.timeOutput);
        text2.setText(builder);

    }


    /**
     * sets up a drop down list to select days from
     * @return  returns a spinner of days
     */
    public Spinner setDaySpinner(){
        Spinner daySpinner = (Spinner) findViewById(R.id.daysSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Days,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(adapter);
        daySpinner.setOnItemSelectedListener(this);
        return daySpinner;


    }

    /**
     * sets up a drop down list to select times from
     * @return returns a spinner for times
     */
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




