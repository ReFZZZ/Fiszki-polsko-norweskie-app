package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_polski extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    public String[][] tablica = {
            {"1","komin","a chimney"},{"2","mąka","flour"},{"3","wspaniały","gorgeous"},{"4","haczyk","a hook"},{"5","nożyczki","scissors"},{"6","gawędzić","to chat"},{"7","projektant","a designer"},{"8","osobowość","personality"},{"9","krzyczeć","to shout"}, {"10","komplet","a set"},
            {"11","chusta","a scarf"},{"12","cyrk","a circus"},{"13","wątpić","to doubt"},{"14","proszek","powder"},{"15","cieżarówka","a lorry"},{"16","autostrada","a motorway"},{"17","tajemniczy ","mysterious"},{"18","wyobrażnia","imagination"},{"19","indyk","a turkey"},{"20","olbrzym","a giant"},
            {"21","odpady","waste"},{"22","obolały","sore"},{"23","opieka","care"},{"24","fryzjer","a hairdresser"},{"25","pakować","to wrap"},{"26","reklama","an advertisement"},{"27","polować","to hunt"},{"28","pionowy","vertical"},{"29","owad","an insect"},{"30","zespół(muzyczny)","a band"},
            {"31","uprzejmy","polite"},{"32","przeszkadzać","to disturb"},{"33","dach","a roof"},{"34","język","a tongue"},{"35","mózg","a brain"},{"36","śpieszyć się","to hurry"},{"37","kontynuować","to continue"},{"38","przyszłość","the future"},{"39","garaż","a garage"},{"40","brama","a gate"},
            {"41","schody","stairs"},{"42","sąsiad","a neighbour"},{"43","klaskać","to clap"},{"44","ekologia","ecology"},{"45","środowisko","the environment"},{"46","gdzieś","somewhere"},{"47","wszędzie","everywhere"},{"48","importować","to import"},{"49","zabezpieczać","to secure"},{"50","zdanie","a sentence"},
            {"51","zaznaczać","to mark"},{"52","nieznajomy","a stranger"},{"53","kradzież kieszonkowa","pickpocketing"},{"54","kwota","an amount"},{"55","płaski","flat"},{"56","wiązać","to bind"},{"57","zgadywać","to guess"},{"58","przecinek","a comma"},{"59","wracać","return"},{"60","żałować","to regret"},
            {"61","uciekać","to escape"},{"62","umysł","a mind"},{"63","ćwiczyć","to practise"},{"64","papuga","a parrot"},{"65","odpowiedzialny","responsible"},{"66","pogląd","a view"},{"67","szczególny","particular"},{"68","ratować","to rescue"},{"69","ratownik","a rescuer"},{"70","sąd","a court"},
            {"71","szkodzić","to harm"},{"72","szkodliwy","harmful"},{"73","wodospad","a waterfall"},{"74","namiot","a tent"},{"75","napiwek","a tip"},{"76","płatki zbożowe","a cereal"},{"77","witać","to greet"},{"78","możliwość","a possibility"},{"79","zazdrość","jealousy"},{"80","przemówienie","a speech"},
            {"81","wiarygodny","credible"},{"82","ruchomy","mobile"},{"83","ktoś","someone"},{"84","wszyscy","everyone"},{"85","skupienie","attention"},{"86","rzeczywistość","reality"},{"87","zgadzać się","to agree"},{"88","drugi","the second"},{"89","przysięgać","to swear"},{"90","podwajać","to double"},
            {"91","prawda","the truth"},{"92","opinia","an opinion"},{"93","dyskutować","to discuss"},{"94","dąb","an oak"},{"95","przedmieście","a suburb"},{"96","kaptur","a hood"},{"97","rękawiczka","a glove"},{"98","ziemia","the earth"},{"99","unikać","to avoid"},{"100","statek kosmiczny","a spaceship"},
    };
    //FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- INNY
    private Integer flag =1;
    private Integer losowa= rand.nextInt(100) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauka_polski);

        message =(TextView) findViewById(R.id.tvMessage);
        numer_fiszki=(TextView) findViewById(R.id.numer_fiszki);

        message.setText(tablica[losowa][1]);
        numer_fiszki.setText(tablica[losowa][0]);

        // PRZYCISK "DALEJ"
        b_nastepna=(Button) findViewById(R.id.b_nastepna);
        b_nastepna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer aktualna_losowa =losowa;
                flag =1;
                // PĘTLA UNIEMOŻLIWIAJĄCA POWTARZANIE SIĘ FISZEK
                // -->
               while(aktualna_losowa==losowa)
                    {
                    losowa = rand.nextInt(100);
                    }
               // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tablica[losowa][1]);
                numer_fiszki.setText(tablica[losowa][0]);
            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        b_obroc =(Button) findViewById(R.id.bChangeText);
        b_obroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numer_fiszki.setText(tablica[losowa][0]);
                switch(flag) {
                    case 0:   message.setText(tablica[losowa][1]);flag =1; break;
                    case 1:   message.setText(tablica[losowa][2]);flag =0; break;
                }
            }
        });
        //<--PRZYCISK ZMIANY JEZYKA FISZKI
    }
}
