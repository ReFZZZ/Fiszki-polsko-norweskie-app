package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_401_450 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","poniedziałek","mandag"},{"2","wtorek","tirsdag"},{"3","środa","onsdag"},{"4","czwartek","torsdag"},{"5","piątek","fredag"},{"6","sobota","lørdag"},{"7","niedziela","søndag"},{"8","rok","et år"},{"9","miesiąc","en måned"}, {"10","dzień","en dag"},
            {"11","noc","ei natt"},{"12","godzina","en time"},{"13","minuta","et minutt"},{"14","zawsze","alltid"},{"15","codziennie","hver dag"},{"16","zazwyczaj","vanligvis"},{"17","często","ofte"},{"18","czasami","av og till / iblant"},{"19","rzadko","sjelden"},{"20","nigdy","aldri"},
            {"21","dzisiaj","i dag"},{"22","wczoraj","i går"},{"23","jutro","i morgen"},{"24","w tym roku","dette året"},{"25","w zeszłym / przyszłym roku","i fjor / neste år"},{"26","w tym miesiącu","denne månaden"},{"27","Która jest godzina?","Hvor mye er klokka?"},{"28","Jest 10","Klokka er ti / Den er ti "},{"29","rano","om morgen"},{"30","wieczorem / dziś wieczorem","om kvelden / i klveld"},
            {"31","w środku dnia / w południe","midt på dagen"},{"32","po południu","om ettermiddagen"},{"33","data","en dato"},{"34","styczeń","januar"},{"35","luty","februar"},{"36","marzec","mars"},{"37","kwiecień","april"},{"38","maj","mai"},{"39","czerwiec","juni"},{"40","lipiec","juli"},
            {"41","sierpień","august"},{"42","wrzesień","september"},{"43","pażdziernik","oktober"},{"44","listopad","november"},{"45","grudzień","desember"},{"46","urodziny","en bursdag"},{"47","imieniny","en navnedag"},{"48","Boże Narodzenie","Jul"},{"49","Sylwester","Nyttårsaften"},{"50","Wielkanoc","Påske"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();

    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =400;
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
        view.setBackgroundResource(R.drawable.gradient_grey);
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
                view.setBackgroundResource(R.drawable.gradient_grey);

            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        b_obroc =(Button) findViewById(R.id.bChangeText);
        b_obroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numer_fiszki.setText(zwrocNumerFiszki());
                cutString= tablica[random][2].substring(0,3);
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
