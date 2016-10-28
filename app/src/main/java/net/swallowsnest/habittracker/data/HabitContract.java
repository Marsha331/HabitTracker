package net.swallowsnest.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by marshas on 10/27/16.
 */

public class HabitContract {

    public static abstract class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habit";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TEETH = "teeth";
        public static final String COLUMN_HABIT = "newhabit";

        public static final int TEETH_ZERO = 0;
        public static final int TEETH_ONCE = 1;
        public static final int TEETH_TWICE = 2;

    }
}