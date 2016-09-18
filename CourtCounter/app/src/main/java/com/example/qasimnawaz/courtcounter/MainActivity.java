package com.example.qasimnawaz.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAscore = 0;
    int teamBscore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayTeamAscore(int score){
        TextView displayTeamAscore = (TextView) findViewById(R.id.teamAscoreTextView);
        displayTeamAscore.setText(""+score);
    }

    public void teamAplus3(View view){
        teamAscore = teamAscore+3;
        displayTeamAscore(teamAscore);
    }
    public void teamAplus2(View view){
        teamAscore = teamAscore+2;
        displayTeamAscore(teamAscore);
    }
    public void teamAfreeThrow(View view){
        teamAscore = teamAscore+1;
        displayTeamAscore(teamAscore);
    }

    private void displayTeamBscore(int score){
        TextView displayTeamBscore = (TextView) findViewById(R.id.teamBscoreTextView);
        displayTeamBscore.setText(""+score);
    }

    public void teamBplus3(View view){
        teamBscore = teamBscore+3;
        displayTeamBscore(teamBscore);
    }
    public void teamBplus2(View view){
        teamBscore = teamBscore+2;
        displayTeamBscore(teamBscore);
    }
    public void teamBfreeThrow(View view){
        teamBscore = teamBscore+1;
        displayTeamBscore(teamBscore);
    }
    public void resetdata(View view){
        teamAscore = 0;
        teamBscore = 0;
        displayTeamAscore(teamAscore);
        displayTeamBscore(teamBscore);
    }
}
