package com.example.qasimnawaz.healthlevel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String msg;
    int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void message(int score){
        TextView message = (TextView) findViewById(R.id.textView);
        message.setText(msg);
    }
    public void yes(View view){
        points = points+1;
        msg = "You select 'YES' now your healt level is "+points;
        message(points);
    }
    public void sometimes(View view){
        msg = "You select 'SOMETIMES', so your health level is still on"+points;
        message(points);
    }
    public void no(View view){
        points = points-1;
        msg = "You select 'NO',  now your score is "+points;
        message(points);
    }
}
