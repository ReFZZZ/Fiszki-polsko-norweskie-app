package com.example.aplikacjafiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class words_1_50 extends AppCompatActivity {
    private Random rand= new Random();
    private Button bReverse;
    private Button bNext;
    private TextView message;
    private TextView wordNumber;

    //ZBIÓR WSZYSTKICH SŁOW GDZIE {"NUMER_FISZKI","SLOWO_POLSKIE","SLOWO_W_JEZYKU_OBCYM"},
    //W ZALEZNOSCI OD WYBRANEGO ZESTAWU ID FISZKI PRZY WYSWIETLANIU BEDZIE ZWIEKSZANE O KONKRETNA LICZBE SETEK
    public String[][] tab = {
            {"1","kot","en katt"},{"2","pies","en hund"},{"3","koń","en hest"},{"4","mysz","en/ei mus"},{"5","rekin","en hai"},{"6","koza","en/ei geit"},{"7","lew","en/ei løve"},{"8","ryś","en/ei gaupe"},{"9","świnia","en gris"}, {"10","małpa","en/ei ape"},
            {"11","jeleń","en hjort"},{"12","lis","en rev"},{"13","niedźwiedź","en bjørn"},{"14","wilk","en ulv "},{"15","krowa","en/ei ku"},{"16","owca","en sau"},{"17","ryba","en fisk"},{"18","osioł","et esel"},{"19","kaczka","en/ei and"},{"20","wąż","en slange"},
            {"21","ptak","en fugl"},{"22","wiewiórka","en ekorn"},{"23","królik","en kanin"},{"24","krokodyl","en krokodille"},{"25","tygrys","en tiger"},{"26","wół","en okse"},{"27","kura","en høne"},{"28","kogut","en hane"},{"29","kurczak","en kylling"},{"30","orzeł","en/ei ørn"},
            {"31","biały","hvit"},{"32","czarny","svart"},{"33","szary","grå"},{"34","niebieski","blå"},{"35","zielony","grønn"},{"36","brązowy","brun"},{"37","czerwony","rød"},{"38","żółty","gul"},{"39","różowy","rosa"},{"40","pomarańczowy","oransje"},
            {"41","fioletowy","lilla"},{"42","owoce","frukt"},{"43","jabłko","et eple"},{"44","pomarańcza","en appelsin"},{"45","gruszka","en/ei pære"},{"46","truskawka","et jordbær"},{"47","malina","et bringebær"},{"48","jagoda","et blåbær"},{"49","śliwka","en/ei plomme"},{"50","winogrono","en/ei drue"}
    };
    View view;
    // FLAGA SLUŻY DO ZMIANY JEZYKA. GDZIE 0- POLSKI, 1- NORWESKI
    private Integer flag =1;
    // ZIENNA losowa SŁUŻY DO WYLOSOWANIA NOWEGO NUMERU FISZKI
    private Integer random= rand.nextInt(50) ;
    private String cutString = new String();
    // POLA SLUZACE DO PRZESUNIECIA NUMERU FISZEK O SETKI
    private int numberWordInt;
    private int shift =0;
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
