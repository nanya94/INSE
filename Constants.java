package org.example.aprilversion;

import android.provider.BaseColumns;

/**
 * @author UP785470
 */

public interface Constants extends BaseColumns{
    /** Student table */
    String STUDENT = "Student";
    /** Columns in student table */
    String STD_ID = "std_id";
    String STUDENT_NUM = "stdNum";
    String FNAME = "fName";
    String LNAME = "lName";
    String PASSWORD = "password";

    /** Seat table */
    String SEAT = "Seat";
    /** Columns in seat table */
    String SEAT_ID = "seat_id";
    String FLOOR = "floor";
    String ISCOMP = "isComp";


    /** Time slots */
    String TIME_SLOT = "Time_Slot";
    /** Columns in Time slots */
    String TIME_SLOT_ID = "time_slot_id";
    String TIME = "Time";
    String DAY = "Day";
    String AVAILABLE = "Available";
    String SEAT_NUM = "Seat_ID";

    /*bookings*/
    String BOOKING = "Booking";
    /** Columns in Bookings */
    String BOOKING_REF = "booking_ref";

}
