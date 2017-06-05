package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "waitlist.db";

    private static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    // TODO (4) Create a Constructor that takes a context and calls the parent constructor

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WAITLIST = "Create Table " + WaitlistContract.WaitlistEntry.TABLE_NAME + "( "
                + WaitlistContract.WaitlistEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT " +
                WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + "TEXT NOT NULL, " +
                WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " TIMESTAMP DEFAULT CURRENT TIMESTAMP" + "):";
        db.execSQL(SQL_CREATE_WAITLIST);
    }

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }

}