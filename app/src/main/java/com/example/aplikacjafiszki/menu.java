package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu extends AppCompatActivity {
private Button b_1_100;
private Button b_101_200;
private Button b_201_300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        b_1_100 = (Button) findViewById(R.id.b_1_100);
        b_1_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open1_100();
            }
        });

        b_101_200 =(Button) findViewById(R.id.b_101_200);
        b_101_200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open101_200();
            }
        });

        b_201_300 = (Button) findViewById(R.id.b_201_300);
        b_201_300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open201_300();
            }
        });
    }
    public void open1_100() {
        Intent intent = new Intent(this, nauka_1_100.class);
        startActivity(intent);
    }

    public void open101_200() {
        Intent intent = new Intent(this, nauka_101_200.class);
        startActivity(intent);
    }

  public void open201_300(){
        Intent intent = new Intent(this, nauka_201_300.class);
        startActivity(intent);
    }
}