package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Set;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Word} objects.
 * Created by Sir Tryton on 2018-03-12.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColourResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     */

    public WordAdapter(Activity context, ArrayList<Word> words, int ColourResourceId ) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColourResourceId = ColourResourceId;
    }



    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        //set the theme color for the list item
        View textContainer = (View) listItemView.findViewById(R.id.text_container);
        //Find the color that the resourced ID refers to
        int color = ContextCompat.getColor(getContext(),mColourResourceId);
        //Set the background color for text container
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID miwok_words
        TextView miwokWordsTextView = (TextView) listItemView.findViewById(R.id.miwok_words);
        // Get the mMiwokTranslation from the current Word object and
        // set this text on the miwok_words TextView
        miwokWordsTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default words
        TextView defaultWordsTextView = (TextView) listItemView.findViewById(R.id.default_words);
        // Get the defaultTranslation from the current Word object and
        // set this text on the default_words TextView
        defaultWordsTextView.setText(currentWord.getDefaultTranslation());

        //Find ImageView in the list_item.xml layout with the ID image
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        //Get the image from the current Word object and
        // set this it on the image ImageView
        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResource());

            // Make sure the view is visible
            image.setVisibility(View.VISIBLE);
        }
        else{
            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);}

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

        //return super.getView(position, convertView, parent);

    }
}
