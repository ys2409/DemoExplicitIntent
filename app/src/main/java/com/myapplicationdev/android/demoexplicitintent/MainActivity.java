package com.myapplicationdev.android.demoexplicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //the requests below identify who started the second activity
    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;
    TextView tvSuperman, tvBatman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = (TextView) findViewById(R.id.textViewSuperman);
        tvBatman = (TextView) findViewById(R.id.textViewBatman);

        //Set listener to handle clicking of superman textview
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create hero object of strength 100 n technical 60
                Hero superman = new Hero("Superman", 100, 60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                //put hero object in intent
                i.putExtra("hero", superman);
                //start activity with requestCodeForSupermanStats to
                //identify it was started by clicking on Superman
                startActivityForResult(i,requestCodeForSupermanStats);
            }
        });
        //set listener to handle clicking of batman textview
        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero batman = new Hero("Batman", 60, 90);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                //put hero obj in intent
                i.putExtra("hero", batman);
                //start activity with requestCodeForBatmanStats to
                //identify it was started by clicking on Batman
                startActivityForResult(i,requestCodeForBatmanStats);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //only handle when 2nd activity closed normally
        //and data contains something
        if(resultCode == RESULT_OK){
            if(data != null){
                //get data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";
                //if it is activity started by clicking
                //superman, create corresponding string
                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }
                //if 2nd activity started by clicking
                //batman, create corresponding string
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }

                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();
            }
        }
    }
}