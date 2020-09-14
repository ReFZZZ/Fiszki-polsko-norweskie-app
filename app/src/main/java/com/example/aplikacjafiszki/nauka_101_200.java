package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_101_200 extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tablica = {
            {"1","małpa","en ape"},{"2","pomarańcza","en appelsin"},{"3","samochód","en bil"},{"4","bilet","en billett"},{"5","sklep","en butikk"},{"6","ryba","en fisk"},{"7","widelec","en gaffel"},{"8","dług","en gjeld"},{"9","gość","en gjest"}, {"10","kino","en kino"},
            {"11","sukienka","en kjole"},{"12","kapelusz","en hatt"},{"13","miesiąc","en måned"},{"14","ser","en øst "},{"15","plecak","en ryggsekk"},{"16","szapon","en sjampo"},{"17","łyżka","en skje"},{"18","szef","en sjef"},{"19","morze","en sjø"},{"20","rower","en sykkel"},
            {"21","monitor","en skjerm"},{"22","wycieczka","en tur"},{"23","pies","en hund"},{"24","przyjaciel","en venn"},{"25","dzień","en dag"},{"26","godzina","en time"},{"27","data","en dato"},{"28","córka","ei datter"},{"29","kurtka","ei jakke"},{"30","żona","ei kone"},
            {"31","matka","ei mor"},{"32","śliwka","ei plomme"},{"33","szynka","ei skinke"},{"34","koszulka","ei skjorte"},{"35","siostra","ei søster"},{"36","tydzień","ei uke"},{"37","przyjaciółka","ei venninne"},{"38","noc","ei natt"},{"39","zeszyt","et hefte"},{"40","mapa","et kart"},
            {"41","lodówka","et kjøleskap"},{"42","kurs","et kurs"},{"43","skóra","et skinn"},{"44","statek","en skip"},{"45","szal","et skjerf"},{"46","pogoda","et væer"},{"47","piekarnia","et bakeri"},{"48","krawat","et slips"},{"49","dziecko","et barn"},{"50","stół","et bord"},
            {"51","minuta","et minutt"},{"52","rok","et år"},{"53","płacić","å betale"},{"54","powtórzyć","å gjenta"},{"55","odpoczywać","å hvile"},{"56","kupować","å kjøpe"},{"57","dziać się","å skje"},{"58","rozumieć","å skjønne"},{"59","obudzić się","å våkne"},{"60","mówić","å snakke"},
            {"61","zawsze","alltid"},{"62","co?","hva?"},{"63","kto?","hvem?"},{"64","w jaki sposób?","hvordan?"},{"65","dlaczego?","hvorfor?"},{"66","biały","hvit"},{"67","czarny","svart"},{"68","brązowy","brun"},{"69","zielony","grønn"},{"70","niebieski","blå"},
            {"71","szary","grå"},{"72","zółty","gul"},{"73","czerwony","rød"},{"74","pomarańczowy","oransje"},{"75","różowy","rosa"},{"76","fioletowy","fiolett"},{"77","poniedziałek","mandag"},{"78","wtorek"," tirsdag"},{"79","środa","onsdag"},{"80","czwartek","torsdag"},
            {"81","piątek","fredag"},{"82","sobota"," lørdag"},{"83","niedziela","søndag"},{"84","stąd","herfra"},{"85","bardzo","veldig"},{"86","ale","men"},{"87","do","til"},{"88","wszystko","alt"},{"89","nigdy","aldri"},{"90","może","kanskje"},
            {"91","dobrze","greit"},{"92","bez(czegoś)","uten"},{"93","dokładnie","akkurat"},{"94","ostatni","siste"},{"95","świeży","fersk"},{"96","lub","eller"},{"97","tutaj","hit"},{"98","od","fra"},{"99","obok","forbi"},{"100","wzdłuż","langs"},
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer    random= rand.nextInt(100) ;
    private String cutString = new String();
    private int nrFiszkiInt;
    private int przesuniecie =100;
    private int nrFiszkiPoDodaniu;
    private String numerFiszki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauka_1_100);

        message =(TextView) findViewById(R.id.tvMessage);
        numer_fiszki=(TextView) findViewById(R.id.numer_fiszki);

        message.setText(tablica[random][1]);
        //ZWIEKSZENIE NUMERU FISZKI POPRZEZ DODANIE SETEK, ZAMIANA STRING NA INT -> DODANIE SETEK -> ZAMIANA INT NA STRING
        nrFiszkiInt = Integer.parseInt(tablica[random][0]);
        nrFiszkiPoDodaniu = nrFiszkiInt + przesuniecie;
        numerFiszki = String.valueOf(nrFiszkiPoDodaniu);
        numer_fiszki.setText(numerFiszki);

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
                    random = rand.nextInt(100);
                }
                // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tablica[random][1]);
                nrFiszkiInt = Integer.parseInt(tablica[random][0]);
                nrFiszkiPoDodaniu = nrFiszkiInt + przesuniecie;
                numerFiszki = String.valueOf(nrFiszkiPoDodaniu);
                numer_fiszki.setText(numerFiszki);
                view.setBackgroundResource(R.color.standard);

            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        b_obroc =(Button) findViewById(R.id.bChangeText);
        b_obroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numer_fiszki.setText(tablica[random][0]);
                cutString= tablica[random][2].substring(0,3);
                //SPRAWDZENIE RODZAJNIKA W JEZYKU NORWESKIM, W ZALEZNOSCI OD NIEGO ZMIENA SIE KOLOR TŁA APLIKACJI
                switch (cutString){
                    case "en " : {view.setBackgroundResource(R.color.blue);break;}
                    case "ei " : {view.setBackgroundResource(R.color.red);break;}
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
}
