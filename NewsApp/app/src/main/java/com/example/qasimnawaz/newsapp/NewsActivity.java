package com.example.qasimnawaz.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity {
    Bundle bundle;
    private static final String DEBUG_TAG = "DEBUGGING";
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        if (getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
        }

        link = getIntent().getStringExtra("content");
        Log.d("Content", link);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(link);


    }


}