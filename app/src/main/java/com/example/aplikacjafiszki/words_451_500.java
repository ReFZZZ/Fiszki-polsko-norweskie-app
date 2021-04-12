package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class words_451_500 extends AppCompatActivity {
    private Random rand= new Random();
    private Button bReverse;
    private Button bNext;
    private TextView message;
    private TextView wordNumber;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tab = {
            {"1","świeży","fersk"},{"2","inteligentny","inteligent"},{"3","blond","lys"},{"4","późno","sent"},{"5","surowy, srogi","streng"},{"6","cichy","stille"},{"7","główny","hoved-"},{"8","ładny","fin"},{"9","taki sam","samme"}, {"10","wysoki","høy"},
            {"11","zajęty","opptatt"},{"12","młody","ung"},{"13","twardy","hard"},{"14","szybko","fort"},{"15","stary","gammel"},{"16","wolny(o miejscu)","ledig"},{"17","nowy","ny "},{"18","gruby","tykk"},{"19","miekki","myk"},{"20","niski","lav"},
            {"21","ważny","viktig"},{"22","możliwy","mulig"},{"23","przygotowany","forberedt"},{"24","nowoczesny","moderne"},{"25","cierpliwy","tålmodig"},{"26","miły","snill"},{"27","przyjazny","vennlig"},{"28","sympatyczny","sympatisk"},{"29","leniwy","lat"},{"30","pilny","flink"},
            {"31","głupi","dum"},{"32","mądry","klok"},{"33","trudny","vanskelig"},{"34","długo","lenge"},{"35","pyszny, doskonały","nydelig"},{"36","gorzki","bitter"},{"37","słodki","søt"},{"38","głośny","høy"},{"39","razem","sammen"},{"40","następny","neste"},
            {"41","bez","uten"},{"42","powoli","sakte"},{"43","łatwy","lett"},{"44","wcześnie","tidlig"},{"45","całkiem","ganske"},{"46","chudy","tynn"},{"47","mały, mała, małe","liten, lita, lite"},{"48","czasami","av og til"},{"49","już","allerede"},{"50","dla","til"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();
    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int numberWordInt;
    private int shift =450;
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
