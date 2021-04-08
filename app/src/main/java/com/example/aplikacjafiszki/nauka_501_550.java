package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_501_550 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","zdrowie","ei helse"},{"2","kasa","ei kasse"},{"3","mysz","ei mus"},{"4","śmieci","ei soppel"},{"5","nożyczki","ei saks"},{"6","kot","ei katt"},{"7","strona","ei side"},{"8","książka","ei bok"},{"9","gazeta","ei avis"}, {"10","noc","ei natt"},
            {"11","ciasto","ei kake"},{"12","zegar","ei klokke"},{"13","drzwi","ei dør"},{"14","klase","ei klasse"},{"15","włosy","et hår"},{"16","salon","ei stue"},{"17","prom","ei ferje"},{"18","wóz","ei vogn"},{"19","mazak, pisak","en tusj"},{"20","most","en bro"},
            {"21","drewno","et tre"},{"22","serce","et hjerte"},{"23","ucho","et øre"},{"24","adres","ei adresse"},{"25","język","ei tunge"},{"26","regał","ei hylle"},{"27","ciocia","ei tante"},{"28","port","ei havn"},{"29","pociąg","et tog"},{"30","samolot","et fly"},
            {"31","telewizor","en tv-apparat"},{"32","twarz","et ansikt"},{"33","stacja","en stasjon"},{"34","lampa","ei lampe"},{"35","głowa","et hode"},{"36","ząb","ei tann"},{"37","szyja, gardło","en hals"},{"38","podłoga","et gulv"},{"39","pokój","et rom"},{"40","pokój dziecięcy","et barnerom"},
            {"41","kuchnia","ei kjøkken"},{"42","dom","et hjem"},{"43","łazienka","et bad"},{"44","toaleta","et toalett"},{"45","piwo","et øl"},{"46","statek","et skip"},{"47","żona","ei kone"},{"48","długopis","en penn"},{"49","fotel","en lanestol"},{"50","oczywiście","selvfølgelig"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();

    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =500;
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
