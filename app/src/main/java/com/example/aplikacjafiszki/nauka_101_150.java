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
            {"1","polecać","anbefale / anbefaler / anbefalte / har anbefalt "},{"2","żałować","angre / angrer / angret / har angret"},{"3","pracować","arbeide / arbeider / arbeidet / har arbeidet "},{"4","kończyć, dokończyć, zakończyć","avslutte / avslutter / avsluttet / har avsluttet"},{"5","przerywać, przeszkadzać","avbryte / avbryter / avbrøt / har avbrutt"},{"6","reklamować, głosić","avertere/ averterer / averterte / har avertert "},{"7","kąpać się","bade / bader / badet / har badet"},{"8","piec","bake / baker / bakte / har bakt"},{"9","pukać, stukać, trzepać","banke / banker / banket / har banket"}, {"10","golić (seg - się)","barbere / barberer / barberte / har barbert"},
            {"11","prosić, błagać","be (om) / ber (om) / ba (om) / har bedt (om)"},{"12","ograniczać","begrense / begrenser / begrenset / har begrenset"},{"13","pojmować, rozumieć","begripe / begriper / begre(i)p / har begrepet"},{"14","rozpoczynać","begynne / begynner / begynte / har begynt"},{"15","przepraszać","beklage / beklager / beklaget / har beklaget"},{"16","potwierdzać, poświadczać","bekrefte / bekrefter / bekreftet / har bekreftet"},{"17","pokonywać","beseire / beseirer / beseiret / har beseiret"},{"18","opisywać","beskrive / beskriver / beskrev / har beskrevet"},{"19","decydować","bestemme / bestemmer / bestemte / har bestemt"},{"20","zamawiać","bestille / bestiller / bestilte / har bestilt"},
            {"21","zdać (egamin, test, itp.)","bestå / består / besto / har bestått"},{"22","odpowiadać","besvare / besvarer / besvarte / har besvart"},{"23","odwiedzać, uczęszczać","besøke / besøker / besøkte / har besøkt"},{"24","płacić","betale / betaler / betalte / har betalt "},{"25","znaczyć","bety / betyr / betydde / har betydd"},{"26","wiązać","binde / binder / bandt / har bundet"},{"27","gryźć","bite / biter / bet / har bitt"},{"28","stawać się","bli / blir / ble / har blitt"},{"29","wiać","blåse / blåser / blåste / har blåst"},{"30","mieszkać","bo / bor / bodde / har bodd"},
            {"31","łamać","brekke / brekker / brakk / har brukket"},{"32","palić (nie w odniesieniu do palenia nikotyny)","brenne / brenner / brente / har brent"},{"33","przynosić","bringe / bringer / brakte / har brakt"},{"34","pękać","briste / brister / brast / har bristet"},{"35","używać, stosować","bruke / bruker / brukte / har brukt"},{"36","troszczyć się o..., zalezeć na...","bry seg om / bryr seg om / brydde seg om / har brydd seg om"},{"37","zbić, rozbić, łamać","bryte / bryter / brøt / har brutt"},{"38","hałasować","bråke / bråker / bråket / har bråket"},{"39","oferować, zapraszać","by / byr / bydde / har bydd"},{"40","budować","bygge / bygger / bygde / har bygd"},
            {"41","nosić","bære / bærer / bar / har båret"},{"42","tańczyć","danse / danser / danset / har danset"},{"43","zakryć, przykryć, nakryć","dekke / dekker / dekket / har dekket "},{"44","spadać","dette / detter / datt / har dettet"},{"45","dyskutować","diskutere / diskuterer / diskuterte / har diskutert"},{"46","wyjeżdżać, udawać się","dra / drar / dro / har dratt"},{"47","pić","drikke / drikker / drakk / har drukket"},{"48","brać prysznic","dusje / dusjer / dusjet / har dusjet"},{"49","posiadać","eie / eier / eide/ har eid"},{"50","kochać","elske / elsker / elsket / har elsket"}
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
