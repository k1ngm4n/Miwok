package com.example.android.miwok;

import android.content.res.Resources;

/**
 * Created by KingMan on 21-Jul-17.
 */

public class Word {
    private String mOriginWord;
    private String mTranslateWord;
    private int mResourceID = -1;

    private int mAudioID = -1;

    public boolean haveImage() {
        return mResourceID != -1;
    }

    public boolean haveAudio() {
        return mAudioID != -1;
    }

    public Word(String originWord, String translateWord) {
        mOriginWord = originWord;
        mTranslateWord = translateWord;
    }

    public Word(String originWord, String translateWord, int audioID) {
        mOriginWord = originWord;
        mTranslateWord = translateWord;
        mAudioID = audioID;
    }

    public Word(String originWord, String translateWord, int resourceID, int audioID) {
        mOriginWord = originWord;
        mTranslateWord = translateWord;
        mResourceID = resourceID;
        mAudioID = audioID;
    }

    public String getDefaultName() {
        return mOriginWord;
    }

    public String getTranslteName() {
        return mTranslateWord;
    }

    public int getResourceID() {
        return mResourceID;
    }

    public int getAudioID() {
        return mAudioID;
    }
}