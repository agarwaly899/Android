package com.example.android.quakereport;

public class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private String mUrl;
    private long mTimemilli;
    public Earthquake(double magnitude,String place,long time,String url){
        mMagnitude=magnitude;
        mPlace=place;
        mTimemilli=time;
        mUrl=url;
    }
    public double getMagnitude(){
        return mMagnitude;
    }
    public String getPlace(){
        return mPlace;
    }
    public long getTimeInMilliSeconds(){
        return mTimemilli;
    }
    public String getUrl(){
        return mUrl;
    }
}
