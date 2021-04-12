package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class words_151_200 extends AppCompatActivity {
    private Random rand= new Random();
    private Button bReverse;
    private Button bNext;
    private TextView message;
    private TextView wordNumber;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tab = {
            {"1","kończyć","ende / endte / endt"},{"2","jeść","ete / åt / ett "},{"3","upaść, spadać","falle / falt / falt "},{"4","znajdować, znaleźć","finne / fant / funnet"},{"5","usunąć","fjerne / fjernet / fjernet"},{"6","latać","fly / fløy / fløyet"},{"7","przesunąć, przeprowadzić","flytte / flyttet / flyttet"},{"8","zmienić","forandre / forandret / forandret"},{"9","przygotować","forberede / forberedte / forberedt"}, {"10","zdarzyć się, mieć miejsce","foregå / foregikk / foregått"},
            {"11","proponować","foreslå / foreslo / foreslått"},{"12","woleć","foretrekke / foretrakk / foretrukket"},{"13","wytłumaczyć, wyjaśnić","forklare / forklarte / forklart"},{"14","zakłócać, przeszkadzać","forstyrre / forstyrret / forstyrret"},{"15","rozumieć","forstå / forstod / forstått"},{"16","spieszyć się","forte seg / fortet seg / fortet seg"},{"17","fotografować","fotografere / fotograferte / fotografert"},{"18","bać się, obawiać się","frykte / fryktet / fryktet"},{"19","marznąć, zamarzać","fryse / frøs / frosset"},{"20","wypełniać","fylle ut / fylte ut / fylt ut "},
            {"21","czuć (seg - się)","føle / følte / følt "},{"22","dostawać","få / fikk / fått"},{"23","dawać","gi / gav / gitt"},{"24","powtarzać","gjenta / gjentok / gjentatt "},{"25","robić","gjøre / gjør / gjorde / gjort"},{"26","zapominać","glemme / glemte / glemt"},{"27","kopać","grave / gravde / gravd"},{"28","chwytać, łapać","gripe / grep / grepet"},{"29","iść","gå / gikk / gått"},{"30","mieć","ha / hadde / hatt"},
            {"31","robić zakupy","handle / handlet / handlet"},{"32","wisieć","henge / hengte / hengt"},{"33","przynieść","hente / hentet / hentet"},{"34","nazywać się","hete / hette / hett"},{"35","pozdrawiać, witać","hilse / hilste / hilst"},{"36","blokować, tarasować","hindre / hindret / hindret"},{"37","pomagać","hjelpe / hjalp / hjulpet"},{"38","trzymać","holde / holdt / holdt"},{"39","skakać","hoppe / hoppet / hoppet"},{"40","pamiętać","huske / husket / husket"},
            {"41","słyszeć","høre / hørte / hørt"},{"42","mieć nadzieję","håpe / håpet / håpet"},{"43","interesować się","interessere / innteresserte / innteressert"},{"44","pracować","jobbe / jobbet / jobbet"},{"45","biegać, uprawiać jogging","jogge / jogget / jogget"},{"46","nazywać","kalle / kalte / kalt"},{"47","rzucać","kaste / kastet / kastet"},{"48","patrzeć, zerkać","kikke / kikket / kikket"},{"49","znać","kjenne / kjente / kjent"},{"50","kupować","kjøpe / kjøpte / kjøpt"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer    random= rand.nextInt(50) ;
    private String cutString = new String();
    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int numberWordInt;
    private int shift =150;
    private int wordNumberAfterAddition;
    private String wordNumberString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        message =(TextView) findViewById(R.id.tvMessage);
        wordNumber =(TextView) findViewById(R.id.word_number);

        message.setText(tab[random][1]);
        //ZWIEKSZENIE NUMERU FISZKI POPRZEZ DODANIE SETEK, ZAMIANA STRING NA INT -> DODANIE SETEK -> ZAMIANA INT NA STRING
        wordNumber.setText(returnWordNumber());

        view  = this.getWindow().getDecorView();
        view.setBackgroundResource(R.drawable.gradient_grey);
        // PRZYCISK "DALEJ"
        bNext =(Button) findViewById(R.id.b_next);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer currentRandom =random;
                flag =1;
                // PĘTLA UNIEMOŻLIWIAJĄCA POWTARZANIE SIĘ FISZEK
                // -->
                while(currentRandom==random)
                {
                    random = rand.nextInt(50);
                }
                // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tab[random][1]);
                wordNumber.setText(returnWordNumber());
                view.setBackgroundResource(R.drawable.gradient_grey);

            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        bReverse =(Button) findViewById(R.id.b_ChangeText);
        bReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordNumber.setText(returnWordNumber());
                cutString= tab[random][2].substring(0,3);
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
                    case 0:   message.setText(tab[random][1]);flag =1;
                        break;
                    case 1:   message.setText(tab[random][2]);flag =0;
                        break;
                }
            }
        });
        //<--PRZYCISK ZMIANY JEZYKA FISZKI
    }

    private String returnWordNumber(){
        numberWordInt = Integer.parseInt(tab[random][0]);
        wordNumberAfterAddition = numberWordInt + shift;
        wordNumberString = String.valueOf(wordNumberAfterAddition);
        return wordNumberString;
    }
}
