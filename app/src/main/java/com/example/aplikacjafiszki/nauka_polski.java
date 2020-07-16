package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class nauka_polski extends AppCompatActivity {
    private Random rand= new Random();
    private Button b_obroc;
    private Button b_nastepna;
    private TextView message;
    private TextView numer_fiszki;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
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
    //FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- INNY
    private Integer flag =1;
    private Integer losowa= rand.nextInt(100) ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nauka_polski);

        message =(TextView) findViewById(R.id.tvMessage);
        numer_fiszki=(TextView) findViewById(R.id.numer_fiszki);

        message.setText(tablica[losowa][1]);
        numer_fiszki.setText(tablica[losowa][0]);

        // PRZYCISK "DALEJ"
        b_nastepna=(Button) findViewById(R.id.b_nastepna);
        b_nastepna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer aktualna_losowa =losowa;
                flag =1;
                // PĘTLA UNIEMOŻLIWIAJĄCA POWTARZANIE SIĘ FISZEK
                // -->
               while(aktualna_losowa==losowa)
                    {
                    losowa = rand.nextInt(100);
                    }
               // <--
                //ZMIANA FISZKI ORAZ ZMIANA NUMERU FISZKI
                message.setText(tablica[losowa][1]);
                numer_fiszki.setText(tablica[losowa][0]);
            }
        });

        //PRZYCISK ZMIANY JEZYKA FISZKI -->
        b_obroc =(Button) findViewById(R.id.bChangeText);
        b_obroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numer_fiszki.setText(tablica[losowa][0]);
                switch(flag) {
                    case 0:   message.setText(tablica[losowa][1]);flag =1; break;
                    case 1:   message.setText(tablica[losowa][2]);flag =0; break;
                }
            }
        });
        //<--PRZYCISK ZMIANY JEZYKA FISZKI
    }
}
