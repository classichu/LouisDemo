package com.classichu.louisdemo.SlidingMenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by Classichu on 2017/10/7.
 */

public class SlidingMenu extends HorizontalScrollView {
    private Context mContext;
    private final float MENU_WIDTH_PERCENT = 0.3f;//菜单占屏幕宽度比
    private int mMenuWidth;

    public SlidingMenu(Context context) {
        this(context, null);
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        int screenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        mMenuWidth = (int) (screenWidth * MENU_WIDTH_PERCENT);
        //
        this.setOverScrollMode(View.OVER_SCROLL_NEVER);
        this.setHorizontalScrollBarEnabled(false);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (Math.abs(scrollX) > mMenuWidth / 2) {
                    open();
                } else {
                    close();
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    public void close() {
      //  isOpen = false;
        this.smoothScrollTo(mMenuWidth, 0);
    }

    public void open() {
       // isOpen = true;
        this.smoothScrollTo(0, 0);
    }
}
