package org.example.aprilversion;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.sql.Time;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.example.aprilversion.Constants.*;

/**
 * @author UP785470
 *
 * The first Screen for the app, this is where the user will enter their login information
 */
public class Login extends AppCompatActivity {
    private DatabaseCreater data;
    public String user = "";
    public String pass = "";
    public Boolean authorisation = FALSE;
    public final static String EXTRA_USER = "com.example.AprilVersion.USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        data = new DatabaseCreater(this);
        try{

        }
        finally{
            data.close();
        }

    }

    /**
     *
     * @param view - the current Activity
     * this method takes the user input from the username and password TextViews
     * it then passes those values to checkLoginDatabase()
     * if it returns true the user is returned to the next page
     * and the user is pushed through with putExtra
     */
    public void login(View view){
        Intent success = new Intent(this, Menu.class);
        EditText username = (EditText) findViewById(R.id.Username);
        EditText password = (EditText) findViewById(R.id.Password);
        user = username.getText().toString();
        pass = password.getText().toString();
        Cursor cursor = getStudents();
        checkLoginDatabase(cursor, user, pass);
        if (authorisation == TRUE)
            success.putExtra(EXTRA_USER, user);
            startActivity(success);
        } /**
            else {
             Add fragment or text that says incorrect details
            */


    /**
     *
     * @param cursor
     * @param username - username to be tested against the database
     * @param password - password to be tested againast the database
     *
     * if a match for both the username and password is found, makes authorisation equal true.
     * authorisation is set to false by default
     */
    public void checkLoginDatabase(Cursor cursor, String username, String password){
        while (cursor.moveToNext()) {
            String user = cursor.getString(1);
            String Pass = cursor.getString(4);
            if ((username.toUpperCase().equals(user)) && (password.equals(pass))) {
                authorisation = TRUE;
            }
        }
    }


    /**
     *
     * @param studentNum
     * @param firstName
     * @param lastName
     * @param password
     *
     * given the parameters adds a student to the database
     */
    private void addStudent(String studentNum, String firstName, String lastName, String password) {
        SQLiteDatabase db = data.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_NUM, studentNum);
        values.put(FNAME, firstName);
        values.put(LNAME, lastName);
        values.put(PASSWORD, password);
        db.insertOrThrow(STUDENT, null, values);
    }




    private static String[] FROM = {STD_ID, STUDENT_NUM, FNAME, LNAME, PASSWORD};
    private static String ORDER_BY = STUDENT_NUM + " DESC";

    /**
     *
     * @return returns a cursor for a search query for every student in the table STUDENT
     */
    private Cursor getStudents() {
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cursor = db.query(STUDENT, FROM, null, null, null, null, ORDER_BY);
        startManagingCursor(cursor);
        return cursor;
    }

    /**
     *
     * @param cursor for the cursor supplied from getStudents() builds a string with all the results
     */
    public void showStudents(Cursor cursor){
        StringBuilder builder = new StringBuilder(
                "All Students:\n");
        while (cursor.moveToNext()){
            String id = cursor.getString(1);
            String f = cursor.getString(2);
            String l = cursor.getString(3);
            String p = cursor.getString(4);
            builder.append(id).append(" - ");
            builder.append(f).append(" ");
            builder.append(l).append(" - ");
            builder.append(p).append("\n");
        }

    }

    /**
     *
     * @param floor - the floor the seat is on
     * @param isComp - represents a boolean, 1 for true 0 for false
     *
     * given the parameters adds a seat to the database
     */
    private void addSeat(int floor, int isComp){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(FLOOR, floor);
        values.put(ISCOMP, isComp);
        db.insertOrThrow(SEAT, null, values);
    }

    private static String[] FROM2 = {SEAT_ID, FLOOR, ISCOMP};
    private static String ORDER_BY2 = FLOOR + " DESC";

    /**
     *
     * @return a cursor for a search query on the SEAT table
     */
    private Cursor getSeats() {
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cursor = db.query(SEAT, FROM2, null, null, null, null, ORDER_BY2);
        startManagingCursor(cursor);
        return cursor;
    }

    /**
     *
     * @param cursor displays the results of getSeats()
     */
    public void showSeats(Cursor cursor){
            StringBuilder builder = new StringBuilder(
                    "Seats:\n");
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                String floor = cursor.getString(1);
                String isC = cursor.getString(2);
                builder.append("Seat id - ").append(id).append("  ");
                builder.append("floor num - ").append(floor).append(" ");
                builder.append("Computer? ").append(isC).append("\n");

            }

        }


    /**
     *
     * @param time
     * @param day
     * @param available
     * @param seat_ID
     *
     * given the parameters adds a Time_slot to the database
     */
    private void addTime(String time, String day, boolean available, int seat_ID){
        SQLiteDatabase db = data.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, time);
        values.put(DAY, day);
        values.put(AVAILABLE, available);
        values.put(SEAT_NUM, seat_ID);
        db.insertOrThrow(TIME_SLOT, null, values);
    }





}
