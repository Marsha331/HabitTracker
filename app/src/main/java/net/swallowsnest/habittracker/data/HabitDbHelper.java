package net.swallowsnest.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.swallowsnest.habittracker.data.HabitDbHelper;
import net.swallowsnest.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by marshas on 10/27/16.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitDbHelper.class.getName();

    //database name
    public static final String DATABASE_NAME = "habits.db";

    //database version
    public static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //string for the SQL create table statement
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_DATE + " TEXT, "
                + HabitEntry.COLUMN_TEETH + " INTEGER, "
                + HabitEntry.COLUMN_HABIT + "TEXT)";

        //execute db
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //nothing to do here yet cause we're on version 1
    }
}

