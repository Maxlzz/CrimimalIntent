package com.max.crimimalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by Administrator on 2015/12/18.
 */
public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    //私有构造方法
    public CrimeLab(Context appContext){
        Log.d(TAG, "CrimeLab: called");
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();

        for (int i = 0;i < 100;i++){
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);//every other one
            mCrimes.add(c);
        }
    }
    /*
    CrimeLab类的构造方法需要一个Context参数。这在Android开发里很常见，使用Context
参数，单例可完成启动activity、获取项目资源，查找应用的私有存储空间等任务。
     */
    public static CrimeLab get(Context c) {
        if (sCrimeLab==null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
            //为保证单例总是有Context可以使用，可调用getApplicationContext()方法，将
//            不确定是否存在的Context替换成application context。 application context是针对应用的全局性
//            Context。任何时候，只要是应用层面的单例，就应该一直使用application context。
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c:mCrimes){
            if (c.getId().equals(id)){
                return c;
           }
        }
       return null;
    }



}
