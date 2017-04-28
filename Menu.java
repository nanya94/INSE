package org.example.aprilversion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static org.example.aprilversion.Constants.FNAME;
import static org.example.aprilversion.Constants.LNAME;
import static org.example.aprilversion.Constants.STUDENT_NUM;

/**
 * @author UP785470
 *
 * This activity will be the menu from which other activities can be selected
 * each option will be represented with a button and will open that activity onClick()
 */
public class Menu extends AppCompatActivity {
    public String user = " ";
    public final static String EXTRA_USER = "com.example.AprilVersion.USER";
    public String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent intent = getIntent();
        user = intent.getStringExtra(Login.EXTRA_USER);
        TextView userInfo = (TextView) findViewById(R.id.UserInfoOut);

        if(user == null){
            username = "Welcome!";
        }else {
            username = "Welcome " + user;
        }
        userInfo.setText(username);
    }

    /**
     *
     * @param view - the current page
     * returns the user to the homepage
     */
    public void logout(View view){
        Intent logout = new Intent(this, Login.class);
        startActivity(logout);
    }

    /**
     *
     * @param view
     * starts the bookSeat activity also passes the current user name
     */
    public void bookSeat(View view){
        Intent bookSeat = new Intent(this, BookSeat.class);
        bookSeat.putExtra(EXTRA_USER, user);
        startActivity(bookSeat);
    }

    /**
     *
     * @param view
     * starts the viewBookings activity also passes the current user name
     */
    public void viewBookings(View view){
        Intent viewBookings = new Intent(this, ViewBookings.class);
        viewBookings.putExtra(EXTRA_USER, user);
        startActivity(viewBookings);
    }






}
