package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_201_250 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","kierować, jechać samochodem","kjøre / kjører / kjørte / har kjørt"},{"2","ubierać (się), rozbierać (się)","kle / kler / kledde / har kledd"},{"3","zawiązać, związać, przywiązać","knytte / knytter / knyttet / har knyttet"},{"4","gotować","koke / koker / kokte / har kokt"},{"5","przyjść, pójść","komme / kommer / kom / har kommet"},{"6","kontaktować się","kontakte / kontakter / kontaktet / har kontaktet"},{"7","kłócić się","krangle / krangler / kranglet / har kranglet"},{"8","krytykować","kritisere / kritiserer / kritiserte / har kritisert"},{"9","móc, umieć","kunne / kan / kunne / har kunnet"}, {"10","ałować","kysse / kysser / kysset / har kysset"},
            {"11","pozwalać","la / lar / lot / har latt"},{"12","robić, przygotowywać","lage / lager / laget / har laget "},{"13","śmiać się","le / ler / lo / har ledd"},{"14","kłaść","legge / legger / la / har lagt"},{"15","wynajmować, wypożyczać","leie / leier / leide / har leid"},{"16","bawić się","leke / leker / lekte / har lekt"},{"17","czytać","lese / leser / leste / har lest"},{"18","szukać","lete / leter / lette / har lett"},{"19","żyć","leve / lever / levde / har levd"},{"20","leżeć","ligge / ligger / lå / har ligget"},
            {"21","lubić","like / liker / likte / har likt"},{"22","zamykać","lukke / lukker / lukket / har lukket"},{"23","pachnieć, wąchać","lukte / lukter / luktet / har luktet"},{"24","słuchać","lytte / lytter / lyttet / har lyttet"},{"25","kłamać","lyve / lyver / løy / har løyet "},{"26","uczyć","lære / lærer / lærte / har lært"},{"27","biegać","løpe / løper / løp / har løpt"},{"28","pożyczać","låne / låner / lånte / har lånt"},{"29","zamykać na klucz","låse / låser / låste / har låst"},{"30","malować","male / maler / malte / har malt "},
            {"31","mieć na myśli, uważać","mene / mener / mente / har ment"},{"32","zauważać, zaznaczać","merke / merker / merket / har merket"},{"33","gubić, tracić","miste / mister / mistet / har mistet"},{"34","spotykać","møte / møter / møtte / har møtt"},{"35","musieć","måtte / må / måtte / har måttet"},{"36","przelać , przenieść","overføre/ overfører / overførte / har overført"},{"37","pakować","pakke / pakker / pakket / har pakket"},{"38","parkować","parkere / parkerer / parkerte / har parkert"},{"39","opiekować się, dbać","passe / passer / passet / har passet"},{"40","wskazywać","peke / peker / pekte / har pekt "},
            {"41","planować","planlegge / planlegger / planla / har planlagt"},{"42","rozmawiać","prate / prater / pratet / har pratet "},{"43","próbować","prøve / prøver / prøvde / har prøvd"},{"44","czyścić","pusse / pusser / pusset / har pusset"},{"45","oddychać","puste / puster / pustet / har pustet"},{"46","kłaść","putte / putter / puttet / har puttet"},{"47","czyścić","rense / renser / renset / har renset"},{"48","naprawiać, reperować","reparere / reparerer / reparerte / har reparert"},{"49","jeździć konno","ri / rir / red / har ridd"},{"50","sprzątać","rydde / rydder / ryddet / har ryddet"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer    random= rand.nextInt(50) ;
    private String cutString = new String();
    private int nrFiszkiInt;
    private int przesuniecie =200;
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
                cutString= tablica[random][2].substring(0,3);
                //SPRAWDZENIE RODZAJNIKA W JEZYKU NORWESKIM, W ZALEZNOSCI OD NIEGO ZMIENA SIE KOLOR TŁA APLIKACJI
                switch (cutString){
                    case "en " : {view.setBackgroundResource(R.color.blue);break;}
                    case "ei " : {view.setBackgroundResource(R.color.red);break;}
                    case "en/" : {view.setBackgroundResource(R.color.yellow);break;}
                    case "et " : {view.setBackgroundResource(R.color.green);break;}
                    default: view.setBackgroundResource(R.color.standard);break;
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
