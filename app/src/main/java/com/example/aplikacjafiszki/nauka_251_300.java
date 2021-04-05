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
            {"1","palić papierosy, dymić","røyke / røykte / røykt"},{"2","zbierać, pozbierać","samle / samlet / samlet"},{"3","widzieć, zobaczyć","se / så / sett"},{"4","wygrać, zwyciężyć","seire / seiret / seiret "},{"5","sprzedawać","selge / solgte / solgt"},{"6","wysyłać","sende / sendte / sendt"},{"7","podpisywać","signere / signerte / signert"},{"8","siedzieć","sitte / satt / sittet"},{"9","kroić","skjære / skar / skåret"}, {"10","krzyczeć","skrike / skrek / skreket"},
            {"11","pisać","skrive / skrev / skrevet"},{"12","pchać, przesuwać","skyve / skjøv / skjøvet"},{"13","kończyć","slutte / sluttet / sluttet"},{"14","bić, uderzać","slå / slo / slått"},{"15","smakować","smake / smakte / smakt"},{"16","uśmiechać się","smile / smilte / smilt"},{"17","rozmawiać","snakke / snakket / snakket"},{"18","spać","sove / sov / sovet"},{"19","oszczędzać","spare / sparte / spart"},{"20","kopać","sparke / sparket / sparket"},
            {"21","grać","spille / spilte / spilt "},{"22","jeść","spise / spiste / spist"},{"23","biec","springe / sprang / sprunget "},{"24","pytać","spørre / spurte / spurt "},{"25","zaczynać, rozpoczynać","starte / startet / startet"},{"26","zaufać","stole på / stolte på / stolt på"},{"27","zatrzymać się, przerwać","stoppe / stoppet / stoppet"},{"28","stać","stå / sto/stod / stått "},{"29","odpowiadać","svare / svarte / svart"},{"30","pływać","svømme / svømte / svømt"},
            {"31","jeździć na rowerze","sykle / syklet / syklet"},{"32","uważać","synes / syntes / synes"},{"33","brać","ta / tok / tatt"},{"34","dziękować","takke / takket / takket"},{"35","przegrać","tape / tapte / tapt"},{"36","rysować","tegne / tegnet / tegnet "},{"37","myśleć","tenke / tenkte / tenkt "},{"38","pozwolić, zezwolić","tillate / tillot / tillatt"},{"39","spotykać","treffe / traff / truffet"},{"40","trenować","trene / trente / trent"},
            {"41","potrzebować","trenge / trengte / trengt"},{"42","przepraszać","unnskylde / unnskyldte / unnskyldt"},{"43","wskazywać","utpeke / utpekte / utpekt"},{"44","grzać","varme / varmet / varmet"},{"45","chcieć","ville / ville / villet"},{"46","wiedzieć","vite / visste / visst"},{"47","być","være / var / vært"},{"48","niszczyć, psuć","ødelegge / ødela / ødelagt"},{"49","ćwiczyć","øve / øvde / øvd"},{"50","otwierać","åpne / åpnet / åpnet"}
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
