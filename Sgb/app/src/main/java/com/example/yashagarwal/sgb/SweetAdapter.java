package com.example.yashagarwal.sgb;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SweetAdapter extends ArrayAdapter<Sweet> {

    public SweetAdapter(Context context, ArrayList<Sweet> words){
        super(context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if (listItemView==null){
            listItemView=LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Sweet words=getItem(position);

        TextView sweetTextView=(TextView) listItemView.findViewById(R.id.sweet_text_view);
        sweetTextView.setText(words.getSweet());
        sweetTextView.setVisibility(View.VISIBLE);

        TextView priceTextView=(TextView) listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(words.getPrice());
        priceTextView.setVisibility(View.VISIBLE);

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        iconView.setImageResource(words.getImageResourceId());
        iconView.setVisibility(View.VISIBLE);

        return listItemView;
    }
}
