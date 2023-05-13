/* About app:
The applications allows you to learn Norwegian by learning vocabulary,
replacing paper flashcards with electronic flashcards.
Currently, the application has over 600 words in Polish and Norwegian.
Rafal/ReFZero 2023
*/

//Application input class.
//Contains the main menu.
package com.example.aplikacjafiszki.Activities;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacjafiszki.R;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout constraintLayout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        //Buttons
        Button bWords = findViewById(R.id.bWords);
        Button bAbout = findViewById(R.id.bAbout);
        Button bExit = findViewById(R.id.bExit);

        bWords.setOnClickListener(this);
        bAbout.setOnClickListener(this);
        bExit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bWords:
                Intent intent = new Intent(this, Menu.class);
                startActivity(intent);
                break;
            case R.id.bAbout:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.bExit:
                finish();
                System.exit(0);
                break;
        }
    }
}
