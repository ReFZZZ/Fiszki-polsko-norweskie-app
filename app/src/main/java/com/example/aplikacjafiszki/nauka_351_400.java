package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_351_400 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","całkiwicie, zupełnie","aldeles"},{"2","najbardziej","aller"},{"3","zbyt, za bardzo","altfor"},{"4","tylko","bare"},{"5","zupełnie","fullstendig"},{"6","całkiem","ganske"},{"7","zupełnie","helt"},{"8","prawie","nesten"},{"9","normalnie","vanlig"}, {"10","bardzo","veldig"},
            {"11","cały","hel"},{"12","w środku","inne"},{"13","tutaj","her"},{"14","na górze","oppe "},{"15","na zewnątrz","utte"},{"16","nie ma go","han er borte"},{"17","na dole","nede"},{"18","tam","der"},{"19","stąd","herfra"},{"20","stamtąd","derfra"},
            {"21","ostrze","et blad"},{"22","deska","et brett"},{"23","młotek","en hammer"},{"24","miotła","en kost"},{"25","szczotka","en børste"},{"26","wiadro","ei bøtte"},{"27","łańcuch","et kjede"},{"28","szufelka","et feiebrett"},{"29","piła łańcuchowa","ei motorsag"},{"30","piła tarczowa","ei sirkelsag"},
            {"31","dłuto","en meisel"},{"32","wiertarka","en boremaskin"},{"33","przerwa","en pause"},{"34","koniec","en slutt"},{"35","pośpiech","et rush"},{"36","kwadrat","et kvadrat"},{"37","trójkąt","et triangel"},{"38","trapez","et trapes"},{"39","koło","en sirkel"},{"40","sześcian","en kube"},
            {"41","poziomica","et vaterpass"},{"42","gwóżdż","en spiker"},{"43","śrubokręt","en skrutrekker"},{"44","pędzel","en pensel"},{"45","skrzynka na narzędzia","en/ei verktøykasse"},{"46","kombinerki","en universaltang"},{"47","piła ręczna","en håndsag"},{"48","drabina","en stige"},{"49","kleszcze","en/ei tang"},{"50","taśma miernicza","et målebånd"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();

    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =350;
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
