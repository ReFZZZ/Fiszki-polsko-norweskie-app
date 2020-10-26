package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_151_200 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","kończyć","ende / ender / endte / har endt"},{"2","jeść","ete / eter / åt / har ett "},{"3","upaść, spadać","falle / faller / falt / har falt "},{"4","znajdować, znaleźć","finne / finner / fant / har funnet"},{"5","usunąć","fjerne / fjerner / fjernet / har fjernet"},{"6","latać","fly / flyr / fløy / har fløyet"},{"7","przesunąć, przeprowadzić","flytte / flytter / flyttet / har flyttet"},{"8","zmienić","forandre / forandrer/ forandret / har forandret"},{"9","przygotować","forberede / forbereder / forberedte / har forberedt"}, {"10","zdarzyć się, mieć miejsce","foregå / foregår / foregikk / har foregått"},
            {"11","proponować","foreslå / foreslår / foreslo / har foreslått"},{"12","woleć","foretrekke / foretrekker / foretrakk / har foretrukket"},{"13","wytłumaczyć, wyjaśnić","forklare / forklarer / forklarte / har forklart"},{"14","zakłócać, przeszkadzać","forstyrre / forstyrrer / forstyrret / har forstyrret"},{"15","rozumieć","forstå / forstår / forstod / har forstått"},{"16","spieszyć się","forte seg / forter seg / fortet seg / har fortet seg"},{"17","fotografować","fotografere / fotograferer / fotograferte / har fotografert"},{"18","bać się, obawiać się","frykte / frykter / fryktet / har fryktet"},{"19","marznąć, zamarzać","fryse / fryser / frøs / har frosset"},{"20","wypełniać","fylle ut / fyller ut / fylte ut / har fylt ut "},
            {"21","czuć (seg - się)","føle / føler / følte / har følt "},{"22","dostawać","få / får / fikk / har fått"},{"23","dawać","gi / gir / gav / har gitt"},{"24","powtarzać","gjenta / gjentar / gjentok / har gjentatt "},{"25","robić","gjøre / gjør / gjorde / har gjort"},{"26","zapominać","glemme / glemmer / glemte / har glemt"},{"27","kopać","grave / graver / gravde / har gravd"},{"28","chwytać, łapać","gripe / griper / grep / har grepet"},{"29","iść","gå / går / gikk / har gått"},{"30","mieć","ha / har / hadde / har hatt"},
            {"31","robić zakupy","handle / handler / handlet / har handlet"},{"32","wisieć","henge / henger / hengte / har hengt"},{"33","przynieść","hente / henter / hentet / har hentet"},{"34","nazywać się","hete / heter / hette / har hett"},{"35","pozdrawiać, witać","hilse / hilser / hilste / har hilst"},{"36","blokować, tarasować","hindre / hindrer / hindret / har hindret"},{"37","pomagać","hjelpe / hjelper / hjalp / har hjulpet"},{"38","trzymać","holde / holder / holdt / har holdt"},{"39","skakać","hoppe / hopper / hoppet / har hoppet"},{"40","pamiętać","huske / husker / husket / har husket"},
            {"41","słyszeć","høre / hører / hørte / har hørt"},{"42","mieć nadzieję","håpe / håper / håpet / har håpet"},{"43","interesować się","interessere / interesserer / innteresserte / har innteressert"},{"44","pracować","jobbe / jobber / jobbet / har jobbet"},{"45","biegać, uprawiać jogging","jogge / jogger / jogget / har jogget"},{"46","nazywać","kalle / kaller / kalte / har kalt"},{"47","rzucać","kaste / kaster / kastet / har kastet"},{"48","patrzeć, zerkać","kikke / kikker / kikket / har kikket"},{"49","znać","kjenne / kjenner / kjente / har kjent"},{"50","kupować","kjøpe / kjøper / kjøpte / har kjøpt"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer    random= rand.nextInt(50) ;
    private String cutString = new String();
    private int nrFiszkiInt;
    private int przesuniecie =150;
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
