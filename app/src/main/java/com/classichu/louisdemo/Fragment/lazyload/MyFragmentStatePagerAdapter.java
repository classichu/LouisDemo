package com.classichu.louisdemo.Fragment.lazyload;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Pair;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by louisgeek on 2017/10/9.
 * FragmentPagerAdapter和FragmentStatePagerAdapter最大的区别就是instantiateItem和 destroyItem实现不一样,如果都重写了2者的效果就基本一样了
 * 重写instantiateItem ，destroyItem 滑动切换 Fragment数据保存状态
 */


public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter{
    private List<Pair<String,Fragment>> mFragmentPair;
    private FragmentManager mFragmentManager;
    public MyFragmentStatePagerAdapter(FragmentManager fm, List<Pair<String,Fragment>> mFragmentPair) {
        super(fm);
        this.mFragmentManager=fm;
        this.mFragmentPair = mFragmentPair;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentPair.get(position).second;
    }

    @Override
    public int getCount() {
        return mFragmentPair.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  mFragmentPair.get(position).first;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mFragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
        //###return super.instantiateItem(container, position);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //###super.destroyItem(container, position, object);
        Fragment fragment = mFragmentPair.get(position).second;
        mFragmentManager.beginTransaction().hide(fragment).commitAllowingStateLoss();
    }
}
