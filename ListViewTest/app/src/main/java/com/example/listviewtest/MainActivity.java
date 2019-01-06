package com.example.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Char> charList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChars();
        CharAdapter ca = new CharAdapter(MainActivity.this, R.layout.fruit_item, this.charList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(ca);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Char c = charList.get(position);
                Toast.makeText(MainActivity.this, "Clicked: " + c.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initChars() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"
        };
        for (String s: data) {
            Char c = new Char(s, R.drawable.ic_launcher_foreground);
            this.charList.add(c);
        }
    }
}
