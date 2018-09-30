package com.gitapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gitapapp.love.MainActivity;
import com.gitapapp.love.R;

public class TitleActivity extends AppCompatActivity {

    private String part;
    private TextView t1, t2, t3, t4, t5, t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);
        t5 = findViewById(R.id.text5);
        t6 = findViewById(R.id.text6);

        Button button = findViewById(R.id.button);
        part = getIntent().getStringExtra("part");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chapter = new Intent(TitleActivity.this, MainActivity.class);
                chapter.putExtra("part", part);
                startActivity(chapter);
            }
        });

        switch (part) {
            case "partOne": {
                t1.setText(getResources().getString(R.string.chapter7));
                t2.setText(getResources().getString(R.string.chapter8));
                t3.setText(getResources().getString(R.string.chapter9));
                t4.setVisibility(View.GONE);
                t5.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);

                break;
            }
            case "partTwo": {
                t1.setText(getResources().getString(R.string.chapter10));
                t2.setText(getResources().getString(R.string.chapter11));
                t3.setText(getResources().getString(R.string.chapter12));
                t4.setVisibility(View.GONE);
                t5.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);

                break;
            }
            case "partThree": {
                t1.setText(getResources().getString(R.string.chapter13));
                t2.setText(getResources().getString(R.string.chapter14));
                t3.setText(getResources().getString(R.string.chapter15));
                t4.setText(getResources().getString(R.string.chapter16));
                t5.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);

                break;
            }
            case "partFour": {
                t1.setText(getResources().getString(R.string.chapter17));
                t2.setText(getResources().getString(R.string.chapter18));
                t3.setText(getResources().getString(R.string.chapter19));
                t4.setText(getResources().getString(R.string.chapter20));
                t5.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);

                break;
            }
            case "partFive": {
                t1.setText(getResources().getString(R.string.chapter21));
                t2.setText(getResources().getString(R.string.chapter22));
                t3.setText(getResources().getString(R.string.chapter23));
                t4.setText(getResources().getString(R.string.chapter24));
                t5.setText(getResources().getString(R.string.chapter25));
                t6.setText(getResources().getString(R.string.chapter26));

                break;
            }
            case "partSix": {
                t1.setText(getResources().getString(R.string.chapter27));
                t2.setText(getResources().getString(R.string.chapter28));
                t3.setText(getResources().getString(R.string.chapter29));
                t4.setVisibility(View.GONE);
                t5.setVisibility(View.GONE);
                t6.setVisibility(View.GONE);

                break;
            }
        }
    }
}
