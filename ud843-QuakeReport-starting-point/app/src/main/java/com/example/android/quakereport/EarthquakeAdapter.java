package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }
    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View listitemView;
        Earthquake currentearthquake=getItem(position);
        listitemView=convertView;
        if(listitemView==null){
            listitemView=LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }
        TextView magnitude=(TextView) listitemView.findViewById(R.id.magnitude);
        magnitude.setText(formatMagnitude(currentearthquake.getMagnitude()));

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentearthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String place =currentearthquake.getPlace();
        String place1,place2;
        if (place.contains("of")) {
            place1 = place.substring(0, place.indexOf("of") + 2);
            place2 = place.substring(place.indexOf("of") + 3, place.length());
        }
        else {
            place1 = "Near the";
            place2 = place;
        }
        TextView place1text=(TextView) listitemView.findViewById(R.id.location_offset);
        place1text.setText(place1);

        TextView place2text=(TextView) listitemView.findViewById(R.id.primary_location);
        place2text.setText(place2);

        Date dateobject=new Date(currentearthquake.getTimeInMilliSeconds());

        TextView date=(TextView) listitemView.findViewById(R.id.date);
        date.setText(formatDate(dateobject));

        TextView time=(TextView) listitemView.findViewById(R.id.time);
        time.setText(formatTime(dateobject));

        return listitemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude){
        DecimalFormat formatter=new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }
    private int getMagnitudeColor(double magnitude){
        int magColourId;
        int magnitudeFloor=(int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:magColourId=R.color.magnitude1;
                break;
            case 2:magColourId=R.color.magnitude2;
                break;
            case 3:magColourId=R.color.magnitude3;
                break;
            case 4:magColourId=R.color.magnitude4;
                break;
            case 5:magColourId=R.color.magnitude5;
                break;
            case 6:magColourId=R.color.magnitude6;
                break;
            case 7:magColourId=R.color.magnitude7;
                break;
            case 8:magColourId=R.color.magnitude8;
                break;
            case 9:magColourId=R.color.magnitude9;
                break;
            default:magColourId=R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magColourId);
    }
}
