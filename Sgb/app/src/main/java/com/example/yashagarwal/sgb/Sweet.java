package com.example.yashagarwal.sgb;

public class Sweet {
    private String mSweet;
    private String mPrice;
    private int mintPrice=0;
    private int mImageResourceId=-1;

    public Sweet(String MiwokTranslation,String DefaultTranslation,int imageId,int price){
        mPrice=DefaultTranslation;
        mSweet=MiwokTranslation;
        mImageResourceId=imageId;
        mintPrice=price;
    }

    public String getSweet(){
        return mSweet;
    }
    public String getPrice(){
        return mPrice;
    }
    public int getintPrice(){return mintPrice;}
    public int getImageResourceId(){
        return mImageResourceId;
    }
}
