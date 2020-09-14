package com.example.aplikacjafiszki;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String path = Environment.getExternalStorageDirectory().toString() + "aplikacjaFiszki/Fiszki";

    private Button b_fiszki;
    private Button b_autor;
    private Button b_wyjscie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // PRZYCISK FISZKI
        b_fiszki = (Button) findViewById(R.id.b_fiszki);
        b_fiszki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFiszki();
            }
        });

        // PRZYCISK AUTOR
        b_autor = (Button) findViewById(R.id.b_autor);
        b_autor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAutor();
            }
        });
        // PRZYCISK WYJSCIE
        b_wyjscie = (Button) findViewById(R.id.b_wyjscie);
        b_wyjscie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWyjscie();
            }
        });
    }

    public void openFiszki() {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);

    }

    public void openAutor() {
        Intent intent = new Intent(this, autor.class);
        startActivity(intent);
    }

    public void openWyjscie() {
        finish();
        System.exit(0);
    }
}
