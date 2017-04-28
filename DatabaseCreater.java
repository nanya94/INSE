package org.example.aprilversion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static org.example.aprilversion.Constants.*;
import static android.provider.BaseColumns._ID;

/**
 * @author UP785470
 *
 * This class creates the database when it is created.
 */
public class DatabaseCreater extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "library.db";
    private static final int DATABASE_VERSION = 5;

    public DatabaseCreater(Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(createStudentTable());
        db.execSQL(createSeatTable());
        db.execSQL(createTimeSlotTable());
        db.execSQL(createBookingTable());
        insertStudents(db);
        insertSeats(db);
        insertTimes(db);
        insertBookings(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT);
        db.execSQL("DROP TABLE IF EXISTS " + SEAT);
        db.execSQL("DROP TABLE IF EXISTS " + TIME_SLOT);
        db.execSQL("DROP TABLE IF EXISTS " + BOOKING);
        onCreate(db);
    }

    /**
     * the string required to create the Student table
     * @return
     */
    public String createStudentTable(){
        return ("CREATE TABLE IF NOT EXISTS " + STUDENT + " ("
                + STD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STUDENT_NUM + " TEXT NOT NULL, "
                + FNAME + " TEXT NOT NULL, "
                + LNAME + " TEXT NOT NULL, "
                + PASSWORD + " TEXT NOT NULL);");
    }

    /**
     * the string required to create the Seat table
     * @return
     */
    public String createSeatTable(){
        return ("CREATE TABLE IF NOT EXISTS " + SEAT + " ("
                + SEAT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + FLOOR + " INTEGER, "
                + ISCOMP + " BOOLEAN NOT NULL);");
    }

    /**
     * the string required to create the Time_Slot table
     * @return
     */
    public String createTimeSlotTable(){
        return ("CREATE TABLE IF NOT EXISTS " + TIME_SLOT + " ("
                + TIME_SLOT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TIME + " TEXT NOT NULL, "
                + DAY + " TEXT NOT NULL, "
                + AVAILABLE + " INTEGER NOT NULL, "
                + SEAT_NUM + " INTEGER," +
                " FOREIGN KEY (" + SEAT_NUM + ") REFERENCES " + SEAT + " (" + SEAT_ID + " ));");
    }

    /**
     * the string required to create the Booking table
     * @return
     */
    public String createBookingTable(){
        return ("CREATE TABLE IF NOT EXISTS " + BOOKING + " ("
                + BOOKING_REF + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + STUDENT_NUMBER + " TEXT,"
                + TIME_SLOT_ID + " INTEGER,"
                + " FOREIGN KEY (" + STUDENT_NUMBER + ") REFERENCES " + STUDENT + "(" + STUDENT_NUM + "),"
                + " FOREIGN KEY (" + TIME_SLOT_ID + ") REFERENCES " + TIME_SLOT + "(" + TIME_SLOT_ID + "));");
    }

    /**
     * inserts the initial values into the Student table
     * @param db
     */
    public void insertStudents(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + STUDENT + " (" + STUDENT_NUM + "," + FNAME + "," + LNAME + "," + PASSWORD + ") VALUES ('UP785470', 'Stephen', 'Carlin', 'Password123')");
        db.execSQL("INSERT INTO " + STUDENT + " (" + STUDENT_NUM + "," + FNAME + "," + LNAME + "," + PASSWORD + ") VALUES ('UP700001', 'John', 'Doe', 'Password123')");
        db.execSQL("INSERT INTO " + STUDENT + " (" + STUDENT_NUM + "," + FNAME + "," + LNAME + "," + PASSWORD + ") VALUES ('UP700002', 'Jane', 'Doe', 'Password123')");
        db.execSQL("INSERT INTO " + STUDENT + " (" + STUDENT_NUM + "," + FNAME + "," + LNAME + "," + PASSWORD + ") VALUES ('UP999999', 'Tony', 'Hawk', 'ProSkater')");
        db.execSQL("INSERT INTO " + STUDENT + " (" + STUDENT_NUM + "," + FNAME + "," + LNAME + "," + PASSWORD + ") VALUES ('UP771744', 'Sara', 'Kotusiewicz', 'Password123')");


    }

    /**
     * inserts the initial values into the Seats table
     * @param db
     */
    public void insertSeats(SQLiteDatabase db){
        /** 0 is False, 1 is True */
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (1, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (1, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (1, 1);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (1, 1);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (2, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (2, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (2, 1);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (2, 1);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (3, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (3, 0);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (3, 1);");
        db.execSQL("INSERT INTO " + SEAT + " (" + FLOOR + "," + ISCOMP + ") VALUES (3, 1);");
    }

    /**
     * inserts the initial values into the Time_Slot table
     * @param db
     */
    public void insertTimes(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('09:00', 'Monday', 1, 0);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('10:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('11:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('12:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('13:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('14:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('15:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('16:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('17:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('18:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('19:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('20:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('21:00', 'Monday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('09:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('10:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('11:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('12:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('13:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('14:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('15:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('16:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('17:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('18:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('19:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('20:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('21:00', 'Tuesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('09:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('10:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('11:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('12:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('13:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('14:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('15:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('16:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('17:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('18:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('19:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('20:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('21:00', 'Wednesday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('09:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('10:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('11:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('12:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('13:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('14:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('15:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('16:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('17:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('18:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('19:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('20:00', 'Thursday', 1, 1);" );
        db.execSQL("INSERT INTO " + TIME_SLOT + "( " + TIME + "," + DAY + "," + AVAILABLE + "," + SEAT_NUM + ") VALUES ('21:00', 'Thursday', 1, 1);" );




    }

    /**
     * inserts the initial values into the Bookings table
     * @param db
     */
    public void insertBookings(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + BOOKING + "(" + STUDENT_NUMBER + "," + TIME_SLOT_ID + ") VALUES ('UP785470', 1);");
    }



}
