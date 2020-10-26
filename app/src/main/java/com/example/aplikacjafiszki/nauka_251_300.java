package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_251_300 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","palić papierosy, dymić","røyke / røyker / røykte / har røykt"},{"2","zbierać, pozbierać","samle / samler / samlet / har samlet"},{"3","widzieć, zobaczyć","se / ser / så / har sett"},{"4","wygrać, zwyciężyć","seire / seirer / seiret / har seiret "},{"5","sprzedawać","selge / selger / solgte / har solgt"},{"6","wysyłać","sende / sender / sendte / har sendt"},{"7","podpisywać","signere / signerer / signerte / har signert"},{"8","siedzieć","sitte / sitter / satt / har sittet"},{"9","kroić","skjære / skjærer / skar / har skåret"}, {"10","krzyczeć","skrike / skriker / skrek / har skreket"},
            {"11","pisać","skrive / skriver / skrev / har skrevet"},{"12","pchać, przesuwać","skyve / skyver / skjøv / har skjøvet"},{"13","kończyć","slutte / slutter / sluttet / har sluttet"},{"14","bić, uderzać","slå / slår / slo / har slått"},{"15","smakować","smake / smaker / smakte / har smakt"},{"16","uśmiechać się","smile / smiler / smilte / har smilt"},{"17","rozmawiać","snakke / snakker / snakket / har snakket"},{"18","spać","sove / sover / sov / har sovet"},{"19","oszczędzać","spare / sparer / sparte / har spart"},{"20","kopać","sparke / sparker / sparket / har sparket"},
            {"21","grać","spille / spiller / spilte / har spilt "},{"22","jeść","spise / spiser / spiste / har spist"},{"23","biec","springe / springer / sprang / har sprunget "},{"24","pytać","spørre / spør / spurte / har spurt "},{"25","zaczynać, rozpoczynać","starte / starter / startet / har startet"},{"26","zaufać","stole på / stoler på / stolte på / har stolt på"},{"27","zatrzymać się, przerwać","stoppe / stopper / stoppet / har stoppet"},{"28","stać","stå / står / sto/stod / har stått "},{"29","odpowiadać","svare / svarer / svarte / har svart"},{"30","pływać","svømme / svømmer / svømte / har svømt"},
            {"31","jeździć na rowerze","sykle / sykler / syklet / har syklet"},{"32","uważać","synes / synes / syntes / har synes"},{"33","brać","ta / tar / tok / har tatt"},{"34","dziękować","takke / takker / takket / har takket"},{"35","przegrać","tape / taper / tapte / har tapt"},{"36","rysować","tegne / tegner / tegnet / har tegnet "},{"37","myśleć","tenke / tenker / tenkte / har tenkt "},{"38","pozwolić, zezwolić","tillate / tillater / tillot / har tillatt"},{"39","spotykać","treffe / treffer / traff / har truffet"},{"40","trenować","trene / trener / trente / har trent"},
            {"41","potrzebować","trenge / trenger / trengte / har trengt"},{"42","przepraszać","unnskylde / unnskylder / unnskyldte / har unnskyldt"},{"43","wskazywać","utpeke / utpeker / utpekte / har utpekt"},{"44","grzać","varme / varmer / varmet / har varmet"},{"45","chcieć","ville / vil / ville / har villet"},{"46","wiedzieć","vite / vet / visste / har visst"},{"47","być","være / er / var / har vært"},{"48","niszczyć, psuć","ødelegge / ødelegger / ødela / har ødelagt"},{"49","ćwiczyć","øve / øver / øvde / har øvd"},{"50","otwierać","åpne / åpner / åpnet / har åpnet"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();

    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =250;
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
