package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Character> characters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCharacters();
        RecyclerView rv = findViewById(R.id.recycler_view);
        CharacterAdapter ca = new CharacterAdapter(characters);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(ca);
    }

    private void initCharacters() {
        String[] data = {"A", "B", "C", "D", "E", "F", "G"};
        for (int i=0; i < 3; i++) {
            for (String s : data) {
                characters.add(new Character(s, R.drawable.ic_launcher_foreground));
            }
        }
    }
}
