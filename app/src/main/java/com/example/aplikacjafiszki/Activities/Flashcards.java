/*
Activity class for flashcards.
Deserialize JSON file to 'Word' class.
Supports language change between polish and norwegian.
Depending on the article in Norwegian, the background color changes.
*/
package com.example.aplikacjafiszki.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikacjafiszki.DataClasses.Word;
import com.example.aplikacjafiszki.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Flashcards extends AppCompatActivity {

    private Random rand = new Random();
    private Integer random = rand.nextInt(50);
    private List<Word> wordList = new ArrayList<>();
    private Boolean isPolish = true;
    private String cutString;
    private ObjectMapper mapper = new ObjectMapper();
    private String fileWithWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.gradient_grey);

        //Buttons
        Button bNext = findViewById(R.id.b_next);
        Button bReverse = findViewById(R.id.b_ChangeText);

        //TextViews
        TextView message = findViewById(R.id.tvMessage);
        TextView wordNumber = findViewById(R.id.word_number);

        //Create List<Word> from specific file
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            fileWithWords = extras.getString("fileWithWords");
            try {
                InputStream inputStream = getAssets().open(fileWithWords);
                wordList = Arrays.asList(mapper.readValue(inputStream, Word[].class));
            } catch (IOException e) {
                throw new RuntimeException("File not exist!");
            }
        }

        //Setting the initialization texts
        message.setText(wordList.get(random).getPolish());
        wordNumber.setText(String.valueOf(wordList.get(random).getId()));

        //Setting the behavior of the buttons
        //  Button 'Next'
        bNext.setOnClickListener(v ->{
            isPolish = true;
            Integer currentRandom = random;
            while (currentRandom.equals(random)) {
                random = rand.nextInt(50);
            }
            message.setText(wordList.get(random).getPolish());
            wordNumber.setText(String.valueOf(wordList.get(random).getId()));
            view.setBackgroundResource(R.drawable.gradient_grey);
        });

        //  Button 'Reverse'
        bReverse.setOnClickListener(v -> {
            wordNumber.setText(String.valueOf(wordList.get(random).getId()));
            //Condition checks the length of the word,
            //if it is less than three the substring() method will throw an exception
            if (wordList.get(random).getNorwegian().length() > 3) {
                cutString = wordList.get(random).getNorwegian().substring(0, 3);
                //Checking the article in Norwegian.
                //The background color changes depending on what it is
                switch (cutString) {
                    case "en ": {
                        view.setBackgroundResource(R.drawable.gradient_blue);
                        break;
                    }
                    case "ei ": {
                        view.setBackgroundResource(R.drawable.gradient_red);
                        break;
                    }
                    case "en/": {
                        view.setBackgroundResource(R.drawable.gradient_orange);
                        break;
                    }
                    case "et ": {
                        view.setBackgroundResource(R.drawable.gradient_green);
                        break;
                    }
                    default:
                        view.setBackgroundResource(R.drawable.gradient_grey);
                        break;
                }
            }
            //Rotating/changing the flashcard language
            if (!isPolish) {
                message.setText(wordList.get(random).getPolish());
                isPolish = true;
            } else {
                message.setText(wordList.get(random).getNorwegian());
                isPolish = false;
            }
        });
    }
}