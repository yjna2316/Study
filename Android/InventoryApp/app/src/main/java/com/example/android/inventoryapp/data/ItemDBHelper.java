package com.example.android.inventoryapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.inventoryapp.data.ItemContract.ItemEntry;

/**
 * Database helper for products app. Manages database creation and version management.
 */
public class ItemDBHelper extends SQLiteOpenHelper{

    public static final String LOG_TAG = ItemDBHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "pets.db";

    /** Database version. If you change the database schema, you must increment the database version. */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of ItemDBHelper()
     *
     * @param context of the app
     */
    public ItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the products table
        String SQL_CREATE_PRODUCT_TABLE =  "CREATE TABLE " + ItemEntry.TABLE_NAME + " ("
                + ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ItemEntry.COLUMN_ITEM_NAME+ " TEXT NOT NULL, "
                + ItemEntry.COLUMN_ITEM_QUANTITY + " TEXT, "
                + ItemEntry.COLUMN_ITEM_PRICE + " INTEGER NOT NULL, "
                + ItemEntry.COLUMN_ITEM_IMAGE + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PRODUCT_TABLE);
    }

    /**
     * This is called when the database schema of the database changes. (needs upgrade)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Create a String that contains the SQL statement to delete the products table
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ItemEntry.TABLE_NAME;

        // Execute the SQL statement
        db.execSQL(SQL_DELETE_ENTRIES);

        // Recreate the products table
        onCreate(db);
    }

}
