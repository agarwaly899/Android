package com.example.yashagarwal.smarty;

public class Sweet {
    private String mSweet;

    private int mImageResourceId;

    public Sweet(String MiwokTranslation,int imageId){

        mSweet=MiwokTranslation;
        mImageResourceId=imageId;

    }

    public String getSweet(){
        return mSweet;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
}
