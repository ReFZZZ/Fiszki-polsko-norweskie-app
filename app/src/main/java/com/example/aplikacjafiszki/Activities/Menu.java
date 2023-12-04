//Class allows to select a set of words
package com.example.aplikacjafiszki.Activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.aplikacjafiszki.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        //Buttons
        Button b_1_50 = findViewById(R.id.b_1_50);
        Button b_51_100 = findViewById(R.id.b_51_100);
        Button b_101_150 = findViewById(R.id.b_101_150);
        Button b_151_200 = findViewById(R.id.b_151_200);
        Button b_201_250 = findViewById(R.id.b_201_250);
        Button b_251_300 = findViewById(R.id.b_251_300);
        Button b_301_350 = findViewById(R.id.b_301_350);
        Button b_351_400 = findViewById(R.id.b_351_400);
        Button b_401_450 = findViewById(R.id.b_401_450);
        Button b_451_500 = findViewById(R.id.b_451_500);
        Button b_501_550 = findViewById(R.id.b_501_550);
        Button b_551_600 = findViewById(R.id.b_551_600);

        //Setting the behavior of the buttons
        b_1_50.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_001_050.json"));

        b_51_100.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_051_100.json"));

        b_101_150.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_101_150.json"));

        b_151_200.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_151_200.json"));

        b_201_250.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_201_250.json"));

        b_251_300.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_251_300.json"));

        b_301_350.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_301_350.json"));

        b_351_400.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_351_400.json"));

        b_401_450.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_401_450.json"));

        b_451_500.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_451_500.json"));

        b_501_550.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_501_550.json"));

        b_551_600.setOnClickListener(view -> open(
                new Intent(getApplicationContext(), Flashcards.class),
                "word_551_600.json"));
    }
    //The method passes additional information about the name of the file to be deserialized to the next activity.
    public void open(Intent intent, String fileName) {
        intent.putExtra("fileWithWords", fileName);
        startActivity(intent);
    }
}