package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_51_100 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","ja","jeg"},{"2","ty","du "},{"3","on","han"},{"4","ona","hun"},{"5","ono","det"},{"6","on, ona","den"},{"7","my","vi "},{"8","wy","dere"},{"9","oni, one","de "}, {"10","mnie, mi, mną","meg"},
            {"11","ciebie, ci, cię, tobie, tobą","deg"},{"12","jego, jemu, nim","ham, han"},{"13","jej, niej, ją, nią","henne"},{"14","je, jego, jemu, nim","det "},{"15","jego, jemu, nim, jej, niej, ją, nią","den"},{"16","nas, nam, nami","oss"},{"17","was, wam, wami","dere"},{"18","ich, im, nim, nich","dem"},{"19","kto?","hvem?"},{"20","co?","hva?"},
            {"21","który?, jaki?","hvilken?"},{"22","czyj?","hvem sin?"},{"23","mój","min"},{"24","twój","din"},{"25","jego","hans"},{"26","jej","hannes"},{"27","jego, jej","dens"},{"28","jego","dets"},{"29","nasz","vår"},{"30","wasz","deres"},
            {"31","ich","d,eres"},{"32","moja","mi "},{"33","twoja","di"},{"34","nasza","vår"},{"35","moje","mitt"},{"36","twoje","ditt"},{"37","nasze","vårt"},{"38","moi, moje","mine"},{"39","twoi, twoje","dine"},{"40","nasi, nasze","våre"},
            {"41","swój","sin"},{"42","swoja","si "},{"43","swoje","sitt"},{"44","swoi, swoje","sine"},{"45","gdzie?","hvor?"},{"46","kiedy?","når?"},{"47","jak?, jaki?, jaka?, w jaki sposób?","hvordan?"},{"48","który?, która?, które?, jaki?, jaka?, jakie?","hvilken?"},{"49","dlaczego?","hvorfor?"},{"50","pytać","spørre"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;


    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =50;
    private int nrFiszkiPoDodaniu;

    private String numerFiszki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauka_fiszki);

        message =(TextView) findViewById(R.id.tvMessage);
        numer_fiszki=(TextView) findViewById(R.id.numer_fiszki);

        message.setText(tablica[random][1]);

        //ZWIEKSZENIE NUMERU FISZKI POPRZEZ DODANIE SETEK, ZAMIANA STRING NA INT -> DODANIE SETEK -> ZAMIANA INT NA STRING
        numer_fiszki.setText(zwrocNumerFiszki());

        view  = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.standard);
        // PRZYCISK "DALEJ"
        b_nastepna=(Button) findViewById(R.id.b_nastepna);
        b_nastepna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer aktualna_losowa =random;
                flag =1;
                // PĘTLA UNIEMOŻLIWIAJĄCA POWTARZANIE SIĘ FISZEK
                // -->
                while(aktualna_losowa==random)
                {
                    random = rand.nextInt(50);
                }
                // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tablica[random][1]);
                numer_fiszki.setText(zwrocNumerFiszki());
                view.setBackgroundResource(R.color.standard);

            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        b_obroc =(Button) findViewById(R.id.bChangeText);
        b_obroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numer_fiszki.setText(zwrocNumerFiszki());

                // SPRAWDZENIE I ZMIANA FLAGI. ZMIANA JEZYKA FISZKI
                switch(flag) {
                    case 0:   message.setText(tablica[random][1]);flag =1;
                        break;
                    case 1:   message.setText(tablica[random][2]);flag =0;
                        break;
                }
            }
        });
        //<--PRZYCISK ZMIANY JEZYKA FISZKI
    }
    private String zwrocNumerFiszki(){
        nrFiszkiInt = Integer.parseInt(tablica[random][0]);
        nrFiszkiPoDodaniu = nrFiszkiInt + przesuniecie;
        numerFiszki = String.valueOf(nrFiszkiPoDodaniu);
        return numerFiszki;
    }
}
