package net.swallowsnest.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import net.swallowsnest.habittracker.data.HabitContract;
import net.swallowsnest.habittracker.data.HabitContract.HabitEntry;
import net.swallowsnest.habittracker.data.HabitDbHelper;

import static android.R.attr.inset;

public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mHabitDbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mHabitDbHelper = new HabitDbHelper(this);
            insertHabit();
            updateDisplay();
        }


    private void insertHabit(){
        // Gets the data repository in write mode
        SQLiteDatabase db = mHabitDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_NAME, "Marsha");
        values.put(HabitEntry.COLUMN_DATE, "Oct 28, 2016");
        values.put(HabitEntry.COLUMN_TEETH, 1);
        values.put(HabitEntry.COLUMN_HABIT, "meditate");


        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if(newRowId == -1) {
            Toast.makeText(this, "Error with saving habit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Habit saved with RowId: "+ newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    private Cursor read() {
            // Create and/or open a database to read from it
            SQLiteDatabase db = mHabitDbHelper.getReadableDatabase();

            String[] projection = {
                    HabitEntry._ID,
                    HabitEntry.COLUMN_NAME,
                    HabitEntry.COLUMN_DATE,
                    HabitEntry.COLUMN_TEETH,
                    HabitEntry.COLUMN_HABIT };

            // Perform query
            return db.query(
                    HabitEntry.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null);
    }

    private void updateDisplay() {
        Cursor cursor = read();

        TextView display = (TextView) findViewById(R.id.display_textview);
        display.setText("Number of rows in the database: " + cursor.getCount() + "\n\n");

        try {
            display.append(
                    HabitEntry._ID + " - " +
                            HabitEntry.COLUMN_NAME + " - " +
                            HabitEntry.COLUMN_DATE + " - " +
                            HabitEntry.COLUMN_TEETH + " - " +
                            HabitEntry.COLUMN_HABIT+ " - " + "\n"
            );

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_NAME);
            int dateColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_DATE);
            int teethColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_TEETH);
            int habitColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT);

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String name = cursor.getString(nameColumnIndex);
                String date = cursor.getString(dateColumnIndex);
                int teeth = cursor.getInt(teethColumnIndex);
                String habit = cursor.getString(habitColumnIndex);

                display.append("\n" +
                        id + " - " +
                        name + " - " +
                        date + " - " +
                        teeth + " - " +
                        habit);
            }
        } finally {
            cursor.close();
        }
    }
}
