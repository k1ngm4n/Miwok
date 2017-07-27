package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KingMan on 21-Jul-17.
 */

public class WordAdaptor extends ArrayAdapter<Word> {

    int mColorBackgroundID;

    public WordAdaptor(Activity context, ArrayList<Word> words, int backColorID) {
        super(context, 0, words);

        mColorBackgroundID = backColorID;
    }

    public WordAdaptor(Activity context, int resourceID, ArrayList<Word> words, int backColorID) {
        super(context, resourceID, words);

        mColorBackgroundID = backColorID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Word currentWord = getItem(position);

        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);
        default_text_view.setText(currentWord.getDefaultName());

        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwok_text_view.setText(currentWord.getTranslteName());

        ImageView numberImageView = (ImageView) listItemView.findViewById(R.id.imageNumber);

        if (currentWord.haveImage()) {
            numberImageView.setImageResource(currentWord.getResourceID());
        } else {
            numberImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.textContainer);
        int color = ContextCompat.getColor(getContext(), mColorBackgroundID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
