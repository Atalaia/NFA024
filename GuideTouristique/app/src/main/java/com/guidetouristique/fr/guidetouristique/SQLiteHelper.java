package com.guidetouristique.fr.guidetouristique;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";

    public static final String TABLE_NAME = "ATTRACTIONS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    //  public static final String COLUMN_PHOTO = "PHOTO";
    // public static final String COLUMN_AUDIO = "AUDIO";
    public static final String COLUMN_LAT = "LATITUDE";
    public static final String COLUMN_LONG = "LONGITUDE";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " VARCHAR, " + COLUMN_CATEGORY + " VARCHAR, " + COLUMN_DESCRIPTION + " VARCHAR, "
                + COLUMN_LAT + "FLOAT," + COLUMN_LONG + "FLOAT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private SQLiteDatabase database;

    public void insertRecord(AttractionsModel attraction) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, attraction.getName());
        contentValues.put(COLUMN_CATEGORY, attraction.getCategory());
        contentValues.put(COLUMN_DESCRIPTION, attraction.getDescription());
        contentValues.put(COLUMN_LAT, attraction.getLatitude());
        contentValues.put(COLUMN_LONG, attraction.getLongitude());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public void updateRecord(AttractionsModel attraction) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, attraction.getName());
        contentValues.put(COLUMN_CATEGORY, attraction.getCategory());
        contentValues.put(COLUMN_DESCRIPTION, attraction.getDescription());
        contentValues.put(COLUMN_LAT, attraction.getLatitude());
        contentValues.put(COLUMN_LONG, attraction.getLongitude());
        database.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[]{attraction.getID()});
        database.close();
    }

    public void deleteRecord(AttractionsModel attraction) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{attraction.getID()});
        database.close();
    }

    public ArrayList<AttractionsModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<AttractionsModel> attractions = new ArrayList<AttractionsModel>();
        AttractionsModel attraction;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                attraction = new AttractionsModel();
                attraction.setID(cursor.getString(0));
                attraction.setName(cursor.getString(1));
                attraction.setCategory(cursor.getString(2));
                attraction.setDescription(cursor.getString(3));
                attraction.setLatitude(cursor.getFloat(4));
                attraction.setLongitude(cursor.getFloat(5));
                attractions.add(attraction);
            }
        }
        cursor.close();
        database.close();
        return attractions;
    }

    Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);

}
