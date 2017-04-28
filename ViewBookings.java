package org.example.aprilversion;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import static org.example.aprilversion.Constants.*;

/**
 * @author UP785470
 */
public class ViewBookings extends ListActivity {
    public String user = "";
    public DatabaseCreater data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bookings);

        Intent intent = getIntent();
        user = intent.getStringExtra(Login.EXTRA_USER);
        data = new DatabaseCreater(this);
        try {



        }
        finally{
            data.close();
        }
    }

    private static String[] FROM = {FNAME, LNAME};
    private String WHERE = STUDENT_NUM + " = " + user;
    public Cursor getBookings(){
        SQLiteDatabase db = data.getReadableDatabase();
        Cursor cursor = db.query(STUDENT, null, null, null, null, null, null);
        startManagingCursor(cursor);
        return cursor;
    }

    private static int[] TO = {R.id.booking_ref, R.id.time_slot};
    public void displayBookings(Cursor cursor){
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor, FROM, TO);
        setListAdapter(adapter);

    }

}
