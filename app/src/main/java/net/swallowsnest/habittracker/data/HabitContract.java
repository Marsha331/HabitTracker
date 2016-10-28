package net.swallowsnest.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by marshas on 10/27/16.
 */

public class HabitContract {

    public static abstract class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TEETH = "teeth";
        public static final String COLUMN_HABIT = "habit";

    }
}