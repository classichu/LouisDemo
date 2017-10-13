package com.classichu.louisdemo.Fragment.lazyload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by louisgeek on 2017/10/9.
 * 1.延迟加载
 * 2.第一次加载
 *
 * //todo 如果子类 onUserFirstVisible 内进行加载网络数据失败后 不再回调了  业务逻辑优化？
 *
 *
 */

public abstract class LazyLoadFragment extends Fragment {
    private boolean isViewCreated = false;
    private boolean hasFinishFirstVisible = false;



    @Override
    public void onResume() {
        super.onResume();
        //兼容：要点A，setUserVisibleHint不会调用,getUserVisibleHint()一直为true
        if(getUserVisibleHint()){
            // 判断是否完成第一次可见操作 !!!同时兼容了要点C ： viewpager进来第一个页面 setUserVisibleHint(true) 优先于 view created，而其他页面已经在上一个页面可见的时候初始化完了
            if (!hasFinishFirstVisible) {
                this.onUserFirstVisible();
                hasFinishFirstVisible=true;
            }
            onUserVisibleStateChange(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        //兼容：要点A，setUserVisibleHint不会调用,getUserVisibleHint()一直为true
        if(getUserVisibleHint()){
            onUserVisibleStateChange(false);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = false;
    }

    /**
     * 要点A：单个 Fragment，setUserVisibleHint 是不会被调用的(但是getUserVisibleHint()，
     * 返回的是mUserVisibleHint字段的值，而mUserVisibleHint字段默认值是true)，
     * 只有该 Fragment 在 ViewPager 里才会被调用（FragmentPagerAdapter或者FragmentStatePagerAdapter）
     * 要点B: 有可能在fragment的生命周期外被调用，执行顺序：setUserVisibleHint 方法在Fragment的生命周期函数之前执行一次，此时isVisibleToUser是false
     * ，后续还会执行一次，此时isVisibleToUser是true，但是这次的时间是不确定的
     * 要点C：另外ViewPager会在设置Adapter之后立即调用第一个、第二个fragment的setUserVisibleHint(boolean)方法设置为false，
     * 然后会对第一个fragment再次调用setUserVisibleHint(boolean)方法设置为true，然后才是onAttach()、onCreate()
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //1判断view已经准备完毕,处理:要点B
        if (!isViewCreated) {
            return;
        }
        if (isVisibleToUser) {
            // 判断是否完成第一次可见操作
            if (!hasFinishFirstVisible) {
                this.onUserFirstVisible();
                hasFinishFirstVisible=true;
            }
            this.onUserVisibleStateChange(true);
        } else {
            this.onUserVisibleStateChange(false);
        }
    }
    //第一次可见回调
    public abstract void onUserFirstVisible();
    //可见状态改变就回调
    public abstract void onUserVisibleStateChange(boolean isVisible);

}
