package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class words_551_600 extends AppCompatActivity {
    private Random rand= new Random();
    private Button bReverse;
    private Button bNext;
    private TextView message;
    private TextView wordNumber;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tab = {
            {"1","brzuch","en mage"},{"2","skóra","en hud"},{"3","winda","en heis"},{"4","mieszkanie","en leilighet"},{"5","sofa, kanapa","en sofa"},{"6","korytarz","en gang"},{"7","łokieć","en albue"},{"8","łożko","ei seng"},{"9","chleb","et brød"}, {"10","problem","et problem"},
            {"11","prezent","en gave"},{"12","prawda","sannhet"},{"13","stolica","en hovedstad"},{"14","budynek","en bygning"},{"15","zeszyt","et hefte"},{"16","dywan, koc","et teppe"},{"17","radio","en radio"},{"18","wiadomość","en nyhet"},{"19","komputer","en datamaskin"},{"20","przystanek","en holdeplass"},
            {"21","szafa","et skap"},{"22","okno","et vindu"},{"23","lusto","et speil"},{"24","masło","et smør"},{"25","jajko","et egg"},{"26","woda","et vann"},{"27","drzewo","et tre"},{"28","list","et brev"},{"29","tort","et bløtkake"},{"30","tablica","ei tavle"},
            {"31","zadanie domowe","ei lekse"},{"32","ulica","ei gate"},{"33","patelnia","ei stekepanne"},{"34","czarownica","ei heks"},{"35","kosciół","ei kirke"},{"36","czas wolny","ei fritid"},{"37","dziewczyna","ei jente"},{"38","przewodnik","ei reisebok"},{"39","Ziemia","ei jord"},{"40","ręka","en hånd"},
            {"41","czas","ei tid"},{"42","kiełbasa","ei pølse"},{"43","zawód","et yrke"},{"44","jedzenie","en mat"},{"45","niż, od","enn"},{"46","stopa","en fot"},{"47","palec","en finger"},{"48","krzesło","en stol"},{"49","moment, chwila","en øyeblikk"},{"50","tramwaj","en trikk"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();
    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int numberWordInt;
    private int shift =550;
    private int wordNumberAfterAddition;
    private String wordNumberString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        message =(TextView) findViewById(R.id.tvMessage);
        wordNumber =(TextView) findViewById(R.id.word_number);

        message.setText(tab[random][1]);

        //ZWIEKSZENIE NUMERU FISZKI POPRZEZ DODANIE SETEK, ZAMIANA STRING NA INT -> DODANIE SETEK -> ZAMIANA INT NA STRING
        wordNumber.setText(returnWordNumber());

        view  = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.gradient_grey);
        // PRZYCISK "DALEJ"
        bNext =(Button) findViewById(R.id.b_next);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentRandom =random;
                flag =1;
                // PĘTLA UNIEMOŻLIWIAJĄCA POWTARZANIE SIĘ FISZEK
                // -->
                while(currentRandom==random)
                {
                    random = rand.nextInt(50);
                }
                // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tab[random][1]);
                wordNumber.setText(returnWordNumber());
                view.setBackgroundResource(R.drawable.gradient_grey);

            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        bReverse =(Button) findViewById(R.id.b_ChangeText);
        bReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordNumber.setText(returnWordNumber());
                cutString= tab[random][2].substring(0,3);
                //SPRAWDZENIE RODZAJNIKA W JEZYKU NORWESKIM, W ZALEZNOSCI OD NIEGO ZMIENA SIE KOLOR TŁA APLIKACJI
                switch (cutString){
                    case "en " : {view.setBackgroundResource(R.drawable.gradient_blue);break;}
                    case "ei " : {view.setBackgroundResource(R.drawable.gradient_red);break;}
                    case "en/" : {view.setBackgroundResource(R.drawable.gradient_orange);break;}
                    case "et " : {view.setBackgroundResource(R.drawable.gradient_green);break;}
                    default: view.setBackgroundResource(R.drawable.gradient_grey);break;
                }
                // SPRAWDZENIE I ZMIANA FLAGI. ZMIANA JEZYKA FISZKI
                switch(flag) {
                    case 0:   message.setText(tab[random][1]);flag =1;
                        break;
                    case 1:   message.setText(tab[random][2]);flag =0;
                        break;
                }
            }
        });
        //<--PRZYCISK ZMIANY JEZYKA FISZKI
    }
    private String returnWordNumber(){
        numberWordInt = Integer.parseInt(tab[random][0]);
        wordNumberAfterAddition = numberWordInt + shift;
        wordNumberString = String.valueOf(wordNumberAfterAddition);
        return wordNumberString;
    }
}
