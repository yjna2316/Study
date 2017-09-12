package com.example.android.inventoryapp;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.inventoryapp.data.ItemContract.ItemEntry;

public class ListActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {

    /** The Loader's unique id */
    private static final int ITEM_LOADER = 0;

    /** Adapter being used to display the data in listView */
    ItemCursorAdapter cursorAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // Find the ListView which will be populated with the item data
        ListView itemListView = (ListView) findViewById(R.id.list);

        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        itemListView.setEmptyView(emptyView);

        // Setup cursor adapter to create a list item for each row of item data in the Cursor.
        // There is no item data yet (until the loader finishes) so pass in null for the cursor.
        cursorAdapter = new ItemCursorAdapter(this, null);
        // Attach cursor adapter to the ListView
        itemListView.setAdapter(cursorAdapter);
        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * @param adapterView  The AdapterView where the click happened.
             * @param view         The view that was clicked within the AdapterView
             * @param position     The position of the view in the adapter
             * @param id           The row id of the item that was clicked
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
              // Create new intent to go to {Editor Activity}
              Intent intent = new Intent(ListActivity.this, EditorActivity.class);

              // Form the content URI that represents the specific item that was clicked on,
              // by appending the "id" (passed as input to this method) onto the
              // {ItemEntry.CONTENT_URI}
              // For example, the URI would be "content://com.example.android.inventoryapp/items/2"
              // if the item with ID 2 was clicked on.
              Uri currentItemUri = ContentUris.withAppendedId(ItemEntry.CONTENT_URI, id);

              // Set the URI on the data field of the intent
              intent.setData(currentItemUri);

              // Launch the {EditorActivity} to display the data for the current item.
              startActivity(intent);
            }
        });

        // Start the loader
        getLoaderManager().initLoader(ITEM_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Define a projection that specifies the columns from the table we care about.
        String[] projection = {
                ItemEntry._ID,
                ItemEntry.COLUMN_ITEM_NAME,
                ItemEntry.COLUMN_ITEM_QUANTITY,
                ItemEntry.COLUMN_ITEM_PRICE };

        // This loader will execute the ContentProvider's query method on a background thread
        return new CursorLoader(this,  // Parent activity context
                ItemEntry.CONTENT_URI, // Provider content URI to query
                projection,            // Columns to include in the resulting Cursor
                null,                  // No selection clause
                null,                  // No selection arguments
                null);                 // Default sort order

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        // Update {ItemCursorAdapter} with this new cursor containing updated item data
        // The framework will take care of closing the old cursor once we return.
        cursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        // The Loader's data is now unavailable.
        // Remove any references to the old data by replacing it with
        // a null Cursor.
        cursorAdapter.swapCursor(null);
    }


}
