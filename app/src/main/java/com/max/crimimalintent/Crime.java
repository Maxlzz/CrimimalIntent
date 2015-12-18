package com.max.crimimalintent;

import android.util.Log;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Crime {
    private static final String TAG = "Crime";
    private UUID mId;
    private String mTitle;
    private boolean mSolved;
    private Date mDate;
    public Crime(){
//        生成唯一标识符
        mId = UUID.randomUUID();
        mDate = new Date();

    }

    @Override
    public String toString() {
        return mTitle;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
        Log.d(TAG, "setDate: called");
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
