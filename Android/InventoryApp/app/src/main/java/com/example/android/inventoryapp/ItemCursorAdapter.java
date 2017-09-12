package com.example.android.inventoryapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.inventoryapp.data.ItemContract.ItemEntry;


/**
 * Define the adapter to describe the process of projecting the Cursor's data into a View.
 */
public class ItemCursorAdapter extends CursorAdapter{
    /**
     * @param context The context
     * @param cursor  The cursor from which to get the data
     */
    public ItemCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0 /* flag */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the view yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                 moved to the correct position
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * The method binds the item data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current item can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields that we want to modify in the list item layout
        TextView nameTextView = (TextView)view.findViewById(R.id.name);
        TextView quantityTextView = (TextView)view.findViewById(R.id.quantity);
        TextView priceTextView = (TextView)view.findViewById(R.id.price);

        // Find the columns of item attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(ItemEntry.COLUMN_ITEM_PRICE);

        // Read the item attributes from the Cursor for the current item
        String itemName = cursor.getString(nameColumnIndex);
        String itemQuantity = cursor.getString(quantityColumnIndex);
        String itemPrice = cursor.getString(priceColumnIndex);


        // update the TextViews with the attributes for the current item
        nameTextView.setText(itemName);
        quantityTextView.setText(itemQuantity);
        priceTextView.setText(itemPrice);
    }
}
