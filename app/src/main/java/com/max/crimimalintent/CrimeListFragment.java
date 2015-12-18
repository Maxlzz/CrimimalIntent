package com.max.crimimalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * 在CrimeListFragment中获取crime
 */
public class CrimeListFragment extends ListFragment {
    private static final String TAG = "CrimeListFragment";
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called");


        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        //为listview创建适配器
//        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),
//                android.R.layout.simple_list_item_1,mCrimes);
        //明确后可直接绑定
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    //listview点击事件
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
//        Crime c = ((Crime)(getListAdapter()).getItem(position));
        Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + "clicked");

        //start MainActivity from CrimeListFragment
        Intent i = new Intent(getActivity(), MainActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);

    }

    //创建adapter内部类，主要是增添listview的内容
    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);

        }
        //覆盖原生的getview

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                Log.d(TAG, "getView: called");
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);

            }
            Crime c = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;


        }
    }
    /*
    CrimeListFragment启动CrimeActivity实例后， CrimeActivity被置于回退栈顶。这导致
原先处于栈顶的CrimeListActivity实例被暂停并停止。所以。。你懂的onresume()启动onpause状态的crimelistfragment，
回退时作为栈顶
     */

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }
}
