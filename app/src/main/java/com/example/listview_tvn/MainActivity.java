package com.example.listview_tvn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAdapter();
    }

    private void createAdapter() {
        List<Map<String, String>> values = prepareContent();
        ListView listView = findViewById(R.id.list);
        BaseAdapter listContentAdapter = new SimpleAdapter(this,
                values,
                R.layout.my_simple_list_item,
                new String[]{"title", "subtitle"},
                new int[]{R.id.titleView, R.id.subtitleView}
        );
        listView.setAdapter(listContentAdapter);
    }

    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> result = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (String s : arrayContent) {
            Map<String, String> myMap = new HashMap<>();
            myMap.put("title", s);
            myMap.put("subtitle", String.valueOf(s.length()));
            result.add(myMap);
        }
        return result;
    }

}
