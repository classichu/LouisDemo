package com.classichu.louisdemo.RecyclerView.onitemclick_suppert_way1;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Classichu on 2017/10/8.
 * SimpleOnItemTouchListener是RecyclerView.OnItemTouchListener官方的默认空实现
 */
public abstract class OnRVItemTouchListener extends RecyclerView.SimpleOnItemTouchListener {
    private final RecyclerView mRecyclerView;
    private final GestureDetectorCompat mGestureDetectorCompat;

    public OnRVItemTouchListener(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mGestureDetectorCompat = new GestureDetectorCompat(mRecyclerView.getContext(),
                //OnGestureListener实现类
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {

                        //通过点击的x,y 获得对应的item
                        View itemView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                        RecyclerView.ViewHolder viewHolder = mRecyclerView.getChildViewHolder(itemView);
                        //
                        onItemClick(viewHolder);

                        return false;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        //通过点击的x,y 获得对应的item
                        View itemView = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                        RecyclerView.ViewHolder viewHolder = mRecyclerView.getChildViewHolder(itemView);
                        //
                        onItemLongClick(viewHolder);
                    }
                });
    }

    //将触摸事件交由mGestureDetectorCompat处理
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
    }

    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder);

    public abstract void onItemLongClick(RecyclerView.ViewHolder viewHolder);

}
