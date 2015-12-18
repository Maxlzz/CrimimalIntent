package com.max.crimimalintent;

import android.support.v4.app.Fragment;
/*
存在超累之后直接获取crimelistactivity,而buyongfragmentactivity减少代码输出
 */

public class MainActivity extends SingleFragmentActivity {


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.frameContainer);
//        if (fragment==null){
//            fragment = new CrimeFragment();
//            fm.beginTransaction()
//                    .add(R.id.frameContainer,fragment)
//                    .commit();
//        }
//    }
@Override
protected Fragment createFragment() {
    return new CrimeFragment();//返回一个新建的crimefragmnt
}
}
