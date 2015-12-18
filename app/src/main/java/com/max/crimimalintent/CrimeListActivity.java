package com.max.crimimalintent;

import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by Administrator on 2015/12/18.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {

       // return new CrimeListFragment();//返回一个新建的crimelistfragment
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }


}
