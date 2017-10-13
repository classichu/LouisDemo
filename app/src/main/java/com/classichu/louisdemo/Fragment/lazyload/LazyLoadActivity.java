package com.classichu.louisdemo.Fragment.lazyload;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

import com.classichu.louisdemo.Fragment.lazyload.frags.AFragment;
import com.classichu.louisdemo.Fragment.lazyload.frags.BFragment;
import com.classichu.louisdemo.Fragment.lazyload.frags.CFragment;
import com.classichu.louisdemo.Fragment.lazyload.frags.DFragment;
import com.classichu.louisdemo.R;

import java.util.ArrayList;
import java.util.List;

public class LazyLoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_load);

        ViewPager id_viewpager = (ViewPager) findViewById(R.id.id_viewpager);
        List<Pair<String,Fragment>> fragmentPair=new ArrayList<>();
        fragmentPair.add(new Pair<String, Fragment>("AFragment", AFragment.newInstance("","")));
        fragmentPair.add(new Pair<String, Fragment>("BFragment", BFragment.newInstance("","")));
        fragmentPair.add(new Pair<String, Fragment>("CFragment", CFragment.newInstance("","")));
        fragmentPair.add(new Pair<String, Fragment>("DFragment", DFragment.newInstance("","")));
         id_viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentPair));
        //  id_viewpager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager(),fragmentPair));

    }
}
