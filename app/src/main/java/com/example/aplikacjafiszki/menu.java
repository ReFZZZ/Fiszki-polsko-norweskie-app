package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
private Button b_1_50;
private Button b_51_100;
private Button b_101_150;
private Button b_151_200;
private Button b_201_250;
private Button b_251_300;
private Button b_301_350;
private Button b_351_400;
private Button b_401_450;
private Button b_451_500;
private Button b_501_550;
private Button b_551_600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        b_1_50 = (Button) findViewById(R.id.b_1_50);
        b_1_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open1_50();
            }
        });

        b_51_100 =(Button) findViewById(R.id.b_51_100);
        b_51_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open51_100();
            }
        });

        b_101_150 = (Button) findViewById(R.id.b_101_150);
        b_101_150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open101_150();
            }
        });

        b_151_200 =(Button) findViewById(R.id.b_151_200);
        b_151_200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open151_200();
            }
        });

        b_201_250 =(Button) findViewById(R.id.b_201_250);
        b_201_250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open201_250();
            }
        });

        b_251_300 = (Button) findViewById(R.id.b_251_300);
        b_251_300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open251_300();
            }
        });

        b_301_350 =(Button) findViewById(R.id.b_301_350);
        b_301_350.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open301_350();
            }
        });

        b_351_400 =(Button) findViewById(R.id.b_351_400);
        b_351_400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open351_400();
            }
        });

        b_401_450 = (Button) findViewById(R.id.b_401_450);
        b_401_450.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            open401_450();
            }
        });

        b_451_500 = (Button) findViewById(R.id.b_451_500);
        b_451_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open451_500();
            }
        });

        b_501_550 = (Button) findViewById(R.id.b_501_550);
        b_501_550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open501_550();
            }
        });

        b_551_600 = (Button) findViewById(R.id.b_551_600);
        b_551_600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open551_600();
            }
        });
    }

    public void open1_50() {
        Intent intent = new Intent(this, words_1_50.class);
        startActivity(intent);
    }
    public void open51_100() {
        Intent intent = new Intent(this, words_51_100.class);
        startActivity(intent);
    }
    public void open101_150(){
        Intent intent = new Intent(this, words_101_150.class);
        startActivity(intent);
    }
    public void open151_200(){
        Intent intent = new Intent(this, words_151_200.class);
        startActivity(intent);
    }
    public void open201_250(){
        Intent intent = new Intent(this, words_201_250.class);
        startActivity(intent);
    }
    public void open251_300(){
        Intent intent = new Intent(this, words_251_300.class);
        startActivity(intent);
    }
    public void open301_350(){
        Intent intent = new Intent(this, words_301_350.class);
        startActivity(intent);
    }
    public void open351_400(){
        Intent intent = new Intent(this, words_351_400.class);
        startActivity(intent);
    }
    public void open401_450(){
        Intent intent = new Intent(this, words_401_450.class);
        startActivity(intent);
    }
    public void open451_500(){
        Intent intent = new Intent(this, words_451_500.class);
        startActivity(intent);
    }
    public void open501_550(){
        Intent intent = new Intent(this, words_501_550.class);
        startActivity(intent);
    }
    public void open551_600(){
        Intent intent = new Intent(this, words_551_600.class);
        startActivity(intent);
    }
}