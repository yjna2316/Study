package com.example.android.courtcount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(0);
        displayForTeamB(0);
    }

    int score = 0, scoreB = 0;
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plusThree(View view) {
        score = score + 3;
        displayForTeamA(score);
    }

    public void plusTwo(View view) {
        score = score + 2;
        displayForTeamA(score);
    }

    public void freeThrow(View view) {
        score = score + 1;
        displayForTeamA(score);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void plusThreeB(View view) {
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);
    }

    public void plusTwoB(View view) {
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }

    public void freeThrowB(View view) {
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
    }

    public void reset(View view) {
        displayForTeamA(0);
        displayForTeamB(0);
    }


}
