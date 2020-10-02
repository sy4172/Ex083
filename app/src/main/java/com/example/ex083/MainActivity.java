package com.example.ex083;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    ListView lv;
    Spinner continentsSpin, countriesSpin;
    TextView citizens, area;
    ArrayAdapter<String> adp;
    int selectContinent, selectCountry;
    String [] continent = {"Continent","America","Africa","Asia","Europe"};

    String [][] countries  = {{"Country","Brazil", "Chile", "Argentina ", "Peru", "Venezuela", "Mexico","USA"},
            {"Country","Sudan", "Morocco", "Algeria", "Egypt", "Chad", "Cameroon","Ethiopia"},
            {"Country","Israel", "Japan", "India", "Russia", "Iran", "Iraq","China"},
            {"Country","Spain", "Italy", "France", "Germany", "Netherlands", "Portugal","UK"}};

    String [][] info = {{"São Paulo","Rio de Janeiro","Belo Horizonte","Brasilia","Porto Alegre"}, // AMERICA (Brazil)
            {"21,391,624","12,377,505","5,915,536","4,366,901","4,293,050"},
            {"1,521.11 km^2","1,221 km^2","330.9 km^2","5,802 km^2","496.827 km^2"},
            {"Arica","Iquique","Alto Hospicio","Pozo Almonte","Antofagasta"}, // Chile
            {"222,619","191,468","94,441","15,711","352,638"},
            {"4,799.4 km^2","2,242.1 km^2","593.2 km^2","13,765.8 km^2","30,718.1 km^2"},
            {"Buenos Aires","Cordoba","Rosario","Mendoza","La Plata"}, // Argentina
            {"13,588,171","1,454,645","1,236,089","937,154","794,327"},
            {"203 km^2","576 km^2","178.69 km^2","54 km^2","203 km^2"},
            {"Lima","Arequipa","Trujillo","Chiclayo","Piura"}, // Peru
            {"9,562,280","1,008,290","919,899","552,508","473,025"},
            {"2,672.3 km^2","2,923.53 km^2","1,100 km^2","174.46 km^2","621.2 km^2"},
            {"Isla Ratón","Guanta","Maroa","Onoto","El Tigre"}, // Venezuela
            {"3,000","35,000","890","12,358","151,011"},
            {"40 km^2","67 km^2","14,250 km^2","1,741 km^2","35 km^2"},
            {"Mexico City","Ecatepec","Guadalajara","Puebla City","Ciudad Juárez"}, // Mexico
            {"8,851,080","1,655,015","1,495,182","1,434,062","1,321,004"},
            {"1,485 km^2","160.17 km^2","151 km^2","534.32 km^2","321.19 km^2"},
            {"New York City","Augusta","Austin","Charlotte","Lexington"}, // USA
            {"8,175,133","195,844","790,390","731,424","295,803"},
            {"1,213 km^2","794 km^2","790 km^2","776 km^2","740 km^2"},
            {"Omdurman","Khartoum","Khartoum North","Nyala","Port Sudan"}, // AFRICA (Sudan)
            {"1,849,659","1,410,858","1,012,211","492,984","394,561"},
            {"614.9 km^2","22,142 km^2","Not mentioned","Not mentioned","Not mentioned"},
            {"Casablanca","Fez","Tangier","Marrakesh","Rabat"}, // Morocco
            {"3,359,818","1,112,072","947,952","928,850","577,827"},
            {"220 km^2","320 km^2","Not mentioned","Not mentioned","117 km^2"},
            {"Algiers","Oran","Constantine","Batna","Djelfa"}, // Algeria
            {"2,481,788","609,940","448,374","290,645","289,226"},
            {"1,190 km^2","2,121 km^2","2,288 km^2","85 km^2","Not mentioned"},
            {"Cairo","Asyut","Alexandria","Benha","Belbeis"}, // Egypt
            {"9,908,788","389,307","5,200,000","165,906","407,300"},
            {"3,085.12 km^2","Not mentioned","2,679 km^2","Not mentioned","Not mentioned"},
            {"N'Djamena","Moundou","Sarh","Abéché","Kélo"}, // Chad
            {"951,418","137,929","103,269","76,492","45,224"},
            {"166 km^2","Not mentioned","Not mentioned","Not mentioned","Not mentioned"},
            {"Abong-Mbang","Bali","Akonolinga","Ambam","Bafang"}, // Cameroon
            {"18,700","32,000","21,299","1,596","33,324"},
            {"Not mentioned","Not mentioned","Not mentioned","Not mentioned","Not mentioned"},
            {"Addis Ababa","Mekelle","Gondar","Adama","Hawassa"}, // Ethiopia
            {"13,352,000","441,991","740,859","338,940","318,618"},
            {"527 km^2","Not mentioned","192.27 km^2","Not mentioned","50 km^2"},
            {"Jerusalem","Beer Sheva","Tel Aviv-Yafo","Haifa","Eilat"}, // ASIA (Israel)
            {"936,425","209,687","402,600","285,316","52,299"},
            {"125.2 km^2","117.5 km^2","51.8 km^2","63.7 km^2","84.8 km^2"},
            {"Nagoya","Toyohashi","Okazaki","Ichinomiya","Seto"}, // Japan
            {"2,283,289","377,045","371,380","375,939","132,311"},
            {"326.45 km^2","261.35 km^2","387.24 km^2","113.91 km^2","111.61 km^2"},
            {"Mumbai","Delhi","Bangalore","Hyderabad","Ahmedabad"}, // India
            {"12,442,373","11,007,835","8,436,675","6,809,970","5,570,585"},
            {"4,355 km","1,484 km^2","8,005 km^2","7,257 km^2","464.16 km^2"},
            {"Moscow","Saint Petersburg","Novosibirsk","Yekaterinburg","Kazan"}, // Russia
            {"12,480,481","5,398,064","1,625,631","1,493,749","1,257,391"},
            {"2,511 km^2","1,439 km^2","502.7 km^2","495 km^2","425.3 km^2"},
            {"Tehran","Mashhad","Isfahan","Karaj","Shiraz"}, // Iran
            {"9,033,000","3,372,090","2,000,000","1,592,492","1,565,572"},
            {"1,200 km^2","351 km^2","551 km^2","162 km^2","240 km^2"},
            {"Basra","Baghdad","Duhok","Haditha","Ar Rutba"}, // Iraq
            {"1,326,564","8,126,755","~340,900","46,500","28,400"},
            {"50-75 km^2","673 km^2","Not mentioned","Not mentioned","Not mentioned"},
            {"Shanghai","Beijing","Shenzhen","Guangzhou","Wuhan"}, // China
            {"24,183,300","18,766,000","12,528,300","11,849,900","8,684,800"},
            {"4,000 km^2","4,144 km^2","1,748 km^2","3,843.43 km^2","1,528 km^2"},
            {"Madrid","Melilla","Barcelona","Valencia","Seville"}, // EUROPE (Spain)
            {"3,255,944","86,384","1,621,537","814,208","703,206"},
            {"604.31 km^2","12.3 km^2","101.4 km^2","628.81 km^2","140 km^2"},
            {"Rome","Milan","Naples","Turin","Palermo"}, // Italy
            {"2,837,332","1,396,059","962,589","870,952","657,960"},
            {"1,285 km^2","181.76 km^2","119.02 km^2","130.17 km^2","158.9 km^2"},
            {"Paris","Marseille","Lyon","Toulouse","Nice"}, // France
            {"2,187,526","863,310","516,092","479,553","340,017"},
            {"105.4 km^2","240.62 km^2","1,171.1 km^2","118.3 km^2","71.92 km^2"},
            {"Berlin","Hamburg","München","Köln","Frankfurt"}, // Germany
            {"3,562,166","1,751,775","1,407,836","1,034,175","701,350"},
            {"891.1 km^2","755.22 km^2","310.43 km^2","405.15 km^2","248.31 km^2"},
            {"Amsterdam","Rotterdam","The Hague","Utrecht","Eindhoven"}, // Netherlands
            {"741,636","598,199","474,292","290,529","209,620"},
            {"165.76 km^2","217.55 km^2","82.45 km^2","93.83 km^2","87.66 km^2"},
            {"Abrantes","Agualva-Cacém","Águeda","Albergaria-a-Velha","Albufeira"}, // Portugal
            {"18,600","81,845","11,357","25,252","16,237"},
            {"714.69 km^2","127 km^2","335.27 km^2","158.83 km^2","140.66 km^2"},
            {"Aberdeen","Armagh","Bangor","Bath","Belfast"}, // United Kingdom
            {"189,120","14,777","18,808","88,859","333,871"},
            {"185.7 km^2","Not mentioned","Not mentioned","0.029 km^2","132.5 km^2"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        continentsSpin = findViewById(R.id.continentsSpin);
        countriesSpin = findViewById(R.id.countriesSpin);
        citizens = findViewById(R.id.citizens);
        area = findViewById(R.id.area);

        continentsSpin.setOnItemSelectedListener(this);
        countriesSpin.setOnItemSelectedListener(this);
        adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continent);
        continentsSpin.setAdapter(adp);

        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.continentsSpin){
            if (position != 0){
                selectContinent = position-1;
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[selectContinent]);
                countriesSpin.setAdapter(adp);
            }
            else{
                citizens.setText("");
                area.setText("");
                lv.setAdapter(null);
                countriesSpin.setAdapter(null);
            }
        }
        else{
            if (position != 0){
                citizens.setText("");
                area.setText("");
                selectCountry = position-1;
                adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, info[selectCountry*3+selectContinent*21]);
                lv.setAdapter(adp);
            }
            else{
                citizens.setText("");
                area.setText("");
                lv.setAdapter(null);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        citizens.setText(info[selectCountry*3+selectContinent*21+1][position]);
        area.setText(info[selectCountry*3+selectContinent*21+2][position]);
    }
}