package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_101_150 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","polecać","anbefale / anbefalte / anbefalt "},{"2","żałować","angre / angret / angret"},{"3","pracować","arbeide / arbeidet / arbeidet "},{"4","kończyć, dokończyć, zakończyć","avslutte / avsluttet / avsluttet"},{"5","przerywać, przeszkadzać","avbryte / avbrøt / avbrutt"},{"6","reklamować, głosić","avertere / averterte / avertert "},{"7","kąpać się","bade / badet / badet"},{"8","piec","bake / bakte / bakt"},{"9","pukać, stukać, trzepać","banke / banket / banket"}, {"10","golić (seg - się)","barbere / barberte / barbert"},
            {"11","prosić, błagać","be (om) / ba (om) / bedt (om)"},{"12","ograniczać","begrense / begrenset / begrenset"},{"13","pojmować, rozumieć","begripe / begre(i)p / begrepet"},{"14","rozpoczynać","begynne / begynte / begynt"},{"15","przepraszać","beklage / beklaget / beklaget"},{"16","potwierdzać, poświadczać","bekrefte / bekreftet / bekreftet"},{"17","pokonywać","beseire / beseiret / beseiret"},{"18","opisywać","beskrive / beskrev / beskrevet"},{"19","decydować","bestemme / bestemte / bestemt"},{"20","zamawiać","bestille / bestilte / bestilt"},
            {"21","zdać (egamin, test, itp.)","bestå / besto / bestått"},{"22","odpowiadać","besvare / besvarte / besvart"},{"23","odwiedzać, uczęszczać","besøke / besøkte / besøkt"},{"24","płacić","betale / betalte / betalt "},{"25","znaczyć","bety / betydde / betydd"},{"26","wiązać","binde / bandt / bundet"},{"27","gryźć","bite / bet / bitt"},{"28","stawać się","bli / ble / blitt"},{"29","wiać","blåse / blåste / blåst"},{"30","mieszkać","bo / bodde / bodd"},
            {"31","łamać","brekke / brakk / brukket"},{"32","palić (nie w odniesieniu do palenia nikotyny)","brenne / brente / brent"},{"33","przynosić","bringe / brakte / brakt"},{"34","pękać","briste / brast / bristet"},{"35","używać, stosować","bruke / brukte / brukt"},{"36","troszczyć się o..., zalezeć na...","bry seg om / brydde seg om / brydd seg om"},{"37","zbić, rozbić, łamać","bryte / brøt / brutt"},{"38","hałasować","bråke / bråket / bråket"},{"39","oferować, zapraszać","by / bydde / bydd"},{"40","budować","bygge / bygde / bygd"},
            {"41","nosić","bære / bar / båret"},{"42","tańczyć","danse / danset / danset"},{"43","zakryć, przykryć, nakryć","dekke / dekket / dekket "},{"44","spadać","dette / datt / dettet"},{"45","dyskutować","diskutere / diskuterte / diskutert"},{"46","wyjeżdżać, udawać się","dra / dro / dratt"},{"47","pić","drikke / drakk / drukket"},{"48","brać prysznic","dusje / dusjet / dusjet"},{"49","posiadać","eie / eide / eid"},{"50","kochać","elske / elsket / elsket"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer    random= rand.nextInt(50) ;
    private String cutString = new String();
    private int nrFiszkiInt;
    private int przesuniecie =100;
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
