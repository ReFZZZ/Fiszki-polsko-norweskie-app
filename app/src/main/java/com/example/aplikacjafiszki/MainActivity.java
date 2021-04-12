package com.example.aplikacjafiszki;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button bWords;
    private Button bAbout;
    private Button bExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout constraintLayout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        // PRZYCISK FISZKI
        bWords = (Button) findViewById(R.id.bWords);
        bWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWords();
            }
        });

        // PRZYCISK AUTOR
        bAbout = (Button) findViewById(R.id.bAbout);
        bAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
        // PRZYCISK WYJSCIE
        bExit = (Button) findViewById(R.id.bExit);
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExit();
            }
        });
    }

    public void openWords() {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void openAbout() {
        Intent intent = new Intent(this, about.class);
        startActivity(intent);
    }

    public void openExit() {
        finish();
        System.exit(0);
    }
}
