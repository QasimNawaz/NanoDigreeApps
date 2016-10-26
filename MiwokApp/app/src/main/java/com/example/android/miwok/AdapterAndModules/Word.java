package com.example.android.miwok.AdapterAndModules;


public class Word {
    public static final int no_imageProvided = -1;
    private String mDefaultTranslation;
    private String mPashtoTranslation;
    private int mAudioResourceID;
    private int imageResourceID = no_imageProvided;

    public Word(String defaultTranslation, String pashtoTranslation, int audioRecourceID) {
        mDefaultTranslation = defaultTranslation;
        mPashtoTranslation = pashtoTranslation;
        mAudioResourceID = audioRecourceID;
    }

    public Word(String defaultTranslation, String pashtoTranslation, int imageResourceID, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mPashtoTranslation = pashtoTranslation;
        this.imageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
    }

//    public Word(String defaultTranslation, String pashtoTranslation, int imageResourceID) {
//        mDefaultTranslation = defaultTranslation;
//        mPashtoTranslation = pashtoTranslation;
//        this.imageResourceID = imageResourceID;
//    }

    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getPashtoTranslation() {
        return mPashtoTranslation;
    }

    public boolean hasImage() {
        return imageResourceID != no_imageProvided;
    }
}
