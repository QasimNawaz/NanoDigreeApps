package com.example.qasimnawaz.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultView;
    private Button resultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultView = (TextView) findViewById(R.id.result_textview);
        resultButton = (Button) findViewById(R.id.result_view_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText("You have Got "+QuizActivity.correct+" out of "+QuizActivity.answers.length);
                resultButton.setText("Do you want to restart the Quiz?");
                resultButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(ResultActivity.this, MainActivity.class);
                        startActivity(i);
                        QuizActivity.correct=0;
                    }
                });
            }
        });

    }
}
