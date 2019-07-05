package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId=-1;
    private int mAudioResourceId;
    public Word(String MiwokTranslation,String DefaultTranslation,int AudioId){
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
       mAudioResourceId=AudioId;
    }
    public Word(String MiwokTranslation,String DefaultTranslation,int imageId,int AudioId){
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation=MiwokTranslation;
        mImageResourceId=imageId;
        mAudioResourceId=AudioId;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId!=-1;
    }
    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
