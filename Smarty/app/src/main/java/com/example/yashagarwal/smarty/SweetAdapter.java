package com.example.yashagarwal.smarty;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
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



        ImageView mimageView = (ImageView) listItemView.findViewById(R.id.image1);
        mimageView.setImageResource(words.getImageResourceId());
        mimageView.setVisibility(View.VISIBLE);

        return listItemView;
    }
}
