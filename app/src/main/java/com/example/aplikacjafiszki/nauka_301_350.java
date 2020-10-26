package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_301_350 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","jeden","en"},{"2","dwa","to"},{"3","trzy","tre"},{"4","cztery","fire"},{"5","pięć","fem"},{"6","sześć","seks"},{"7","siedem","sju / syv"},{"8","osiem","åtte"},{"9","dziewięć","ni"}, {"10","dziesięć","ti"},
            {"11","jedenaście","elleve"},{"12","dwanaście","tolv"},{"13","trzynaście","tretten"},{"14","czternaście","fjorten"},{"15","piętnaście","femten"},{"16","szesnaście","seksten"},{"17","siedemnaście","sytten"},{"18","osiemnaście","atten"},{"19","dziewiętnaście","nitten"},{"20","dwadzieścia","tjue"},
            {"21","dwadzieścia jeden","tjueen"},{"22","dwadzieścia dwa","tjueto"},{"23","trzydzieści","tretti"},{"24","trzydzieści jeden","trettien"},{"25","czterdzieści","førti"},{"26","pięćdziesiąt","femti"},{"27","sześćset","seksti"},{"28","siedemdziesiąt","sytti"},{"29","osiemdziesiąt","åtti"},{"30","dziewiećdziesiąt","nitti"},
            {"31","sto","hundre"},{"32","sto jeden","hundre og en"},{"33","dwieście","to hundre"},{"34","tysiąc","tusen"},{"35","dwa tysiące","to tusen"},{"36","dziesięć tysięcy","ti tusen"},{"37","sto tysięcy","hundre tusen"},{"38","milion","en million"},{"39","osiemset piećdziesiąt sześć","åtte hundre og femtiseks"},{"40","pierwszy","første"},
            {"41","drugi","andre"},{"42","trzeci","tredje"},{"43","czwarty","fjerde"},{"44","piąty","femte"},{"45","szósty","sjette"},{"46","siódmy","sjuende / syvende"},{"47","ósmy","åttende"},{"48","jedenasty","ellevte"},{"49","trzynasty","trettende"},{"50","trzydziesty","trettiende"}
    };
    View view;

    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;

    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();

    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int nrFiszkiInt;
    private int przesuniecie =300;
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
