package com.example.yashagarwal.smarty;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColourSourceId;
    public WordAdapter(Context context, ArrayList<Word> words){
        super(context,0,words);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if (listItemView==null){
            listItemView=LayoutInflater.from(getContext()).inflate(
                    R.layout.device_item, parent, false);
        }
        Word words=getItem(position);

        TextView miwokTextView=(TextView) listItemView.findViewById(R.id.device_text_view);
        miwokTextView.setText(words.getMiwokTranslation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if (words.hasImage()) {
            iconView.setImageResource(words.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            iconView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
