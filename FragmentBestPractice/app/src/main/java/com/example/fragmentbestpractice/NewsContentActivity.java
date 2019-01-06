package com.example.fragmentbestpractice;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", title);
        intent.putExtra("news_content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        String title = getIntent().getStringExtra("news_title");
        String content = getIntent().getStringExtra("news_content");
        FragmentManager fm = getSupportFragmentManager();
        NewContentFragment ncf = (NewContentFragment) fm.findFragmentById(R.id.news_content_fragment);
        ncf.refresh(title, content);
    }
}
