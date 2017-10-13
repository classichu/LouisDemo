package com.classichu.louisdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.classichu.louisdemo.Fragment.lazyload.LazyLoadActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView id_listview = (ListView) findViewById(R.id.id_listview);
        final List<Pair<String, Class<?>>> pairArrayList = new ArrayList<>();
        //pairArrayList.add(Pair.<String, Class<?>>create("LazyLoadFragment", LazyLoadActivity.class));
        pairArrayList.add(new Pair<String, Class<?>>("LazyLoadFragment", LazyLoadActivity.class));
        ArrayAdapter<Pair<String, Class<?>>> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, pairArrayList);
        id_listview.setAdapter(arrayAdapter);
        id_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, pairArrayList.get(position).second);
                startActivity(intent);
            }
        });


    }
}
