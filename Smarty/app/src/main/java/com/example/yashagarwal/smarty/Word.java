package com.example.yashagarwal.smarty;

public class Word {
    private String mMiwokTranslation;

    private int mImageResourceId=-1;

    public Word(String MiwokTranslation){
        mMiwokTranslation=MiwokTranslation;
        }


    public Word(String MiwokTranslation, int imageId){
        mMiwokTranslation=MiwokTranslation;
        mImageResourceId=imageId;

    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId!=-1;
    }

}
