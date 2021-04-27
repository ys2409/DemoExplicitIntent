package com.myapplicationdev.android.demoexplicitintent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.temporal.Temporal;

public class HeroStatsActivity extends AppCompatActivity {
    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        //get intent
        Intent i = getIntent();
        //get hero obj first activity put in Intent
        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = (TextView) findViewById(R.id.textViewName);
        tvStrength = (TextView) findViewById(R.id.textViewStrength);
        tvTechnicalProwess = (TextView) findViewById(R.id.textViewTechnicalProwess);
        btnLike = (Button) findViewById(R.id.buttonLike);
        btnDislike = (Button) findViewById(R.id.buttonDislike);

        //use getters of hero obj to get attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        //when button like is clicked, set results
        //accordingly and finish() to close the act
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent and pass in string data
                Intent i = new Intent();
                i.putExtra("like", "like");
                //set result to RESULT_OK to indicate
                //normal response and pass in intent
                //containing the like
                setResult(RESULT_OK, i);
                finish();
            }
        });

        //when button dislike is clicked, set results
        // accordingly and finish() to close the activity
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent and pass in string data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                //set results to RESULT_OK to indicate normal
                //response and pass in the intent containing
                // dislike
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
