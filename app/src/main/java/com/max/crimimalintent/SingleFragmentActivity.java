package com.max.crimimalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * 本书中几乎每一个创建的activity都需要同样的代码。为避免不必要的重复性输入，我们将这
 些重复代码置入一个抽象类，以供使用。
 在 CriminalIntent 类 包 里 创 建 一 个 名 为 SingleFragmentActivity 的 新 类 。 选 择
 FragmentActivity类作为它的超类，然后勾选abstract选项，让SingleFragmentActivity类成
 为一个抽象类
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected abstract Fragment createFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frameContainer);
        if (fragment==null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.frameContainer,fragment)
                    .commit();

        }
    }
}
